<%@page import="rech.bolao.bean.UserBolao"%>
<%@page import="rech.bolao.bean.Bolao"%>
<%@page import="java.util.ArrayList"%>
<%@ page session="true"%>
<%@ page import="rech.bolao.util.BaseSessionUtil"%>


<!DOCTYPE HTML>
<html>
<head>
	<title>BOLAO-RECH</title>
	<link rel="apple-touch-icon" sizes="57x57" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/favicon-16x16.png">	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
</head>
<body>
	<div id="page-wrapper">
		<jsp:include page="header.jsp">
			<jsp:param name="currpage" value="home" />
		</jsp:include>
		<div id="banner-wrapper">
			<div class="container">
				<div id="banner">
					<a href="rio2016/home.jsp">	<img height="265" width="1160" src="http://www.teachingideas.co.uk/sites/default/files/styles/718w/public/bannerolympics2016.jpg?itok=2IKSWTzP"> </a>
				</div>
			</div>
		</div>
		<div id="main">
			<div class="container">
				<% if(session.getAttribute(BaseSessionUtil.LOGGED_USER) == null) {%>
				<div class="row main-row">
					<div class="12u">
						<h3>Você não está conectado!</h3>
					</div>
				</div>
				<% }  %>
				<% 
				String msg = (String) session.getAttribute(BaseSessionUtil.MESSAGE);
				if (msg != null) {
				%>
				<div class="row main-row">
					<div class="12u">
						<h3><%=msg%></h3>
					</div>
				</div>
				<% 
					BaseSessionUtil.clearSessionMessage(session);
				}  
				%>
				<div class="row main-row">
					<div class="4u 12u(mobile)">
						<section>
							<h2>Bolões disponíveis</h2>
							<div>
								<div class="row">
									<ul class="link-list">
										<%
											{
												ArrayList<Bolao> entries = (ArrayList<Bolao>) session.getAttribute(BaseSessionUtil.ALL_BALLOTS);
												for (Bolao entry : entries) {
													if (entry.getAvailable() == 1) {
										%>
										<li><a href="./<%=entry.getFolderName()%>/home.jsp" class="button"><%=entry.getDescription()%></a></li>
										<%
													}
												}
											}
										%>
									</ul>
								</div>
							</div>
							<p>
								Clique no link acima para ver a página do bolão. Se ainda não
								houver se registrado, o botão para <strong>participar</strong>,
								estará disponível.
							</p>
						</section>
					</div>
					<div class="4u 12u(mobile)">
							<h2>Bolões em andamento</h2>
										<%
											{
													ArrayList<Bolao> entries = (ArrayList<Bolao>) session.getAttribute(BaseSessionUtil.ALL_BALLOTS);
													for (Bolao entry : entries) {
														if (entry.getAvailable() == 0 && entry.getCompleted() == 0) {
										%>
						<section>
										<ul><li><a href="./<%=entry.getFolderName()%>/home.jsp"><%=entry.getDescription()%></a></li></ul>
										<%
										int count = 0;
										for (UserBolao ub : entry.getRegisteredUsers()) {
											count ++;
											if(count==1) {
											%><p><h4><%=ub.getUser().getUsername() %> <%=ub.getUserScore() %> pts</h4></p><% 
											} else {
											%><%=ub.getUser().getUsername() %> <%=ub.getUserScore() %> pts<br><% 
											}
										}
											}
						%>
						</section>
						<%
													}
												}
										%>

					</div>
					<div class="4u 12u(mobile)">
							<h2>Bolões finalizados</h2>
										<%
											{
													ArrayList<Bolao> entries = (ArrayList<Bolao>) session.getAttribute(BaseSessionUtil.ALL_BALLOTS);
													for (Bolao entry : entries) {
														if (entry.getCompleted() == 1) {
										%>
						<section>
										<h3><%=entry.getDescription()%></h3>
										<%
										int count = 0;
										for (UserBolao ub : entry.getRegisteredUsers()) {
											count ++;
											if(count==1) {
											%><p><h4><%=ub.getUser().getUsername() %> <%=ub.getUserScore() %> pts</h4></p><% 
											} else {
											%><%=ub.getUser().getUsername() %> <%=ub.getUserScore() %> pts<br><% 
											}
										}
											}
						%>
						</section>
						<%
													}
												}
										%>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/skel-viewport.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>
