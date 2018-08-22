/**
 * Created by yaling.he on 2015/11/17.
 */

//供应商管理页面上点击删除按钮弹出删除框(providerList.html)

/*$(function () {
    $('.removeProvider').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeProv').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeProv').fadeOut();
    });
});*/


//订单管理页面上点击删除按钮弹出删除框(billList.html)
$(function () {
		var l=$("#payments").val();
    	if(l =='123'){	
        $('.zhezhao').css('display', 'block');
        $('#removeBi').fadeIn();
    	}
        
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});
$(function () {
	$("#yes3").click(function(){
		$('.zhezhao').css('display', 'block');
		$('#removeBi4').fadeIn();	
	});
	
		
});

$(function () {
	$('#no4').click(function () {
		$('.zhezhao').css('display', 'none');
		$('#removeBi3').fadeOut();
	});
});
//订单管理页面上点击删除按钮弹出删除框(billList.html)

$(function () {
	var l=$("#payment").val();
	if(l==125 ){
		var billremove= $("#billremove").val();
		var nid= $("#payment1").val();
		var page_no= $("#payment2").val();
		var proname= $("#payment3").val();
		var tigong= $("#payment4").val();
		var fukuan= $("#payment5").val();
		//nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}
		window.location.href="DeleteBillServlet?billCode="+billremove+
		"&billnum2=126"+"&nid="+nid+"&page_no="+page_no+"&proname="+proname+"&tigong="+tigong+"&fukuan="+fukuan;
	}
});
$(function () {
	var l=$("#paymentss").val();
	if(l =='125'){	
    $('.zhezhao').css('display', 'block');
    $('#removeBi1').fadeIn();
	}
    
});

$(function () {
	$('#no1').click(function () {
		$('.zhezhao').css('display', 'none');
		$('#removeBi1').fadeOut();
	});
});




$(function () {
	var result=$("#result").val();
	if(result =='126'){	
    $('.zhezhao').css('display', 'block');
    $('#removeBi2').fadeIn();
	}
    
});

//用户管理页面上点击删除按钮弹出删除框(userList.html)
/*$(function () {
    $('.removeUser').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeUse').fadeIn();
    });
});
*/
/*$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
});*/
