function registerform(){
				var ele = document.getElementById("username");
				var pa  = document.getElementById("password");
				var re =  document.getElementById("repassword");
				
				var username = ele.value;
				if(username == ""){
					alert("用户名为必填项!!");
					return false;
				}
				if(pa.value != re.value){
					alert("两次密码不一致!!");
					return false;
				}
				if(chkstrlen(username) != username.length){
					alert("请不要输入中文!!");
					return false;
				}
				alert(username);
				
			}
			function chkstrlen(str){
		　　　　var strlen = 0;
		　　　　for(var i = 0;i < str.length; i++){
		　　　　　　if(str.charCodeAt(i) > 255) //如果是汉字，则字符串长度加2
		　　　　　　　　strlen += 2;	
		　　　　　　else  
		　　　　　　　　strlen++;
		　　　　}
		　　　　return   strlen;
		　　}
			var atid,delid;
			
			function init(){
				window.setInterval("refreshbd()",3000);
				atid = window.setInterval("addtemp()",3000);
			}

			function refreshbd(){
				var left = document.getElementById("3png").src;
				document.getElementById("3png").src  = document.getElementById("4png").src;
				document.getElementById("4png").src =left;
			}
			
			function addtemp(){
				document.getElementById("mos").style.display="block";
				window.clearInterval(atid);
				delid = window.setInterval("deltemp()",3000);
			}
			
			function deltemp(){
				document.getElementById("mos").style.display="none";
				window.clearInterval(delid);
			}