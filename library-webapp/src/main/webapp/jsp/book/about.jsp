<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 29/04/2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>

<div class="container" id="main-content">
    <p>A propos .... bla bla bla </p>
    <ul>
        <li>Application : ${application.name}</li>
        <li>Version : ${project.version}</li>
        <li>Date du build : ${timestamp}</li>

    </ul>
</div>

<%@ include file="../_include/footer.jsp" %>
</body>
</html>