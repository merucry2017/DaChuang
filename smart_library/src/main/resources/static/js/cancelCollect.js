function cancelCollet(bid) {
    $.ajax({
        "url": "/cancelCollect",
        "type": "POST",
        "data": {"bid" : bid},
        "dataType": "json",
        "success": function (json) {
            if (json.state == 200) {
                alert("取消收藏成功！");
                window.location.href="favorites.html";
            } else {
                alert(json.message);
            }
        }
    })

}