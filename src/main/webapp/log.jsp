<%@page import="rech.bolao.util.BaseSessionUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rech.bolao.dao.LoggingDao"%>
<%@page import="rech.bolao.bean.LogEntry"%>
<%@ page session="true" %>
 
!DOCTYPE HTML>
<html>
	<head>
		<title>BOLOES</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="rio2016/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="rio2016/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="rio2016/assets/css/ie9.css" /><![endif]-->
	</head>
<%
if (session.getAttribute(BaseSessionUtil.LOGGED_USER) == null){
	session.setAttribute (BaseSessionUtil.LOGIN_REDIRECT, request.getRequestURI());
    response.sendRedirect("./login.jsp");
}
%>
<script>
	function updateAndSubmit(pAction, pObject, pAnchor) {
		document.getElementById('object').value = pObject;
		document.getElementById('action').value = pAction;
		document.getElementById('target').value = 'db-admin.jsp#' + pAnchor;
		document.getElementById('formus').submit();
	}
</script>

<body>
	<div id="page-wrapper">
		
		<jsp:include page="header.jsp">
			<jsp:param name="currpage" value="dbadm" />
		</jsp:include>

		<div id="main">
			<div class="container">
				<div class="row main-row">
					<div class="12u">
						<section>
							<h2>LOGS</h2>
							<div>
						 	<% 
							ArrayList<LogEntry> logs = (ArrayList<LogEntry>) LoggingDao.getInstance().listAll();
							for (LogEntry entry : logs) {
								%>
								<%=entry.toJson()%>
								<br>
								<%
							}
							%>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>