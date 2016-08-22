<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    
  <spring:url value ="/resources/materialize.min.css" var="mainCss"/>
  <spring:url value ="/resources/materialize.min.js" var="mainJs"/>  
  <spring:url value ="/resources/jquery.validate.min.js" var="valiJs"/>
  
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="${valiJs}"></script>
  <script type="text/javascript" src="${mainJs}"></script>
  <link rel="stylesheet" type="text/css" href="${mainCss}">
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
      <a href="" class="brand-logo" style="padding-left: 10px;">
          <c:if test = "${pageContext.request.userPrincipal.authenticated}">
              <i class="material-icons button-collapse" data-activates="slide-out">menu</i>
          </c:if>
          KickAJ
      </a>

      <ul id="nav-mobile" class="right hide-on-med-and-down">

          <li>
              <c:choose>
                <c:when test = "${pageContext.request.userPrincipal.authenticated}">
                  Welcome! ${user.getName()}
                </c:when>
                <c:otherwise>
                  <a href="login">Login</a>
                </c:otherwise>
              </c:choose>
          </li>
          <li>
              <c:choose>
                <c:when test = "${pageContext.request.userPrincipal.authenticated}">
                      <a href="logout">Logout</a>
                </c:when>
                <c:otherwise>
                  <a href="Register">Register</a>
                </c:otherwise>
              </c:choose>
          </li>
      </ul>
    </div>
  </nav>
   <!-- Drawer-->
   <c:if test="${pageContext.request.userPrincipal.authenticated}">
    <ul id="slide-out" class="side-nav">
       <li><div class="userView">
         <img class="background" src="/SECURDE1/resources/userbackground.jpg">
         <a href="#!user"><img class="circle" src="/SECURDE1/resources/user.png"></a>
         <a href="#!name"><span class="white-text name">${user.getName()}</span></a>
         <a href="#!email"><span class="white-text email">${user.getEmail()}</span></a>
       </div></li>
       <li><a href="#!"><i class="material-icons">perm_identity</i>Account</a></li>
       <li><div class="divider"></div></li>
       <li><a class="waves-effect" href="logout"><i class="material-icons">power_settings_new</i>Logout</a></li>
     </ul>
   </c:if>
   <!-- start of products -->
   
   <div class="container">

       
     <c:forEach items = "${products}" var = "product">  
     <!-- this is product -->
     <div class = "row">
       <div class = "col s4">
         <div class="card small">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="/SECURDE1/resources/${product.getImg_name()}.jpg">
            </div>
            
            <div class="card-content">
              <span class="card-title activator grey-text text-darken-4">${product.getName()}<i class="material-icons right">more_vert</i></span>
              <div class ="row">
                <div class="col s6">
                  <p><a href="#">${product.getPrice()}</a></p>
                </div>
                <div class="col s6">
                  <p><a href="#">BUY NOW</a></p>
                </div>
              </div>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4">${product.getName()}<i class="material-icons right">close</i></span>
              <p>${product.getDetails()}</p>
              <p><a href="#">BUY NOW</a></p>

            </div>
          </div>
       </div>
       <!-- ^this is the end of a product -->
       </c:forEach>
       
     </div>
   </div>
</body>
</html>
