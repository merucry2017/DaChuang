function answerQuestion(qid) {
    var a = "answer";
    var aid = a+qid;
    var answer = document.getElementById(aid).value;
    var corretanswer = document.getElementById(qid).value;
    if(answer==corretanswer){
        alert("回答正确");
    }else{
        alert("回答错误");
    }
}