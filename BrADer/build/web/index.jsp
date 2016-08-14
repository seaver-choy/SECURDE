<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

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
                <li><a href="login">Login</a></li>
                <li><a href="badges.html">Register</a></li>
              </ul>
            </div>
          </nav>
          <div class="valign-wrapper" style="height: 90%; width: 100%">
            <h2 class="valign center-block">Please pass us!</h2>
          </div>
        </div>
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
</body>
</html>
