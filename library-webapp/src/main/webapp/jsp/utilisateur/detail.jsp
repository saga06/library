<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <h2>Détail de l'user</h2>

    <ul>
        <li>ID : <s:property value="user.id" /></li>
        <li>Nom : <s:property value="user.nom" /></li>
        <li>Prénom : <s:property value="user.prenom" /></li>
    </ul>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
