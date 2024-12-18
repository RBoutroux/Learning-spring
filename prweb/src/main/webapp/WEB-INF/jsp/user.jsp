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
                    <table class="table table-striped table-success border">
                        <tbody>
                        <tr>
                            <td scope="col"  class="bg-success" >user #</td>
                            <td>
                                <c:choose>
                                    <c:when test="${(empty user) || (empty user.personId)}">NEW<input type="hidden" name="id" value="-1" /></c:when>
                                    <c:otherwise>${user.personId}<input type="hidden" name="id" value="${user.personId}" /></c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td scope="col" class="bg-success">First Name</td>
                            <td>
                                <input type="text" class="form-control" name="FirstName" value="${user.personFirstname}" />
                            </td>
                        </tr>
                        <tr>
                            <td scope="col" class="bg-success">Last Name</td>
                            <td>
                                <input type="text" class="form-control" name="LastName" value="${user.personLastname}"/>
                            </td>
                        </tr>
                        <tr>
                            <td scope="col" class="bg-success">Birthdate</td>
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
        </div>
      </div>
    </body>
</html>