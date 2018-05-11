<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <s:actionmessage />
    <h2>Détail du projet</h2>
    <ul>
        <li>ID : <s:property value="projet.id" /></li>
        <li>Nom : <s:property value="projet.nom" /></li>
        <li>Date création : <s:date name="projet.dateCreation" /></li>
        <li>
            Responsable :
            <s:a action="utilisateur_detail">
                <s:param name="id" value="projet.responsable.id" />
                <s:property value="projet.responsable.prenom"/> <s:property value="projet.responsable.nom"/>
            </s:a>
        </li>
        <li>Cloturé : <s:property value="projet.cloture" /></li>
    </ul>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
