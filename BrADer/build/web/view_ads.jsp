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
		<div class="section" style="padding-top: 0">
			<jsp:include page="WEB-INF/navbar.jsp"/>
			<div class="background-image" style="background-image : url('res/books.jpg')"></div>
			<div class="container">
			  	<div class="row">
			      	<div class="col-md-12">
			        	<h1 class="text-center text-inverse" id="archive"></h1>
			      	</div>
				</div>
			</div>
		</div>
		<div class="section">
		    <div class="container">
		        <div class="row">
		            <div class="col-md-12">
		                <div class="page-header">
		                    <h1>Search Results
		                        <font color="#777777">
		                            <span style="font-size: 23.3999996185303px; line-height: 23.3999996185303px;"></span>
		                        </font>
		                    </h1>
		                </div>
		            </div>
		        </div>
		        <div class="row">
		            <div class="col-md-12">
		                <ul id = "posts-list" class="list-group">
                                    
                                    
                                        <li class="list-group-item">
                                            <h4>Billboard</h4>
                                            <h6>60,000 php</h6>
                                            <h6>30 ft high x 25 ft wide</h6>
                                            <p>
                                                Status: Available<br>
                                                Specific site: 1029 Pasig Street, Pasig <br>
                                                Traffic Count: 106,183 Vehicles<br>
                                                Vicinity Population: 1,707,218 Population<br>
                                            </p>
                                            <a class="btn btn-default" href = "view_ads_details.jsp" >Inquire Now!</a> 
                                               
                                    <!--<li class="list-group-item">
                                            <h4><input type = "text" value = "" readonly disabled></input></h4>
                                            <h6><input type = "text" value = "" readonly disabled></input></h6>
                                            <h6><input type = "text" value = "" readonly disabled></input></h6>
                                            <p><input type = "text" value = "" readonly disabled></input>
                                            </p>
		                    </li>-->
                                        </li>
                                   
                                    <%%>
		                </ul>
		            </div>
		        </div>
		    </div>
		</div>
		<jsp:include page="WEB-INF/footer.html"/>
	</body>

</html>
