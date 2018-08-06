<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 29/04/2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="..">${application.name}</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="library-webapp"><s:text name="nav.homepage" /></a></li>
                <li><s:a action="book_list">
                    <s:text name="nav.listBook" />
                    </s:a>
                </li>
                <li><s:a action="book_search">
                    <s:text name="nav.searchBook" />
                </s:a>
                </li>
                <li><s:a action="profil">
                    <s:text name="nav.profil" />
                </s:a>²
                </li>
                <li><a href="../jsp/about.jsp">A propos</a></li>

                <s:if test="#session.user">
                    User connecté :
                    <s:property value="#session.user.prenom" />
                    <s:property value="#session.user.nom" />

                    <s:a action="logout">Se déconnecter</s:a>
                </s:if>
                <s:else>
                    <s:a action="login">Se connecter</s:a>
                </s:else>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<s:actionerror/>
<s:actionmessage/>