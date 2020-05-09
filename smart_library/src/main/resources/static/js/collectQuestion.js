function collectQuestion(qid){

    $.ajax({
        "url":"/collectQuestion",
        "data": {"qid" : qid },
        "type":"POST",
        "dataType":"json",
        "success":function(json) {
            console.log(json)
            if(json.state == 200) {
                alert("收藏成功！");
            } else {
                alert(json.message);
            }
        }
    });

}
