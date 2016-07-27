$(document).ready(function () {
    showAdvertisements();
    $("#search-button").click(showAdvertisements);
});

function showAdvertisements() {
    var searchCriteria  = {
        type: "",
        location: "",
        price: "",
        size: ""
    };

    $.post("/search", searchCriteria, function (data, status) {
        var adList = $(".media-list");
        adList.empty();
        
        $.each(data, function(index, item) {
            var html = '<li class="media">' +
                       '<a class="pull-left" href="#"><img class="media-object"' +
                           ' src="http://pingendo.github.io/pingendo-bootstrap' +
                                 '/assets/placeholder.png" height="128" width="128"></a>' +
                       '<div class="media-body">' +
                       '    <h3 class="media-heading">[' + item.type + '] ' + item.title + '</h3>' +
                       '    <p>' +
                       '        <b>Price per portion: Php </b>' + item.portionCost + '<br>' +
                       '        <b>Portion size: </b>' + item.portionSize + '<br>' +
                       '        <b>Portions available: ' + 0 + ' out of ' + item.numPortions +
                       '    </p>' +
                       '</div>' +
                       '</li>';
            adList.append(html);
        });
    });
}