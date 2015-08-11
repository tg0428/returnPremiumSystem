//设置银行卡号是否合格boolean变量
var qOrU = false;

//设置YHKH文本框监听事件
$(function(){
	//判断YHKH中的内容是否为数字，设置正则规则"reg"
	var reg = /^(\d{16}|\d{19})$/;
	$("input[name=YHKH]").change(function() {
		var number = $.trim($("input[name=YHKH]").val().replace(/\s/g, ""));
		var flag = reg.test(number);
		if (flag == true) {
			$("#msg1").css("color","blue");
			$("#msg1").text("输入正确");
			qOrU = true;
		} else {
			$("#msg1").css("color","red");
			$("#msg1").text("银行卡格式错误");
			qOrU = false;
		}
	});
});

function show() {
	
	// .replace(/\s/g,"")去除字符串中的空格，$.trim()去除字符串兩端的空格；
	var YHKH = $.trim($("input[name=YHKH]").val().replace(/\s/g, ""));
	var KHH1 = $.trim($("input[name=KHH1]").val().replace(/\s/g, ""));
	var KHH2 = $.trim($("input[name=KHH2]").val().replace(/\s/g, ""));
	var KHH3 = $.trim($("input[name=KHH3]").val().replace(/\s/g, ""));
	var KHH4 = $.trim($("input[name=KHH4]").val().replace(/\s/g, ""));
	var wz = $("select option:selected").val();

	if (wz == "") {
		alert("请选择开户银行所在地的市或县！！！")
	} else {
		if (YHKH == "" && KHH1 != "" && KHH2 != "" && KHH3 != "" && KHH4 != "") {
			$("input[name=YHKH]").css("border", "solid 2px red");
		} else if (YHKH != ""
				&& (KHH1 == "" || KHH2 == "" || KHH3 == "" || KHH4 == "")) {
			$("input[name=YHKH]").css("border", "solid 1px #999999");
			var arry = [ KHH1, KHH2, KHH3, KHH4 ];
			$.each(arry, function(i, k) {
				if (arry[i] == "") {
					$("input[name=KHH" + (i + 1) + "]").css("border",
							"solid 2px red");
				} else if (arry[i] != "") {
					$("input[name=KHH" + (i + 1) + "]").css("border",
							"solid 1px #999999");
				}
			});
		} else if (YHKH == ""
				&& (KHH1 == "" || KHH2 == "" || KHH3 == "" || KHH4 == "")) {
			$("input[name=YHKH]").css("border", "solid 2px red");
			var arry = [ KHH1, KHH2, KHH3, KHH4 ];
			$.each(arry, function(i, k) {
				if (arry[i] == "") {
					$("input[name=KHH" + (i + 1) + "]").css("border",
							"solid 2px red");
				} else if (arry[i] != "") {
					$("input[name=KHH" + (i + 1) + "]").css("border",
							"solid 1px #999999");
				}
			});
		} else {
			if(qOrU){
				$("input[name=YHKH]").css("border", "solid 1px #999999");
				$("input[name=KHH1]").css("border", "solid 1px #999999");
				$("input[name=KHH2]").css("border", "solid 1px #999999");
				$("input[name=KHH3]").css("border", "solid 1px #999999");
				$("input[name=KHH4]").css("border", "solid 1px #999999");
				if (wz == "市") {
					var returnValue = confirm("银行卡号：" + YHKH + "\n\r" + "开户行："
							+ KHH1 + "银行" + KHH2 + "省" + KHH3 + "市" + KHH4 + "支行");
				} else {
					var returnValue = confirm("银行卡号：" + YHKH + "\n\r" + "开户行："
							+ KHH1 + "银行" + KHH2 + "省" + KHH3 + "县" + KHH4 + "支行");
				}
				if (returnValue == true && qOrU) {
					$("#bankInfo").submit();
				}
			}else{
				alert("请按照正确格式输入银行卡号!!");
			}
		}
	}
}

function resetInput() {
	$("input[name=YHKH]").css("border", "solid 1px #999999");
	$("input[name=KHH1]").css("border", "solid 1px #999999");
	$("input[name=KHH2]").css("border", "solid 1px #999999");
	$("input[name=KHH3]").css("border", "solid 1px #999999");
	$("input[name=KHH4]").css("border", "solid 1px #999999");
}


