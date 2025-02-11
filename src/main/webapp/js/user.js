$(function () {
    $(".edit").click(function () {
        $(".mask").show();
        $(".adddz").show()
    });
    $(".bc>input").click(function () {
        if ($(this).val() == "Save") {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide()
        } else {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide()
        }
    });
	$("#confirm").click(function(){
		$("#confirm").hide();
		$("#status").removeClass("fl");
		$("#status").text("Received");
		$("#status").parent(".dkuang").removeClass("clearfix deng");
		$("#status").parent(".dkuang").attr("id","received");
	}
	);
	
	/*
    $("#wa li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var a = $(this).find("a").text();
        $(".dkuang").find("p.one").each(function () {
            var b = $(this).text();
            if (a == b){
				if(b=="Received")
				{
					 //$(this).parent("#received").show().siblings("#payed").hide()
					 $("#received").show();
					 $("#payed").hide();
					
				}
				else if(b=="Payed")
				{
                	//$(this).parent("#payed").show().siblings("#received").hide()
					$("#received").hide();
					$("#payed").show();
					
				}
            }
            $("#wa li").eq(0).click(function () {
                $(".dkuang").show()
            })
        })
    });*/

    $(".sx div:gt(0)").hide();
    $(".sx div").each(function (a) {
        if ($(this).html() == "") {
            var b = $("#pro li").eq(a).find("a").text();
            var c = "";
            c = '<div class="noz">Currently no' + b + "。</div>";
            $(this).html(c)
        }
    });
    $("#pro li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var a = $(this).index();
        $(".sx > div").eq(a).show().siblings().hide()
    });
    $(".sx dl dd").find("a").click(function () {
        if ($(this).text() == "Evaluation") {
            $(".mask").show();
            $(".pj").show()
        } else {
            if ($(this).text() == "View evaluation") {
                $(".mask").show();
                $(".chak").show()
            } else {
                $(".mask").hide();
                $(".pj").hide();
                $(".chak").hide()
            }
        }
    });
    $("#xin").each(function (a) {
        $("#xin").eq(a).children("a").click(function () {
            var b = $(this).index();
            for (var c = 0; c < 5; c++) {
                if (c <= b) {
                    $("#xin").eq(a).find("a").eq(c).find("img").attr("src", "img/hxin.png")
                } else {
                    $("#xin").eq(a).find("a").eq(c).find("img").attr("src", "img/xin.png")
                }
            }
        })
    });
    $("#edit1").click(function () {
        $(".mask").show();
        $(".bj").show()
    });
    $("#edit2").click(function () {
        $(".mask").show();
        $(".xg").show()
    });
    $("#avatar").click(function () {
        $(".mask").show();
        $(".avatar").show()
    });
    $(".gb").click(function () {
        $(".mask").hide();
        $(".bj").hide();
        $(".xg").hide();
        $(".remima").hide();
        $(".avatar").hide();
        $(".pj").hide();
        $(".chak").hide()
    });
    $("#addxad").click(function () {
        //$(".mask").show();
        $(".adddz").show()
    });
   
    $(".vewwl").hover(function () {
        $(this).children(".wuliu").fadeIn(100)
    }, function () {
        $(this).children(".wuliu").fadeOut(100)
    })
});