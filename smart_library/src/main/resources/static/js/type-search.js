function type_search(e) {
    var result = e.getAttribute("value");
    // alert(result);
    location.href = "search.html?search=" + encodeURI(result);
};


