<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Détail de l'utilisateur</h2>

<ul>
    <li>ID : <s:property value="utilisateur.id" /></li>
    <li>Nom : <s:property value="utilisateur.nom" /></li>
    <li>Prénom : <s:property value="utilisateur.prenom" /></li>
</ul>
</body>
</html>
