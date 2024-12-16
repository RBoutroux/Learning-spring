<!DOCTYPE html>
<html lang="fr-fr">
    <head>
        <title>Library Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
      <div class="py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h2 class="">Library Login</h2>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <form id="c_form-h" action="login.do" method="POST">
                <div class="form-group row">
                  <label for="input login" class="col-2 col-form-label">Login</label>
                  <div class="col-10">
                    <input type="text" class="form-control" id="input login" name="login" value="" placeholder="Login" required="required">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="input password" class="col-2 col-form-label">Password</label>
                  <div class="col-10">
                    <input type="password" class="form-control" id="input password" name="password" placeholder="Password" required="required">
                  </div>
                  <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </div>
          </div>
        </div>
      </div>
    </body>
</html>