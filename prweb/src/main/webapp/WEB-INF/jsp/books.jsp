<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr-fr">
    <head>
        <title>List Books Page</title>
        <meta charset="UTF-8"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <link href="css/main.css" type="text/css" rel="stylesheet" />
        <script src="js/main.js"></script>
    </head>
    <body>
        <%@ include file="navbar.jspf" %>

        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="">List of books</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-center">book #</th>
                                        <th scope="col" class="text-center">Title</th>
                                        <th scope="col" class="text-center">Authors</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${booksList}">
                                    <tr>
                                        <td scope="col">${item.bookId}</td>
                                        <td>${item.bookTitle}</td>
                                        <td>${item.bookAuthors}</td>
                                        <td class="text-center">
                                            <form action="#" method="POST">
                                                <input type="hidden" name="id" value="${item.bookId}" />
                                                <button name="edit" class="btn" formaction="editbook.do"><img src="img/edit.png" alt="edit" class="icon" /></button>
                                                <button name="delete" class="btn" formaction="deletebook.do"><img src="img/delete.png" alt="delete" class="icon" /></button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr id="addNew">
                                        <td scope="col" colspan="3"></td>
                                        <td class="text-center">
                                            <form action="createbook.do" method="POST">
                                                <button class="btn"><img src="img/plus.png" alt="add" class="icon" /></button>
                                            </form>
                                        </td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

