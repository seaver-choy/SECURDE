<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
     <!--Import Google Icon Font-->
     <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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

       <style>
   #toast-container {
   top: auto !important;
   right: auto !important;
   bottom: 10%;
   left:  40%!important;
   }
   </style>

       <script>
      function showToast(message, duration){
         Materialize.toast(message, duration);
      }
      function showToast1(message, duration){
         Materialize.toast('<i>'+ message + '</i>', duration);
      }
      function showToast2(message, duration){
         Materialize.toast(message, duration, 'rounded');
      }
      function showToast3(message, duration){
         Materialize.toast('Hello World!', duration, '', function toastCompleted(){
               alert('Toast dismissed!');
            });
      }



      </script>

      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
   </head>

   <body>

     <div class = "layer">
        <nav class = "transparent">
          <div class="nav-wrapper">
            <a href="#" class="brand-logo" style="padding-left: 6px;">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
              <li><a href="sass.html">Login</a></li>
              <li><a href="register">Register</a></li>
            </ul>
          </div>
        </nav>
        <div class="valign-wrapper" style="height: 90%; width: 100%">
        <div class = "container valign">


        <div class="row">
          <form id  = "formValidate"class="col s10 push-s1" rrole="form" action="login" method="post" data-toggle="validator">
            <div class="row">
              <div class="input-field col s10 push-s1">
                <input id="usernameField" name = "username" type="text" class="validate test">
                <label for="username">Username</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s10 push-s1">
                <input id="passwordField" name="password" type="password" class="validate test">
                <label for="password">Password</label>
              </div>
            </div>
            <div class = "row">
              <button class="btn waves-effect waves-light col s10 push-s1" type="submit" name="action">Login
              </button>
            </div>
            <% if (request.getParameter("username") != null) { %>
            <div class="row">
              <script type="text/javascript">
                Materialize.toast('Account created successfully!', 4000);
              </script>
              <div id="toast-container"></div>
              <div class="hiddendiv common"></div>
            </div>
            <% } %>
          </form>
        </div>
      </div>
    </div>
      </div>
     <!--Import jQuery before materialize.js-->

   </body>
</html>
