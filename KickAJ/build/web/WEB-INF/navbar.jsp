<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.jsp"><span>BrADer</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="search">Browse Ads</a>
                </li>
                <% if (session.getAttribute("userLoggedIn") == null) { %>
                <li>
                    <a href="register">Register</a>
                </li>
                <li>
                    <a href="login">Login</a>
                </li>
                <% }  else { %>
                <li >
                    <a href="#">Account Settings</a>
                </li>
                <li>
                    <a href="logout">Logout</a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
