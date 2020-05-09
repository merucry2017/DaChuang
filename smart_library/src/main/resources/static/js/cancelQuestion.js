function cancelQuestion(qid) {
    $.ajax({
        "url": "/cancelQuestion",
        "type": "POST",
        "data": {"qid" : qid},
        "dataType": "json",
        "success": function (json) {
            if (json.state == 200) {
                alert("取消收藏成功！");
                window.location.href="myquestion.html";
            } else {
                alert(json.message);
            }
        }
    })

}