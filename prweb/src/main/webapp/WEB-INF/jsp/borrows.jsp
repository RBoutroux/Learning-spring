<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="fr-fr">
    <head>
        <title>Borrows</title>
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
                                        <th scope="col" class="text-center">Number of borrows</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${booksList}">
                                    <tr>
                                        <td scope="col">${item.bookId}</td>
                                        <td>${item.bookTitle}</td>
                                        <td>${item.bookAuthors}</td>
                                        <td>Stat</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
