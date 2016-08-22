<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.10.2/validator.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form" action="register" method="post" data-toggle="validator">
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="usernameField" class="control-label">Username</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="usernameField" placeholder="Username" name="username" maxlength="45" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="passwordField" class="control-label">Password</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="passwordField" placeholder="Password" name="password" maxlength="45" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="confirmPasswordField" class="control-label">Confirm password</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="confirmPasswordField" placeholder="Confirm Password" maxlength="45" data-match="#passwordField" data-match-error="Password does not match confirm password"  required>
                            <div class="help-block with-errors"></div>
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="firstNameField" class="control-label">First name</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="firstNameField" placeholder="First name" name="firstName" maxlength="45" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="lastNameField" class="control-label">Last name</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="lastNameField" placeholder="Last name" name="lastName" maxlength="45" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="emailField" class="control-label">Email</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="emailField" placeholder="Email" name="email" maxlength="256" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>