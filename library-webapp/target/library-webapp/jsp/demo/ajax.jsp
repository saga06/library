<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/05/2018
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>

<body>
<%@ include file="../_include/header.jsp" %>

<h2>Démo - AJAX</h2>


<h3>Liste des Ouvrages</h3>
<ul id="listProjet">
    <li><em>à charger...</em></li>
</ul>
<button onclick="reloadListProjet()">Recharger</button>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    function reloadListProjet() {
        // URL de l'action AJAX
        var url = "<s:url action="demo_ajax_getListProjet"/>";

        // Action AJAX en POST
        jQuery.post(
            url,
            function (data) {
                var $listProjet = jQuery("#listProjet");
                $listProjet.empty();
                jQuery.each(data, function (key, val) {
                    $listProjet.append(
                        jQuery("<li>")
                            .append(val.nom)
                            .append(" - Auteur : ")
                            .append(val.responsable.prenom)
                    );
                });
            })
            .fail(function () {
                alert("Une erreur s'est produite.");
            });
    }
</script>
</body>
</html>