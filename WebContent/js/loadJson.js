$(function(){
	var ZJHM = encodeURI(encodeURI($(".ZJHM").text().substr(5)));
	var GZDW = encodeURI(encodeURI($(".GZDW").text().substr(5)));
	var KSXM = encodeURI(encodeURI($(".KSXM").text().substr(10)));
	var KSJB = encodeURI(encodeURI($(".KSJB").text().substr(5)));
	var KSLB = encodeURI(encodeURI($(".KSLB").text().substr(5)));
	$.ajax({
		type:'post',
		url: 'LoginCheckOrQiveUp?ZJHM='+ZJHM,
		dateType: 'json',
		success: function(result){
			var j = eval("("+result+")");
			$.each(j,function(n,value){
	            if(value == 2 || value == 1){
	            	var index = n+1;
	            	$("input[id=all]").remove();
	            	if(value == 1){
	            		$("a[id="+index+"]").append("(已确认)");
	            	}
	            	if(value == 2){
	            		$("a[id="+index+"]").append("(已放弃)");
	            	}
	            }
	        });
			if(j[5]==4){
				//if(j[6]!=null&&j[6]!=""){
					alert("银行信息未填写，点击确定填写银行信息");
					location.href="jsp/return.jsp?KSXM="+KSXM+"&GZDW="+GZDW+"&ZJHM="+ZJHM+"&KSLB="+KSLB+"&KSJB="+KSJB;
				//}
			}else if(j[5]==1){
				$("#buttonArea").html('<button onclick="querendanshowDialog()">打印考生考试确认单</button>');
			}else if(j[5]==2){
				$("#buttonArea").html('<button onclick="showDialog()">打印考生申请退费单</button>');
				if((j[7]!=null&&j[7]!="")&&(j[8]!=null&&j[8]!="")){
					$(".infor").css("height","230px");
					$(".sure").css("height","230px");
					$(".KHH").html('开&nbsp;&nbsp;户&nbsp;&nbsp;行 :<a style="font-size:15px;">'+'  '+j[7]+'</a>');
					$(".YHKH").html('银行卡号 :<a style="font-size:15px;">'+' '+j[8].substr(0,4)+"**** ****"+j[8].substr((j[8].length-4),4)+'</a>');
				}
			}
		}
	});
	
	$.ajax({
		
		type:'post',
		cache : false,
		async :false,
		dateType: 'json',
		url :'LogingetReturnJE?KSXM='+KSXM+'&ZJHM='+ZJHM,
		success:function(result){
			var j = eval("("+result+")");
			var JE = j[1]+j[2]+j[3]+j[4]+j[5]+13;
			$("#SumMoney").text(JE+"元");
		}
	});
});  

function showDialog(){
	var ZJHM = encodeURI(encodeURI($(".ZJHM").text().substr(5)));
	var url = "/returnPremiumSystem/jsp/showExcelData.jsp?ZJHM="+ZJHM;
	window.showModalDialog(url,'',"dialogWidth=850px;dialogHeight=1125px");
}

function querendanshowDialog(){
	var ZJHM = encodeURI(encodeURI($(".ZJHM").text().substr(5)));
	var url = "/returnPremiumSystem/jsp/showExcelDataQueren.jsp?ZJHM="+ZJHM;
	window.showModalDialog(url,'',"dialogWidth=850px;dialogHeight=1125px");
}