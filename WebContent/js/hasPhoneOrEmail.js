function hasPhoneOrEmail() {

	var name = encodeURI(encodeURI($("input[name=name]").val()));
	var psw = encodeURI(encodeURI($("input[name=psw]").val()));
	var code = encodeURI(encodeURI($("input[name=code]").val()));
	$.ajax({
		type : 'post',
		url : 'LoginhasPhoneOrEmail?name=' + name + '&psw=' + psw + "&code="
				+ code,
		dataType : 'text',
		success : function(data) {
			var j = eval("(" + data + ")");
			if (j[2] == "true") {
				if (j[0] == "yesUser") {
					if (j[1] == "empty") {
						$("#msg").text("");
						//showDialog();
						location.href="/returnPremiumSystem/jsp/savePhoneAndEmail.jsp?ZJHM="+psw;
					} else if (j[1] == "unEmpty") {
						$("#info").submit();
					}
				}else{
					$("#msg").text("用户信息错误");
				}
			} else if (j[0] == "noUser") {
				$("#msg").text("用户信息错误");
			} else if (j[2] == "false" && j[0] == "yesUser") {
				$("#msg").text("验证码错误");
			}

		}
	});
}
function showDialog(){
	var ZJHM = encodeURI(encodeURI($("input[name=psw]").val()));
	var url = "/returnPremiumSystem/jsp/savePhoneAndEmail.jsp?ZJHM="+ZJHM;
	var value = window.showModalDialog(url,'',"dialogWidth=400px;dialogHeight=120px");
	if(value==1){
		$("#info").submit();
	}
}