<%@page import="rech.bolao.bean.CommonBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rio2016.util.Rio2016DBUtil"%>
<%@ page session="true" %>
<%@ page import="rech.bolao.util.BaseSessionUtil"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>RIO 2016</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
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
		<link rel="icon" type="image/png" sizes="16x16" href="https://smsprio2016-a.akamaihd.net/data/content/1.65/images/favicon.ico/favicon-16x16.png">
	</head>
<%
	if (session.getAttribute(BaseSessionUtil.LOGGED_USER) == null){
		session.setAttribute (BaseSessionUtil.LOGIN_REDIRECT, request.getRequestURI());
	    response.sendRedirect("../login.jsp");
	}
	else 
	{
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
	<form method="post" id="formus" action="DBServlet">
		<input type="hidden" name="source" value="db-admin.jsp"> 
		<input type="hidden" id="target" name="target" value="db-admin.jsp"> 
		<input type="hidden" id="action" name="action" value="CREATE"> 
		<input type="hidden" id="object" name="object" value="CREATE">
	</form>
	<div id="page-wrapper">
		
		<jsp:include page="header.jsp">
			<jsp:param name="currpage" value="dbadm" />
		</jsp:include>

		<div id="main">
			<div class="container">
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
					<div class="12u">
						<section>
							<h2>FREE TEXT SQL STATEMENT</h2>
							<div>
								<form method="post" action="DBServlet">
									<input type="hidden" name="action" value="EXECUTE">
									<textarea id="sql" name="sql" rows="8" cols="80"></textarea>
									<br>
									<button type="submit" >submit</button>
								</form>
							</div>
						</section>
					</div>
					<div class="12u">
						<section>
							<h2>Manage Tables</h2>
							<div>
							<% 
							String[] beans = Rio2016DBUtil.beans;
							int counter = 0;
							for (String bean : beans) { counter++; %>
								<a name="bean<%=counter%>"></a>
								<div class="row">
									<p>
									<b><%= bean %></b> 
									<a href="#" onclick="javascript: updateAndSubmit('CREATE', '<%=bean%>', 'bean<%=counter%>')">CREATE</a> 
									<a href="#" onclick="javascript: updateAndSubmit('DROP', '<%=bean%>', 'bean<%=counter%>')">DROP</a> 
									<a href="#" onclick="javascript: updateAndSubmit('LOAD', '<%=bean%>', 'bean<%=counter%>')">LOAD</a>
									<a href="#" onclick="javascript: updateAndSubmit('CLEAN', '<%=bean%>', 'bean<%=counter%>')">CLEAN</a><br>
								<%
									try {
										ArrayList<CommonBean> entries = (ArrayList<CommonBean>) Rio2016DBUtil.getDaoFromBean(bean).listAll();
										if(entries.size()==0) {
										out.println ("No rows returned");	
										} else {
										for (CommonBean entry : entries) {
											out.println(entry.toInsertString() + "<br>");
										}
										}
									} catch (Exception e) {
										out.println ("<b>Exceção : </b>" + e.getMessage());	
									}
								%>
									</p>
									<p>&nbsp;</p>
								</div>
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

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/skel-viewport.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

</body>
</html>
<%
} 
%>


