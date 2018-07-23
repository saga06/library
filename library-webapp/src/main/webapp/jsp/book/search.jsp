<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${application.name}</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous" />
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous" />
    <link rel="stylesheet" href="../style/style.css" />
    <%--Datatables --%>
    <link href="//datatables.net/download/build/nightly/jquery.dataTables.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="//datatables.net/download/build/nightly/jquery.dataTables.js"></script>

</head><body>
<%@ include file="../_include/header.jsp" %>
<script>
    $(document).ready( function () {
        var GARBAGE = "!)!%&-15-85--)!%&%!*9%&";

        var table = $('#table_id').DataTable( {
            dom: 'l<"custom-search"f>tip'
        });
        table.search( GARBAGE ).draw();

        var newSearch = $('<input type="text">');
        newSearch.on('keyup', function() {
            if ($(this).val().toString().trim() === "")
                table.search( GARBAGE ).draw();
            else
                table.search( $(this).val() ).draw();
        });

        $('.custom-search input').replaceWith( newSearch );

    } );
</script>
<div class="container" id="main-content">
    <h2>Liste des ouvrages</h2>
    <%--
        <s:a action="book_new">Ajouter un nouveau livre</s:a>
    --%>
    <table id="table_id" class="display">
        <thead>
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Editeur</th>
            <th>Thème</th>
            <th>ISBN</th>
            <th>Réserver</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listBook">
            <tr>
                    <%--
                                    //<s:a action="book_detail">
                                        <s:param name="book.id" value="book.id" />
                                        --%>
                <td><s:property value="title"/></td>
                <td>
                        <%--  <s:a action="author_detail">
                              <s:param name="id" value="author.id"/> --%>
                    <s:property value="authorName" />
                        <%--<s:property value="user.nom" />
                            </s:a>--%>
                </td>
                <td>
                    <s:property value="editorName"/>
                </td>
                <td>
                    <s:property value="themeName"/>
                </td>
                <td>
                    <s:property value="isbn"/>
                </td>
                <td> <button>Réserver</button></td>
                    <%--
                                    </s:a>
                    --%>
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
