//修改这个变量为实际控制器的地址，如../showGoods.do

var reqpath = "search.html"

/*ajax获得的json对象*/
var typelist = [{
		"id": "type-search1",
		"parentId": "0",
		"name": "文学类"
	}, {
		"id": "type-search2",
		"parentId": "0",
		"name": "计算机类"
	}, {
		"id": "type-search3",
		"parentId": "0",
		"name": "语言类"
	}, {
		"id": "type-search4",
		"parentId": "0",
		"name": "数学类"
	}, {
		"id": "type-search5",
		"parentId": "0",
		"name": "物理类"
	}, {
		"id": "type-search6",
		"parentId": "0",
		"name": "化学类"
	}, {
		"id": "type-search7",
		"parentId": "0",
		"name": "天文类"
	}, {
		"id": "type-search8",
		"parentId": "0",
		"name": "生物类"
	}, {
		"id": "type-search9",
		"parentId": "0",
		"name": "食品类"
	}, {
		"id": "type-search10",
		"parentId": "0",
		"name": "国际类"
	}, {
		"id": "type-search11",
		"parentId": "0",
		"name": "电子类"
	}, {
		"id": "type-search12",
		"parentId": "0",
		"name": "生活类"
	}, {
		"id": "type-search13",
		"parentId": "0",
		"name": "动物类"
	}, {
		"id": "type-search14",
		"parentId": "0",
		"name": "医学类"
	}, {
		"id": "type-search15",
		"parentId": "0",
		"name": "海洋类"
	}, {
		"id": "type-search16",
		"parentId": "0",
		"name": "生化类"
	}, {
		"id": "type-search17",
		"parentId": "0",
		"name": "珠宝类"
	}, {
		"id": "type-search18",
		"parentId": "0",
		"name": "养生类"
	}, {
		"id": "type-search19",
		"parentId": "0",
		"name": "其他"
	}, 

]

//加载json数据的到一级分类的方法
function initMenu() {
	for (var i = 0; i < typelist.length; i++) {

		if (typelist[i].parentId == "0") {

            // $(".index-menu").append($("<li onclick='"+ href + "http://localhost:8081/search.html?search="+ encodeURI(typelist[i].name)+"'>" + typelist[i].name + "</li>"))
			var id = typelist[i].id;
			$(".index-menu").append($("<li value='"+ typelist[i].name+"' onclick='"+ "type_search(this)" +"'>" + typelist[i].name + "</li>"))
		}
	}
    // $(".index-menu").append($("<script src='../js/type-search.js'></script>"))

}


$(function() {

	initMenu();
    $(".col-md-2").append($("<script src='../js/type-search.js'></script>"))
	//根据轮播图片的高，导航的高
	//获得轮播图高
	var lunh = $("#myCarousel").height();

	var lih = (lunh - 10) / 19;

	//确定导航高度
	$(".index-menu li").css("height", lih + "px")

	//确定按钮位置	

	var btnt = Math.floor($("#myCarousel").height() / 2 - 30);


	$(".left").css("margin-top", btnt + "px");
	$(".right").css("margin-top", btnt + "px");





	/*左侧分类一级菜单控制二级菜单显示和隐藏*/
	$(".index-menu").hover(function() {
			$("#showIndex").show();
		}, function() {
			$("#showIndex").hide();
		})
		/*左侧分类二级菜单控制三级菜单显示和隐藏*/
	$(".second-menu").hover(function() {
		$("#showSecond").show();
	}, function() {
		$("#showSecond").hide();
	})

	/*二级菜单自己控制显示和隐藏*/
	$("#showIndex").hover(function() {

		$("#showIndex").show();
	}, function() {
		$("#showIndex").hide();
	})

	/*三级菜单自己控制显示和隐藏*/
	$("#showSecond").hover(function() {
		$("#showIndex").show();
		$("#showSecond").show();
	}, function() {
		$("#showIndex").hide();
		$("#showSecond").hide();
	})


	/*一级分类项li鼠标移入移出*/
	var offTop = -100;
	var offLeft = 0;
	$(".index-menu li").hover(function() {
		$(".second-menu").empty();
		/*加载json数据*/
		for (var i = 0; i < typelist.length; i++) {

			if ($(this).attr("data") == typelist[i].parentId) {

				$(".second-menu").append($("<li class='second-menu-li' data='" + typelist[i].id + "' >" + typelist[i].name + "</li>"))
			}
		}
		offLeft = $(this).width() + $(this).offset().left;
		offTop = $(this).offset().top;
		$("#showIndex").css("top", offTop - 2 + "px")
		$("#showIndex").css("left", offLeft - 1 + "px")
		$(this).css("background-color", "#ffffff");
		$(this).css("color", "#4288c3");
	}, function() {
		$(this).css("background-color", "");
		$(this).css("color", "");

	})



	/*二级分类项li鼠标移入移出*/
	$(".second-menu-li").live("mouseover", function() {

		$(".third-menu").empty();
		/*加载数据*/
		for (var i = 0; i < typelist.length; i++) {

			if ($(this).attr("data") == typelist[i].parentId) {

				$(".third-menu").append($("<li class='third-menu-li' data='" + typelist[i].id + "' ><a href='" + reqpath + "?typeid=" + typelist[i].id + "'>" + typelist[i].name + "</a></li>"))
			}
		}

		//alert($(document).scrollTop() +":"+$(this).offset().top)
		var ot = $(document).scrollTop() == $(this).offset().top ? offTop : $(this).offset().top;
		var ol = $(this).width() + $(this).offset().left;
		$("#showSecond").css("top", ot - 2 + "px");
		$("#showSecond").css("left", ol + "px")
		$(this).css("background-color", "#4288c3");
		$(this).css("color", "#ffffff");
	})
	$(".second-menu-li").live("mouseout", function() {
		$(this).css("background-color", "");
		$(this).css("color", "");
	})

	/*三级分类项li鼠标移入移出*/
	$(".third-menu-li").live("mouseover", function() {

		$(this).css("background-color", "#eeeeee");
		$(this).css("color", "#000000");
	})
	$(".third-menu-li").live("mouseout", function() {
		$(this).css("background-color", "");
		$(this).css("color", "");
	})

})