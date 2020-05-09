function showQuestionList() {
    var bid = location.search.split("?")[1].split("=")[1];
    $.ajax({
        "url":"/findQuestionByBid",
        "data":{"bid" : bid},
        "type":"POST",
        "dataType":"json",
        "success":function(json) {
            if (json.state == 200) {
                var list = json.data;

                $("#collect-list").empty();
                for (var i = 0; i < list.length; i++) {
                    var html = '<div style="margin:14px">'
                        + list[i].question
                        + '<span><br>'
                        + '<input type="text" id="answer' + list[i].qid
                        + '">'
                        + '</span>'
                        + '<span>'
                        + '<button onclick="answerQuestion(' + list[i].qid
                        + ')" id="' + list[i].qid + '" value="' + list[i].answer
                        + '" class="btn btn-default btn-xs add-fav" type="button"><span class="fa fa-heart"></span>提交答案</button>'
                        + '</span>'
                        + '<span>'
                        + '<button onclick="collectQuestion(' + list[i].qid
                        + ')" '
                        + ' class="btn btn-default btn-xs add-fav" type="button"><span class="fa fa-heart"></span>收藏</button>'
                        + '</span>'
                        + '</div>';


                    $("#collect-list").append(html);
                }
                $(".Questions").append($("<script src='../js/answerQuestion.js'></script>"))
                $(".Questions").append($("<script src='../js/collectQuestion.js'></script>"))

            } else {
                alert(json.message);
            }
        }
    });
}