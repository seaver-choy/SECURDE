<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <style>
        body {
          background-image: url('resources/graduatebackground.jpg');
          position: fixed;
          width: 100%;
          height: 95%;
          left: 0;
          top: 0;
          z-index: 10;
        }

        h2 {
          color: #f3e5f5;
        }

        .test{
            color: #f3e5f5;
        }

        div {
            color: #f3e5f5;
        }

        .layer {
            background-color: rgba(0, 0, 0, 0.7);
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 110%;
        }

      </style>
</head>
<body>
<div class = "layer">
      <nav class = "transparent">
        <div class="nav-wrapper">
          <a href="#" class="brand-logo" style="padding-left: 6px;">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
              <li><a href="sass.html">Login</a></li>
              <li><a href="badges.html">Register</a></li>
            </ul>
        </div>
      </nav>

      <div class="valign-wrapper" style="height: 90%; width: 100%">
      <div class = "container valign">
      <div class="row">
        <form id  = "formValidate"class="col s12" role="form" action="register" method="post" data-toggle="validator">
          <div class="row">
            <div class="input-field col s12">
              <input id="usernameField" name = "username" type="text" class="validate test">
              <label for="username">Username</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="passwordField" name="password" type="password" class="validate test">
              <label for="password">Password</label>
            </div>
            <div class="input-field col s6">
              <input id="confirmPasswordField" name = "confirmPassword" type="password" class="validate test">
              <label for="confirmPassword">Confirm Password</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="firstNameField" name = "firstname"type="text" class="validate test">
              <label for="firstname">First Name</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="lastNameField" name="lastname"type="text" class="validate test">
              <label for="lastname">Last Name</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="emailField" type="email" class="validate test">
              <label for="email" data-error="Invalid Email" data-success="Valid! Good Job">Email</label>
            </div>
          </div>

          <div class = "row">
            <button class="btn waves-effect waves-light col s12" type="submit" name="action">Register
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script src="materialize/js/jquery.validate.min.js"></script>
    <script>
    $("#formValidate").validate({
        rules: {
            username: {
                required: true,
                minlength: 5,
                alphanumeric: true
            },
            email: {
                required: true,
                email:true
            },
            password: {
				required: false ,
				minlength: 5
			},
			confirmPassword: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
      firstname:"required",
      lastname: "required",
      ccomment: {
				required: true,
				minlength: 15
            },
            cgender:"required",
			cagree:"required",
        },
        //For custom messages
        messages: {
            username:{
                required: "Enter a username",
                minlength: "Enter at least 5 characters"
            },
            curl: "Enter your website",
        },
        errorElement : 'div',
        errorPlacement: function(error, element) {
          var placement = $(element).data('error');
          if (placement) {
            $(placement).append(error)
          } else {
            error.insertAfter(element);
          }
        }
     });
    </script>
</body>
</html>