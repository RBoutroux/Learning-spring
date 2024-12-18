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
        <title>Users</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <link href="css/main.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
      <%@ include file="navbar.jspf" %>
     
      <div class="py-3">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h2 class="">List of users</h2>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col" class="text-center">user #</th>
                            <th scope="col" class="text-center">First Name</th>
                            <th scope="col" class="text-center">Last Name</th>
                            <th scope="col" class="text-center">Birthdate</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${usersList}">
                                <tr>
                                    <td scope="col">${item.personId}</td>
                                    <td>
                                        ${item.personFirstname}
                                    </td>
                                    <td>${item.personLastname}</td>
                                    <td><fmt:formatDate value="${item.personBirthdate}" pattern="yyyy-MM-dd" /></td>
                                    <td class="text-center">
                                        <form action="editUser" method="POST" class="d-inline-block">
                                            <input type="hidden" name="id" value="${item.personId}">
                                            <button name="edit" formaction="editUser.do" class="btn">
                                                <img src="img/edit.png" alt="edit" class="icon img-fluid icon-small" />
                                            </button>
                                            <button name="delete" formaction="deleteUser.do" class="btn">
                                                <img src="img/delete.png" alt="delete" class="icon img-fluid icon-small" />
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr id="addNew">
                                <td scope="col" colspan="4"></td>
                                <td class="text-center">
                                    <form action="addUser" method="POST">
                                        <button name="add" formaction="createUser.do" class="btn">
                                            <img src="img/plus.png" alt="add" class="icon img-fluid icon-small" />
                                        </button>
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