<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
    .icon-small {
      width: 20px; /* Adjust the width as needed */
      height: auto;
    }
  </style>
<html lang="fr-fr">
    <head>
        <title>Edit User</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/myScript.js"></script>
        <link href="css/main.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
      <div class="py-3">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h2 class="">Create / Edit user page</h2>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
                <div class="table-responsive">
                    <form action="saveUser.do" method="POST" class="d-inline-block">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <th scope="col">user #</th>
                            <td>
                                <c:choose>
                                    <c:when test="${(empty user) || (empty user.personId)}">NEW<input type="hidden" name="id" value="-1" /></c:when>
                                    <c:otherwise>${user.personId}<input type="hidden" name="id" value="${user.personId}" /></c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th scope="col">First Name</th>
                            <td>
                                <input type="text" class="form-control" name="FirstName" value="${user.personFirstname}" />
                            </td>
                        </tr>
                        <tr>
                            <th scope="col">Last Name</th>
                            <td>
                                <input type="text" class="form-control" name="LastName" value="${user.personLastname}"/>
                            </td>
                        </tr>
                        <tr>
                            <th scope="col">Birthdate</th>
                            <td>
                                <input type="date" class="form-control" name="Birthdate" value="<fmt:formatDate value="${user.personBirthdate}" pattern="yyyy-MM-dd"/>" />
                            </td>
                        </tbody>
                        <tfoot>
                            <tr id="modify">
                                <td scope="col" colspan="2"class="text-center">
                                    <button type="submit" name="save" class="btn btn-block btn-secondary">Save</button>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                    </form>
                </div>
            </div>
          </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Borrow date</th>
                                                    <th>Book title</th>
                                                    <th>Borrow return</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="borrow" items="${user.borrowCollection}">
                                                    <tr>
                                                        <td><fmt:formatDate value="${borrow.borrowDate}" pattern="yyyy-MM-dd" /></td>
                                                        <td>${borrow.getBookId().bookTitle}</td><%--same as borrow.bookId.bookTitle, on peut appeler du Java das un jsp !!!!!!!!!!!!!!!!!!!!--%>
                                                        <td class="centered">
                                                            <c:choose>
                                                                <c:when test="${not empty borrow.borrowReturn}">
                                                                    <fmt:formatDate value="${borrow.borrowReturn}" pattern="yyyy-MM-dd"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <button class="icon" name="return"
                                                                            onclick="returnBorrow(this, ${borrow.borrowId}); return false;">
                                                                        <img src="img/return.png" alt="return" class="icon" />
                                                                    </button>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <tfoot>
                                            <form action="addBorrow.do" method="POST">
                                                <tr>
                                                    <td colspan="2">
                                                        <input type="hidden" name="userID" value="${user.personId}"/>
                                                        <select name="bookID" class="form-control form-select form-select-lg mb-3">
                                                            <option value="-1" selected="selected">-</option>
                                                            <c:forEach var="book" items="${booksList}">
                                                                <option value="${book.bookId}">${book.bookTitle}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                    <td class="text-center">
                                                        <button class="btn"><img src="img/plus.png" alt="add" class="icon"></button>
                                                    </td>
                                                </tr>
                                            </form>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
        </div>
      </div>
    </body>
</html>