<%@page import="rech.bolao.bean.User"%>
<%@page import="rio2016.bean.Rio2016User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rio2016.util.Rio2016SessionUtil"%>
<%@ page session="true" %>
<%@ page import="rech.bolao.util.BaseSessionUtil"%>

<!DOCTYPE HTML>
<html>
<head>
	<title>RIO 2016</title>
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
	<link rel="icon" type="image/png" sizes="16x16" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/favicon-16x16.png">		<meta charset="utf-8" />
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
					<img height="265" width="1160" src="http://www.fina.org/sites/default/files/slider-images/hp_banner_rio2016.jpg">
				</div>
			</div>
		</div>
		<div id="main">
			<div class="container">
				<% if(session.getAttribute(BaseSessionUtil.LOGGED_USER) == null) {%>
				<div class="row main-row">
					<div class="12u">
						<h3>Voc� n�o est� conectado!</h3>
					</div>
				</div>
				<% }  %>
				<div class="row main-row">
					<%
					User u = (User) session.getAttribute(BaseSessionUtil.LOGGED_USER);
					if (u != null) {
					%>
					<div class="4u 12u(mobile)">
						<section>
							<%
								if(u.getRole().equalsIgnoreCase("admin") || BaseSessionUtil.isUserEnrolled(session, "Rio 2016")) {
							%>
								<h2>Voc� j� est� registrado!</h2>
								<p>Voc� ainda pode cancelar sua participa��o at� 1 dia antes de come�arem as competi��es atrav�s do bot�o abaixo!</p>
								<p>Utilize o menu no topo para navegar para a p�gina de apostas</p>
								<p><a href="../RegisterServlet?ballot=Rio%202016" class="button">Sair do Bol�o</a></p>
							<%
								} else {
							%>
								<h2>Voc� ainda n�o est� registrado!</h2>
								<p>N�o perca mais tempo!</p>
								<p><a href="../RegisterServlet?ballot=Rio%202016" class="button">Registre-se</a></p>
							<%
								}
							%>
						</section>
					</div>
					<%
					}
					%>
					<div class="4u 12u(mobile)">
						<section>
							<h2>Regras</h2>
							<p>
							Os participantes apostar�o nos medalhistas (ouro, prata, bronze) de diversas modalidades. 
							As apostas dever�o ser realizadas at� o dia anterior ao in�cio de cada modalidade.
							</p>
							<h4>Pontua��o</h4>
							<ul>
							<li>Acertar o medalhista de ouro: 100 pts</li>
							<li>Acertar o medalhista de prata: 80 pts</li>
							<li>Acertar o medalhista de bronze: 60 pts</li>
							<li>Acertar um medalhista sem acertar a posi��o correta: 35 pts</li>
							</ul>
							<p>
							Ao final das olimp�adas, o participante com maior pontua��o ser� declarado campe�o.
							</p>
							<p>
							O valor para participar do bol�o � de R$25,00 n�o necessitando pagar adiantado. Ao final do bol�o o campe�o receber� 60% do arrecadado, o vice receber� 30%, e o terceiro colocado, 10%.<br>
							Nesse momento os particpantes ir�o fazer o pagamento das suas taxas de participa��o diretamente aos vencedores.
							</p>
						</section>
					</div>
					<div class="4u 12u(mobile)">
						<section>
							<h2>Classifica��o</h2>
								<%
									ArrayList<Rio2016User> users = (ArrayList<Rio2016User>) session.getAttribute(Rio2016SessionUtil.ALL_USERS);
									if(users!= null && users.size()>0) {
										int count = 0;
										for (Rio2016User user : users) {
											count ++;
											if(count==1) {
											%><span style='font-size:larger'><%=user.getUser().getUsername() %> <%=user.getScore() %> pts</span><br><% 
											} else {
											%><%=user.getUser().getUsername() %> <%=user.getScore() %> pts<br><% 
											}
										}
									} else {
										%>
										<p><h4>Nenhum usu�rio registrado no momento.</h4></p>
										<p>Seja o primeiro a <a href="../RegisterServlet">registrar-se</a>
										<%
									}
								%>
						</section>
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

