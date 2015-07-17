function search(){
	var params=$("#searchInfo").serialize();
	$.ajax({     
		 type:"POST",  
		 url:"Searchsearch",
		 dataType:'JSON',
		 data:params, 
		 async :false,
		 beforeSend: function(data){
			 $("#load").show();
		 },
		 success:function(response){ 
				 $("table tbody tr").eq(0).nextAll().remove();
				 $("#load").fadeOut("10000",function(){
					 $("#page").show();
					 $.each(response,function(index,item){
						 if(response[index]!=null){
							 $('<tr><td style="border-bottom:1px solid #87ceeb;width:200px">'+response[index].KSXM+'</td><td style="border-bottom:1px solid #87ceeb;width:500px">'+response[index].ZJHM+'</td><td style="border-bottom:1px solid #87ceeb;width:80px"><button id=reset onclick=reset(this)>重置</button></td></tr>').insertAfter($($('#table').find('tr')[0]));
						 }
					 });	 
				 });
		 }    
	}); 
}
function reset(item){
	var index = $(item).parent().parent().index();
	var content = $("tr:eq("+index+")").children().eq(1).html();
	$.ajax({
		
		 type:"POST",    
		 url:"SearchresetInfo",
		 cache:false,
		 data:"ZJHM="+content,
		 success:function(){
			 alert("重置成功");
		 }
	});
}
function dCheck(item){
	var url = "ExportExportCheckOnPersonalExcel";
	$("#download").attr("action",url);
	$("#KSLB").val(item);
	$("#download").submit();
}
function qCheck(item){
	var url = "ExportExportQiveUpPersonalExcel";
	$("#download").attr("action",url);
	$("#KSLB").val(item);
	$("#download").submit();
}
function nCheck(item){
	var url = "ExportExportNoOperationPersonalExcel";
	$("#download").attr("action",url);
	$("#KSLB").val(item);
	$("#download").submit();
}