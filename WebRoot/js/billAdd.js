$(function(){
	var num=$("#num").val();
	if(num==1){
		        $('.zhezhao').css('display', 'block');
		        $('#removeBi').fadeIn();
		    $('#no').click(function () {
		        $('.zhezhao').css('display', 'none');
		        $('#removeBi').fadeOut();
		    });
		    $('#yes').click(function () {
		    	$('.zhezhao').css('display', 'none');
		    	$('#removeBi').fadeOut();
		    });
		    
		
	}
	
	
	
	
			$("#billNum").blur(function(){
				//alert(2);
			var data="Num="+$("#billNum").val();
				$.ajax({
				url:'IsNumber',
				type:'post',
				data:data,
				dataType:'text',
				success:function(result){
				if(result==-1){
					//alert(1);
				$("#billNums").val("");
				}else{
				$("#billNums").val("123");
				}
				}
				});
			});
			$("#money").blur(function(){
				var data="Num="+$("#money").val();
				$.ajax({
					url:'IsNumber',
					type:'post',
					data:data,
					dataType:'text',
					success:function(result){
						if(result==-1){
							$("#moneys").val("");
						}else{
							$("#moneys").val("123");
						}
					}
				});
			});
			
	
});

//验证提交，onsubmit事件的函数
function check(){
	var supplier=document.getElementById("supplier");
	var billNums=document.getElementById("billNums");
	var moneys=document.getElementById("moneys");
	if(billNums.value == ""){
		alert("商品数量为正数！！");
		billNum.focus();
		return false;
	}else if(moneys.value == ""){
		alert("总金额为正数！！");
		money.focus();
		return false;
	}else if(supplier.value == ""){
		alert("供应商不能为空！！");
		supplier.focus();
		return false;
	}	
	return true;
}


