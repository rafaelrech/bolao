<%@page import="nbaplayoffs2016.util.Nba2016DBUtil"%>
<%@page import="rech.bolao.util.BaseSessionUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rech.bolao.bean.CommonBean"%>
<%@page import="rech.bolao.util.BaseDBUtil"%>
<%@ page session="true"%>



<!DOCTYPE HTML>
<html>
	<head>
		<title>NBA 2016 PLAYOFFS</title>
		<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
		<script src="http://underscorejs.org/underscore-min.js"></script>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
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
								String[] beans = Nba2016DBUtil.beans;
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
											ArrayList<CommonBean> entries = (ArrayList<CommonBean>) Nba2016DBUtil.getDaoFromBean(bean).listAll();
											if(entries.size()==0) {
												out.println ("No rows returned");	
											} else {
												for (CommonBean entry : entries) {
													out.println(entry.toInsertString() + "<br>");
												}
											}
										} catch (Exception e) {
											e.printStackTrace();
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

