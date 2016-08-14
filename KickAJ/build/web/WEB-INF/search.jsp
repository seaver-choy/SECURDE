<%@ page import="jantristanmilan.data.Advertisement" %>
<%@ page import="jantristanmilan.data.AdvertisementType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/search.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
          rel="stylesheet" type="text/css">
</head>

<body>
<jsp:include page="navbar.jsp" />
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <form role="form">
                    <div class="form-group">
                        <label for="adTypeField">Advertisement type</label>
                        <select class="form-control" id="adTypeField">
                            <option>Any</option>
                            <option>Billboard</option>
                            <option>Flyers</option>
                            <option>Magazine</option>
                            <option>Newspaper</option>
                            <option>Online Banner</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="locationField">Location</label>
                        <select class="form-control" id="locationField">
                            <option>Any</option>
                            <option>Quezon City</option>
                            <option>Pasig City</option>
                            <option>Manila</option>
                            <option>Makati City</option>
                            <option>Taguig City</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="priceField">Price</label>
                        <select class="form-control" id="priceField">
                            <option>Any</option>
                            <option>1 - 9999</option>
                            <option>10000 - 49999</option>
                            <option>50000 and above</option>
                        </select>
                    </div>
                    <a id="search-button" type="button" class="btn btn-default" href="view_ads.jsp">Search</a>
                </form>
            </div>
            <div class="col-md-9">
                <ul class="media-list">
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.html"/>
</body>

</html>