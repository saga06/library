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
    <h2><s:text name="listBook"/></h2>
<%--
    <s:a action="book_new">Ajouter un nouveau livre</s:a>
--%>
    <table id="table" class="table table-dark">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Titre</th>
                <th scope="col">Auteur(s)</th>
                <th scope="col">Editeur</th>
                <th scope="col">Thème(s)</th>
                <th scope="col">Nombre d'exemplaire</th>
                <th scope="col">ISBN</th>
                <%--<th scope="col">Résumé</th>--%>
                <th scope="col">Réserver</th>
            </tr>
        </thead>
        <tbody>
        <s:iterator value="listBook">
            <tr class="table-primary">
<%--<s:a action="book_detail"> <s:param name="book.id" value="book.id" />--%>
                    <td>
                        <s:property value="title"/>
                    </td>
                    <td>
                      <%--  <s:a action="author_detail">
                            <s:param name="id" value="author.id"/> --%>
                          <s:iterator value="authors" status="loop">
                              <s:if test="#loop.last == true ">
                                  <s:property value="name" />
                              </s:if>
                              <s:else>
                                  <s:property value="name" />,
                              </s:else>
                          </s:iterator>
                    </td>
                    <td>
                        <s:property value="editorName"/>
                    </td>
                    <td>
                        <s:iterator value="themes" status="loop">
                            <s:if test="#loop.last == true ">
                                <s:property value="name" />
                            </s:if>
                            <s:else>
                                <s:property value="name" />,
                            </s:else>
                        </s:iterator>
                    </td>
                    <td>
                         <s:property value="numberOfCopies"/>
                    </td>
                    <td>
                        <s:property value="isbn"/>
                    </td>
                    <%--<td>
                        <s:property value="resume"/>
                    </td>--%>
                    <td>
                        <s:if test="#session.user">
                            <button>Réserver</button>
                        </s:if>
                        <s:else>
                            <button type="button" disabled>Vous devez vous identifiez d'abord !</button>
                        </s:else>
                    </td>
            </tr>
        </s:iterator>
        <%--<s:iterator value="listBook">
            <tr>
                <s:a action="book_detail">
                    <s:param name="id" value="id" />
                    <td> Id :
                        <s:property value="id"/></td>
                    <td> Nombre d'exemplaire:
                        <s:property value="numberOfCopies"/></td>
                    <td> Titre:
                        <s:property value="title"/></td>
                    <td> Editor Id:
                        <s:property value="editorId"/></td>
                    &lt;%&ndash;ISBN:
                    <s:property value="isbn"/>&ndash;%&gt;
                </s:a>
                <td>- Auteur :
                    <s:a action="author_detail">
                        <s:param name="id" value="author.id"/>
                        <s:property value="numberOfCopies" /> <s:property value="user.nom" />
                    </s:a></td>
            </tr>
        </s:iterator>--%>
        </tbody>
    </table>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
