function show(){
	var YHKH = $("input[name=YHKH]").val();
	var KHH = $("input[name=KHH]").val();
	if(YHKH==""&&KHH!=""){
		$("input[name=YHKH]").css("border","solid  red");
	}else if(YHKH!=""&&KHH==""){
		$("input[name=KHH]").css("border","solid  red");
	}else if(YHKH==""&&KHH==""){
		$("input[name=YHKH]").css("border","solid  red");
		$("input[name=KHH]").css("border","solid  red");
	}else{
		$("input[name=YHKH]").css("border","solid 2px #999999");
		$("input[name=KHH]").css("border","solid 2px #999999");
		var returnValue = confirm("银行卡号："+YHKH+"\r"+"开户行："+KHH);
		if(returnValue==true){
			$("#bankInfo").submit();
		}
	}
}