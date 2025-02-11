function change(img) {
		
	img.src="getcode?"+new Date().getTime();
}


var flag=true;  //flag


function FocusItem(obj) {
	
	if($(obj).attr('name') == 'veryCode') {
		$(obj).next().next().html('').removeClass('error');
		
	}else {
		$(obj).next('span').html('').removeClass('error');
		
	}
	

	
}

function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	
	switch($(obj).attr('name')) {
		case "userName":
			if(obj.value == "") {
				msgBox.html("User name can't be empty");
				msgBox.addClass('error');
				flag=false;
			}else {
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				
				
				// "false" "true"
				$.get(url, function(data){
				
					
					if(data == "false") {
						msgBox.html("User name can't be used");
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}
					
				});
				
			}
		
			break;
		case "passWord":
			if(obj.value == "") {
				msgBox.html('Password can\'t be empty');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "rePassWord":
			if(obj.value == "") {
				msgBox.html('Password confirmation can\'t be empty');
				msgBox.addClass('error');
				flag=false;
			}else if($(obj).val() !=$('input[name="passWord"]').val() ){
				msgBox.html('The two passwords entered are not consistent');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "veryCode":
			var  numshow = $(obj).next().next();
			
			if(obj.value == "") {
				numshow.html('Verification code can\'t be empty');
				numshow.addClass('error');
				flag=false;
			}else {
			
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				$.get(url, function(data){
					if(data=="false") {
						numshow.html('Wrong verification code');
						numshow.addClass('error');
						flag=false;
					}else{
						numshow.html().removeClass('error');
						flag=true;
					}
					
				});
			
			}
			break;
			
	
	}
	
}



function checkForm(frm) {
	
	var els = frm.getElementsByTagName('input');
	
	
	for(var i=0; i<els.length; i++) {
		
		if(els[i] !=null ){
			if(els[i].getAttribute("onblur")) {
				CheckItem(els[i]);
			}
		}
	}
	
	return flag;
	
}