package nbaplayoffs2016.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nbaplayoffs2016.bean.Nba2016Game;
import nbaplayoffs2016.bean.Nba2016Series;
import nbaplayoffs2016.dao.Nba2016GameDao;
import nbaplayoffs2016.dao.Nba2016SeriesDao;
import nbaplayoffs2016.util.Nba2016DBUtil;
import nbaplayoffs2016.util.Nba2016SessionUtil;
import nbaplayoffs2016.util.Nba2016WebUtil;
import rech.bolao.bean.LogEntry;
import rech.bolao.bean.User;
import rech.bolao.bean.xmlstats.Event;
import rech.bolao.bean.xmlstats.Events;
import rech.bolao.dao.LoggingDao;
import rech.bolao.util.BaseDBUtil;
import rech.bolao.util.BaseSessionUtil;
import rech.bolao.util.xmlstats.XmlStatsUtil;
import rech.bolao.web.WebUtils;

/**
 * Servlet implementation class RunDBServlet
 */
@WebServlet("/nba2016-mm/DBServlet")
public class Nba2016DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Nba2016DBServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String source = request.getParameter("source");
		String target = request.getParameter("target");
		String action = request.getParameter("action");
		String object = request.getParameter("object");
		String sql = request.getParameter("sql");
		String gameId = request.getParameter("game_id");
		String initialDay = request.getParameter("initial_day");
		String finalDay = request.getParameter("final_day");

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("loggedUser");

		if (!u.getRole().equalsIgnoreCase("admin")) {
			fail(response, session, "You are not an admin", getRedirectInfo(source));
			return;
		}
		if (action == null || action.isEmpty()) {
			fail(response, session, "'action' is null or empty", getRedirectInfo(source));
			return;
		}

		if (action.equalsIgnoreCase("EXECUTE")) {
			StringTokenizer st = new StringTokenizer(sql, ";");
			int q = 0;
			while (st.hasMoreElements()) {
				String sql2exec = (String) st.nextElement();
				if (sql2exec.isEmpty()) {
					fail(response, session, "sql is empty", getRedirectInfo(source));
					return;
				}
				if ((sql2exec.toUpperCase().indexOf("UPDATE") > -1 || sql2exec.toUpperCase().indexOf("UPDATE") > -1)
						&& (sql2exec.toUpperCase().indexOf("WHERE") < 0)) {
					fail(response, session, "missing WHERE clause", getRedirectInfo(source));
					return;
				}
				System.out.println(sql2exec);
				q += BaseDBUtil.executeDML(sql2exec);
			}
		}		

		if (action.equalsIgnoreCase("CREATE")) {
			if (object == null || object.isEmpty()) {
				fail(response, session, "'object' is null or empty", getRedirectInfo(source));
				return;
			}
			Nba2016DBUtil.getDaoFromBean(object).createTable();
			BaseSessionUtil.udpateSessionInfo(session, u);
			BaseSessionUtil.setSessionMessage(session, String.format("Table %s created", object));
		}

		if (action.equalsIgnoreCase("DROP")) {
			if (object == null || object.isEmpty()) {
				fail(response, session, "'object' is null or empty", getRedirectInfo(source));
				return;
			}
			Nba2016DBUtil.getDaoFromBean(object).dropTable();
			BaseSessionUtil.udpateSessionInfo(session, u);
			BaseSessionUtil.setSessionMessage(session, String.format("Table %s dropped", object));
		}

		if (action.equalsIgnoreCase("CLEAN")) {
			if (object == null || object.isEmpty()) {
				fail(response, session, "'object' is null or empty", getRedirectInfo(source));
				return;
			}
			Nba2016DBUtil.getDaoFromBean(object).dropTable();
			Nba2016DBUtil.getDaoFromBean(object).createTable();
			BaseSessionUtil.udpateSessionInfo(session, u);
			BaseSessionUtil.setSessionMessage(session, String.format("Table %s created", object));
		}

		if (action.equalsIgnoreCase("LOAD")) {
			if (object == null || object.isEmpty()) {
				fail(response, session, "'object' is null or empty", getRedirectInfo(source));
				return;
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.USER_BEAN)) {
				Nba2016DBUtil.loadUsers();
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.SERIES_BEAN)) {
				Nba2016DBUtil.loadBrackets();
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.SERIES_BET_BEAN)) {
				Nba2016DBUtil.loadBracketBets();
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.GAME_BEAN)) {
				Nba2016DBUtil.loadGames();
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.GAME_BET_BEAN)) {
				Nba2016DBUtil.loadGameBets();
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.TIE_BREAKER_BEAN)) {
				Nba2016DBUtil.loadTieBreakers();
			}
			if (object.equalsIgnoreCase(Nba2016DBUtil.TB_BET_BEAN)) {
				Nba2016DBUtil.loadTieBreakerBets();
			}
			BaseSessionUtil.udpateSessionInfo(session, u);
			BaseSessionUtil.setSessionMessage(session, String.format("Table %s loaded", object));
		}

		if (action.equalsIgnoreCase("DELETE-GAME")) {
			if (gameId == null || gameId.isEmpty()) {
				fail(response, session, "'game' is null or empty", getRedirectInfo(source));
				return;
			}
			int id = new Integer(gameId).intValue();
			Nba2016GameDao.getInstance().delete(id);
			BaseSessionUtil.udpateSessionInfo(session, u);
			BaseSessionUtil.setSessionMessage(session, String.format("Sesion cache flush"));
		}

		if (action.equalsIgnoreCase("LOAD-GAMES")) {
			if (initialDay == null || finalDay == null || initialDay.isEmpty() || finalDay.isEmpty()) {
				fail(response, session, "'range' is null or empty", getRedirectInfo(source));
				return;
			}

			@SuppressWarnings("unchecked")
			ArrayList<Nba2016Game> games = (ArrayList<Nba2016Game>) session.getAttribute(Nba2016SessionUtil.ALL_GAMES);
			for (int i = new Integer(initialDay).intValue(); i <= new Integer(finalDay).intValue(); i++) {
				Events events = XmlStatsUtil.getInstance().queryGames(i);
				if (events != null) {
					for (Event event : events.getEventList()) {
						String eventId = event.getEventId();
						Calendar c = Calendar.getInstance();
						try {
							SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
							c.setTime(sdfInput.parse(event.getStartDateTime()));
						} catch (ParseException e) {
							System.err.println("Error parsing date: " + e.getMessage());
						}

						boolean foundIt = false;
						// 1. LOOK FOR GAME IN MEMORY
						for (Nba2016Game game : games) {
							String externalId = game.getExternalId();
							if (externalId == null) {
								externalId = new String("");
							}
							if (!externalId.isEmpty() && !externalId.equals(eventId)) {
								// externalID is present and different from
								// eventID, skip to next game
								continue;
							}
							if (externalId.isEmpty()) {
								// TODO
							}
							if (externalId.equalsIgnoreCase(eventId)) {
								// 1.a. FOUND IT
								foundIt = true;
								// UPDATE if needed
								game.setCompleted(event.getEventStatus().equalsIgnoreCase("completed") ? 1 : 0);
								game.setHomeScore(event.getHomePointsScored());
								game.setVisitScore(event.getAwayPointsScored());
								game.setData(c);
								game.setOverTime(event.getAwayPeriodsScored().length > 4 ? 1 : 0);
								if (game.getFase() == -1 || game.getBracketId() == -1) {
									// 1.b.1 FIND BRACKET INFO
									ArrayList<Nba2016Series> allSeries = (ArrayList<Nba2016Series>) session
											.getAttribute(Nba2016SessionUtil.ALL_SERIES);
									for (Nba2016Series series : allSeries) {
										if ((series.getTeam1().equals(event.getHomeTeam().getAbbreviation())
												&& series.getTeam2().equals(event.getAwayTeam().getAbbreviation()))
												|| (series.getTeam2().equals(event.getHomeTeam().getAbbreviation())
														&& series.getTeam1()
																.equals(event.getAwayTeam().getAbbreviation()))) {
											game.setBracketId(series.getId());
											game.setSeries(series);
											game.setFase(series.getFase());
											break;
										}
									}
								}
								Nba2016GameDao.getInstance().update(game);
								LoggingDao.getInstance()
										.insert(new LogEntry(0, Calendar.getInstance(), u.getUsername(),
												String.format("Game updated from json. %d (%s) %s-%s em %s (%d-%d%s)%s",
														game.getId(), game.getExternalId(), game.getHomeTeam(),
														game.getVisitTeam(),
														new SimpleDateFormat("MM/dd hh:mm")
																.format(game.getData().getTime()),
														game.getHomeScore(), game.getVisitScore(),
														game.getOverTime() == 1 ? " in OT" : "",
														game.getCompleted() == 1 ? " COMPLETED" : "")));
								// If game completed check if series is over
								if (event.getEventStatus().equalsIgnoreCase("completed")) {
									Nba2016Series series = game.getSeries();
									int team1Wins = 0;
									int team2Wins = 0;
									for (Nba2016Game seriesGame : series.getGames()) {
										if (seriesGame.getHomeScore() > seriesGame.getVisitScore()) {
											if (series.getTeam1().equals(seriesGame.getHomeTeam())) {
												team1Wins++;
											} else {
												team2Wins++;
											}
										}
										if (seriesGame.getHomeScore() < seriesGame.getVisitScore()) {
											if (series.getTeam1().equals(seriesGame.getHomeTeam())) {
												team2Wins++;
											} else {
												team1Wins++;
											}
										}
									}
									if (team1Wins == 4 || team2Wins == 4) {
										series.setWinner(
												((team1Wins > team2Wins) ? series.getTeam1() : series.getTeam2()));
										series.setNbrGames(team1Wins + team2Wins);
										Nba2016SeriesDao.getInstance().update(series);
										for (Nba2016Series upcomingSerie : (ArrayList<Nba2016Series>) session
												.getAttribute(Nba2016SessionUtil.ALL_SERIES)) {
											if (upcomingSerie.getPrevId1() != series.getId()
													&& upcomingSerie.getPrevId2() != series.getId()) {
												continue;
											}
											if (upcomingSerie.getPrevId1() == series.getId()) {
												upcomingSerie.setTeam1(series.getWinner());
											} else {
												upcomingSerie.setTeam2(series.getWinner());
											}
											Nba2016SeriesDao.getInstance().update(upcomingSerie);
										}
									} else {
										series.setWinner("");
										series.setNbrGames(0);
										Nba2016SeriesDao.getInstance().update(series);
									}

								}
							}

						}
						// 1.b. DIDN'T FIND IT
						if (!foundIt) {
							// 1.b.1 FIND BRACKET INFO
							ArrayList<Nba2016Series> allSeries = (ArrayList<Nba2016Series>) session
									.getAttribute(Nba2016SessionUtil.ALL_SERIES);
							int fase = -1;
							int seriesId = -1;
							for (Nba2016Series series : allSeries) {
								if ((series.getTeam1().equals(event.getHomeTeam().getAbbreviation())
										&& series.getTeam2().equals(event.getAwayTeam().getAbbreviation()))
										|| (series.getTeam2().equals(event.getHomeTeam().getAbbreviation())
												&& series.getTeam1().equals(event.getAwayTeam().getAbbreviation()))) {
									seriesId = series.getId();
									fase = series.getFase();
									break;
								}
							}
							// 1.b.2 CREATE NEW GAME
							Nba2016Game game = new Nba2016Game(-1, event.getEventId(), fase, seriesId, c,
									event.getHomeTeam().getAbbreviation(), event.getHomePointsScored(),
									event.getAwayTeam().getAbbreviation(), event.getAwayPointsScored(),
									event.getAwayPeriodsScored().length > 4 ? 1 : 0,
									event.getEventStatus().equals("completed") ? 1 : 0);
							Nba2016GameDao.getInstance().insert(game);
							LoggingDao.getInstance()
									.insert(new LogEntry(0, Calendar.getInstance(), u.getUsername(),
											String.format("Game created from json. %d (%s) %s-%s em %s (%d-%d%s)%s",
													game.getId(), game.getExternalId(), game.getHomeTeam(),
													game.getVisitTeam(),
													new SimpleDateFormat("MM/dd hh:mm")
															.format(game.getData().getTime()),
													game.getHomeScore(), game.getVisitScore(),
													game.getOverTime() == 1 ? " in OT" : "",
													game.getCompleted() == 1 ? " COMPLETED" : "")));
						}
					}
				}
			}

			// 2. FLUSH CACHE
			BaseSessionUtil.udpateSessionInfo(session, u);
			BaseSessionUtil.setSessionMessage(session, String.format("Sesion cache flush"));
		}

		response.sendRedirect(getRedirectInfo(target));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void fail(HttpServletResponse response, HttpSession session, String msg, String targetPage)
			throws IOException {
		BaseSessionUtil.setSessionMessage(session, "FAIL! " + msg);
		response.sendRedirect(targetPage);
	}

	private String getRedirectInfo(String page) {
		return WebUtils.getRedirectInfo(page, Nba2016WebUtil.DBUTIL_JSP);
	}

}
