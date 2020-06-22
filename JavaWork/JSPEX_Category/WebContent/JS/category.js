$(document).ready(function () {

	firstDepth();
	
});

function firstDepth() {
	
	$.ajax({
		url : "category.ajax",
		type: "POST",
	 	data : {
				"depth" : 1 ,
				"parent" : 0
				},  
		cache : false,
		success : function(data, status){
			// alert(JSON.stringify(data));
			if(status == "success"){
				alert("AJAX 성공!");
				$("#select1").attr("disabled", false);
				update(data);
			}
		}
	});
	
} // end firstDepth()
	

function update(jsonObj){
	result = "";
	result2 = "";
	result3 = "";
//		alert(JSON.stringify(jsonObj));
	if(jsonObj.status == "OK"){
		
		var count = jsonObj.count;
		var items = jsonObj.data; // 배열
			result += "<option value='0'>==선택하세요==</option>"
		for(i = 0; i < count; i++){
			result += "<option value='" + items[i].ca_uid  + "'>" + items[i].ca_name + "</option>"
		}
		$('#select1').html(result);
		
		$('#select1').change(function(){
			
			if($(this).val() == 0){
				$('#select2').html("");
				$('#select3').html("");
				$("#select2").attr("disabled", true);
				$("#select3").attr("disabled", true);
				return;
			} 
			
			result2 = "";
			result3 = "";
			$('#select2').html("");
			$('#select3').html("");
			$('#select3').attr("disabled", true);
			
			$.ajax({
				url : "category.ajax",
				type: "POST",
				data : {
					"depth" : 2 ,
					"parent" : $(this).val()
					},  
					cache : false,
					success : function(data, status){
				
//					alert(JSON.stringify(data));
						var count2 = 0;
					if(data.data.length != null){
						count2 = data.data.length;
					}
					
					result2 += "<option value='0'>==선택하세요==</option>"
						for(j = 0; j < count2; j++){
										
						result2 += "<option value='" + data.data[j].ca_uid  + "'>" + data.data[j].ca_name + "</option>"
					}
					$('#select2').html(result2);
					$('#select2').attr("disabled", false);
					
					$('#select2').change(function () {
						
						$.ajax({
							
							url : "category.ajax",
							type: "POST",
						 	data : {
									"depth" : 3 ,
									"parent" : $(this).val()
									},  
							cache : false,
							success : function(data, status){
								
//								alert(JSON.stringify(data));
								var count3 = data.data.length;
								result3 = "";
								$('#select3').html("");
								result3 += "<option>==선택하세요==</option>"
									
									
									for(k = 0; k < count3; k++){
														
										result3 += "<option value='" + data.data[k].ca_uid  + "'>" + data.data[k].ca_name + "</option>"
									}
								
									$('#select3').html(result3);
									$('#select3').attr("disabled", false);

									}
								})
						
							})
						}
						
					});
							
					});
				}
			}

	
	
