<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="materialize/js/jquery.validate.js"></script>
  <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  <link rel="stylesheet" type="text/css" href="materialize/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <style>
    nav{
      background-color: #232F3E;
    }

    body{
      background-color: #F5F5F5;
    }
  </style>

  <script type="text/javascript">
  $(document).ready(function() {
    $(".button-collapse").sideNav();
    });
  </script>
</head>
<body>
     <!-- Navbar -->
  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo" style="padding-left: 10px;"><i class="material-icons button-collapse" data-activates="slide-out">menu</i> KickAJ</a>

      <ul id="nav-mobile" class="right hide-on-med-and-down">

        <li><a href="">Welcome! USER </a></li>
        <li><a href="">Logout</a></li>
      </ul>
    </div>
  </nav>
   <!-- Drawer-->
  <ul id="slide-out" class="side-nav">
     <li><div class="userView">
       <img class="background" src="resources/userbackground.jpg">
       <a href="#!user"><img class="circle" src="resources/user.png"></a>
       <a href="#!name"><span class="white-text name">Secure User</span></a>
       <a href="#!email"><span class="white-text email">secure@gmail.com</span></a>
     </div></li>
     <li><a href="#!"><i class="material-icons">perm_identity</i>Account</a></li>
     <li><div class="divider"></div></li>
     <li><a class="waves-effect" href="#!"><i class="material-icons">power_settings_new</i>Logout</a></li>
   </ul>

   <!-- start of products -->

   <div class="container">

     <!-- this is product -->
     <div class = "row">
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="resources/shoe1.jpg">
            </div>
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">P 99999</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">close</i></span>
              <p>Here is some more information about this product that is only revealed once clicked on.</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="resources/shoe2.jpg">
            </div>
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">P 99999</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">close</i></span>
              <p>Here is some more information about this product that is only revealed once clicked on.</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="resources/shoe3.jpg">
            </div>
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">P 99999</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">close</i></span>
              <p>Here is some more information about this product that is only revealed once clicked on.</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="resources/shoe4.jpg">
            </div>
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">P 99999</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">Kyrie Shoe<i class="material-icons right">close</i></span>
              <p>Here is some more information about this product that is only revealed once clicked on.</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="resources/shoe5.jpg">
            </div>
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">Curry Shoe<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">P 99999</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">Curry Shoe<i class="material-icons right">close</i></span>
              <p>Here is some more information about this product that is only revealed once clicked on.</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="resources/shoe6.jpg">
            </div>
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">Curry Shoe<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">P 99999</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">Curry Shoe<i class="material-icons right">close</i></span>
              <p>Here is some more information about this product that is only revealed once clicked on.</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
     </div>
   </div>
</body>
</html>
