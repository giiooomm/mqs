
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
			
//			function init(){
//				window.setInterval("refreshbd()",3000);
//				atid = window.setInterval("addtemp()",3000);
//			}

			$(function(){
				$("#username").blur(function(){
					$.post("http://localhost:8080/mq/user/verifyCode",
							{username:$("#username").val()},
							function(data){
								if(data.verifyResult=="false"){
									alert("该账号已经被注册");
									$("#username").focus();
								}
					},"json");
									});
				
				$("#tbn").click(function(){
					$("#mos").toggle();
				});

				$("#select_se").change(function(){
					var selected = $(this).val();
					selectcity(selected);
				}); 
				setInterval("refreshbd()",3000);
				setTimeout("addtemp()",3000);


			})
			var citys = new Array(1);	
			citys[0] = new Array("南宁","柳州","桂林");
			citys[1] = new Array("广州","深圳","珠海");
			function selectcity(selected){
				$("#select_si").empty();
				$.each(citys,function(index,value){
					if(selected == index){
						$.each(citys[index], function(index2,value2) {
							var textnode = document.createTextNode(value2);
							var opEle    = document.createElement("option");
							$(opEle).append(textnode);
							$(opEle).appendTo("#select_si")
						});
					}
				})
			
			}
			
//			function refreshbd(){
//				var left = document.getElementById("3png").src;
//				document.getElementById("3png").src  = document.getElementById("4png").src;
//				document.getElementById("4png").src =left;
//			}
			
			function refreshbd(){
				
				var left = $("#3png").attr("src")
				var right = $("#4png").attr("src")
				 $("#4png").attr("src",left)
				 $("#3png").attr("src",right)
				
			}
			
//			function addtemp(){
//				document.getElementById("mos").style.display="block";
//				window.clearInterval(atid);
//				delid = window.setInterval("deltemp()",3000);
//			}
			function addtemp(){
				$("#mos").fadeIn(1000);
				setTimeout("deltemp()",3000);
			}
			
			function deltemp(){
				$("#mos").fadeOut(1000);
			}
			

			
