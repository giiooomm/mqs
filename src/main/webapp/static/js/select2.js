function loadSelect(typeCode,positionId,selectName,selectId){

		var $select = $("<select name="+selectName+"></select>");
		$select.append($("<option>--------------------</option>"));

		$.post("${pageContext.request.contextPath }/BaseDictAction",{dict_type_code:typeCode},
			function(data){
				$.each(data,function(i,json){
				$option=$("<option value="+json["dict_id"]+">"+json["dict_item_name"]+"</option>");
				if(json["dict_id"] == selectId){
					$("#optin").attr("selected","selected");
				}
				$select.append($option);
				});
			},"json");
			
			$("#"+positionId).append($select);
	}
	


	