function showCartList() {
    $.ajax({
        "url": "/getCollectByUid",
        "type": "POST",
        "dataType": "json",
        "success": function (json) {
            if (json.state == 200) {
                var list = json.data;

                $("#collect-list").empty();
                for (var i = 0; i < list.length; i++) {
                    console.log(list[i].title);
                    var id = list[i].bid;
                    var html = '<div class="col-md-3">'
                        + '<div class="goods-panel">'
                        + '<div class="move-img img-search" >'
                        + '<img src="..#{image}" width="100%" style="width:200px;height:300px;"/>'
                        + '</div>'
                        + '</div>'
                        + '<h5 class="text-row-3"><a href="book.html?id=' + id
                        + '"><small>'
                        + list[i].title
                        + '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'
                        + '作者：'
                        + list[i].writer
                        + '</small></a></h5>'
                        + '<span>'
                        + '<button onclick="cancelCollet(' + id
                        + ')" id="' + id
                        + '" class="btn btn-default btn-xs add-fav" type="button"><span class="fa fa-heart"></span>取消收藏</button>'
                        + '</span>'
                        + '</div>'
                        + '</div>';

                    html = html.replace(/#{image}/g, list[i].image);
                    $("#collect-list").append(html);
                }
                $(".goods-panel").append($("<script src='../js/cancelCollect.js'></script>"))
            } else {
                alert(json.message);
            }
        }
    });
}

