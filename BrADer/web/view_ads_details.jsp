<%--
  Created by IntelliJ IDEA.
  User: jantristanmilan
  Date: 09/06/2016
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
          rel="stylesheet" type="text/css">
</head>

	<body>
		<div class="section section-primary" style="padding-top: 0">
		    <jsp:include page="WEB-INF/navbar.jsp"/>
		</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h1>Billboard
                        <font color="#777777">
                            <span style="font-size: 23.3999996185303px; line-height: 23.3999996185303px;">30 ft high x 25 ft wide</span>
                        </font>
                    </h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p>
                    Site Code: 23456<br>
                    Location: 190123 Pasig Street, Pasig<br>
                    Facing: Pasig<br>
                    Traffic: From Cubao to Pasig<br>
                    Size: 30 ft high x 25 ft wide<br>
                    Traffic: 106,183 Vehicles<br>
                    Vicinity Population: 1,707,218 Population<br>
                    Sharing with: SME 2, SME 3, SME 4<br>
                    
                    <a class="btn btn-default" href ="">Deal!</a>
                </p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="WEB-INF/footer.html"/>
</body>

</html>