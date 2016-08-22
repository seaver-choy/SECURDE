<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.10.2/validator.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
          rel="stylesheet" type="text/css">
</head>
<body>
<div class="section">
    <div class="container">
        <% if (request.getParameter("username") != null) { %>
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-dismissable alert-success" contenteditable="true">
                    <b>Account successfully created! Please login to continue.</b>
                </div>
            </div>
        </div>
        <% } %>
        <div class="row">
            <div class="col-md-12">
                <c:if test = "${not empty error}">
                    <div class ="error">${error}</div>
                </c:if>
                <c:if test = "${not empty msg}">
                    <div class ="error">${msg}</div>
                </c:if>    
                    
                <form role="form" action="<c:url value="j_spring_security_check"/>" method="post" data-toggle="validator">
                    <div class="form-group">
                        <label class="control-label" for="usernameField">Username</label>
                        <input class="form-control" id="usernameField"
                               placeholder="Enter username" type="text" name="username" maxlength="256" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="passwordField">Password</label>
                        <input class="form-control" id="passwordField"
                               placeholder="Password" type="password" name="password" maxlength="45" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <input type ="hidden" name = "${_csrf.parameterName}" value ="${_csrf.token}"/>
                    
                    <button type="submit" class="btn btn-default">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
