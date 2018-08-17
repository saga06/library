<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 29/04/2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-bottom footer">
    <div class="container">
        <p>
            ${application.name} - version ${project.version}
            &copy; <a href="${organization.url}">${organization.name}</a>
            Date du build : ${timestamp}
        </p>
        <%--Décommenter la partie en dessous si vous voulez afficher l'aide au debug de struts--%>
        <%--<s:debug/>--%>
    </div>
</nav>

<!-- Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>