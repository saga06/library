<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 11/05/2018
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_include/head.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<body>
<%@ include file="_include/header.jsp" %>
<div class="container" id="main-content">
    <h2>Connexion</h2>
    <s:form action="login">
        <s:textfield name="email" label="Identifiant" requiredLabel="true" />
        <s:password name="password" label="Mot de passe" requiredLabel="true" />
        <s:fielderror fieldName="login.name" cssClass="col-xs-12 errorMessage"/>
        <s:submit value="Connexion"/>
    </s:form>
</div>
<%@ include file="_include/footer.jsp" %>
</body>
</html>