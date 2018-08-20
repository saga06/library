<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 05:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <h2><s:text name="myListBook"/></h2>
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
            <th scope="col">ISBN</th>
            <%--<th scope="col">Résumé</th>--%>
            <th scope="col">Prolonger</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listBookBorrowedByUser">
            <tr class="table-primary">
                    <%--<s:a action="book_detail"> <s:param name="book.id" value="book.id" />--%>
                <td>
                    <s:property value="title"/>
                </td>
                <td>
                  <%--<s:a action="author_detail">
                      <s:param name="id" value="author.id"/>--%>
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
                    <s:property value="isbn"/>
                </td>
                <%--<td>
                    <s:property value="resume"/>
                </td>--%>
                <td>
                    <%--TO DO : test à modifier--%>
                    <s:if test="#session.user">
                        <button>Prolonger</button>
                    </s:if>
                    <s:else>
                        <button type="button" disabled>Déjà prolongé</button>
                    </s:else>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
