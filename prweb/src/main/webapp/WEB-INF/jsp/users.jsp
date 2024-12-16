<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>
    <body>
      <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container">
          <div class="collapse navbar-collapse" id="navbar1">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item"> <a class="nav-link text-white" href="users.html">Users</a></li>
              <li class="nav-item"> <a class="nav-link text-white" href="books.html">Books</a></li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="py-3">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h2 class="">List of users</h2>
            </div>
          </div>
          <div class="row text-center">
            <div class="col-md-12">
                <div class="table-responsive">
                    <table class="table table-striped border">
                        <thead class="bg-success">
                        <tr>
                            <th scope="col" class="text-center">user #</th>
                            <th scope="col" class="text-center">First Name</th>
                            <th scope="col" class="text-center">Last Name</th>
                            <th scope="col" class="text-center">Birthdate</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td scope="col">1</td>
                            <td>RÃ©mi</td>
                            <td>Boutroux</td>
                            <td>2001-05-31</td>
                            <td class="text-center">
                                <form action="editUser" method="POST" class=" d-inline-block">
                                    <button name="edit" class="btn">
                                        <img src="img/edit.png" alt="edit" class="icon img-fluid icon-small" />
                                    </button>
                                </form>
                                <form action="deleteUser" method="POST" class=" d-inline-block">
                                    <button name="delete" class="btn">
                                        <img src="img/delete.png" alt="delete" class="icon img-fluid icon-small" />
                                    </button>
                                </form>
                        </tr>
                        </tbody>
                        <tfoot>
                            <tr id="addNew">
                                <td scope="col" colspan="4"></td>
                                <td class="text-center">
                                    <form action="addUser" method="POST">
                                        <button name="add" class="btn">
                                            <img src="img/plus.png" alt="add" class="icon img-fluid icon-small" />
                                        </button>
                                    </form>
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