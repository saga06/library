<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <h2>Liste des ouvrages</h2>
    <s:a action="projet_new">Ajouter un nouveau livre</s:a>
    <ul>
       <s:iterator value="listProjet">
           <li>
               <s:a action="projet_detail">
                   <s:param name="id" value="id" />
                   <s:property value="nom"/>
               </s:a>

               - Auteur :
               <s:a action="utilisateur_detail">
                   <s:param name="id" value="responsable.id"/>
                   <s:property value="responsable.prenom" /> <s:property value="responsable.nom" />
               </s:a>
           </li>
       </s:iterator>
    </ul>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
