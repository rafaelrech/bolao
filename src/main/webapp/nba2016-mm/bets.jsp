<%@ page session="true" %>
 
<!doctype html>
<html lang="en">
	<head>
		<title>NBA 2016 PLAYOFFS</title>
		<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
		<script src="http://underscorejs.org/underscore-min.js"></script>
		<script src="./js/bracket.js"></script>
		<link rel="stylesheet" href="css/bracket.css">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<link rel="apple-touch-icon" href="http://i.cdn.turner.com/nba/tmpl_asset/static/nba-cms3-homepage/1577/elements/global/nba-logo.png" />
		<link rel="shortcut icon" type="image/x-icon" href="http://i.cdn.turner.com/nba/tmpl_asset/static/nba-cms3-homepage/1577/elements/global/nba-logo.png" />
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	</head>
<body>
<%
	if (session.getAttribute(BaseSessionUtil.LOGGED_USER) == null){
		session.setAttribute (BaseSessionUtil.LOGIN_REDIRECT, request.getRequestURI());
	    response.sendRedirect("login.jsp");
	}
	else 
	{
%>
 	<section class='container'>
<jsp:include page="header.jsp">
	<jsp:param name="currpage" value="bets" />
</jsp:include>

	 	<%--@ include file="header.jsp" --%>
	 	
	 	
 		<div class="row">
 				<%@ include file="bracket2.jsp" %>
 				<HR>
 			 	<%@ include file="games.jsp" %>
<%--
			<section class='scol-sm-6 col-md-6'>
			</section>
			<section class='col-xs-12 col-sm-6 col-md-6'>
			</section>
 --%> 				
		</div>
	
	</section>
<%
} 
%>
</body>
</html>