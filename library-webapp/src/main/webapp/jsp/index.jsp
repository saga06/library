<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 29/04/2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_include/head.jsp"%>
<body>
<%@ include file="_include/header.jsp" %>
<div class="container" id="main-content">
    <h2><s:text name="home.welcome" /></h2>
    <ul>
        <li>Application : ${application.name}</li>
        <li>Version : ${project.version}</li>
        <li>Date du build : ${timestamp}</li>
    </ul>
    <s:a action="book_list">
        <s:text name="nav.listBook" />
    </s:a>
</div>
<%@ include file="_include/footer.jsp" %>
</body>
</html>