/**
 * 
 */
$.fn.convertForm=function(object){
	//var resultArea = $("#resultArea");
	//resultArea = $(resultArea);
	var element = this.on("submit",function(event){ //$("[name=calForm]").on~
		event.preventDefault();
		if(object.init){
			object.init();
		}
		if(object.validation && !object.validation()){
			return false;
		};
		var input = $(this).find(":input");
		let obj = {};
		let url = this.action;
		let method = this.method;
		input.each(function(index, tag){
			//console.log(tag);
			let name = tag.name; //tag.name == $(this).attr("name");
			//console.log(name);
			if(name){
				//console.log(tag.value); //console.log($(tag.val()))
				let value = tag.value;
				/* obj.put("leftOp", )
				obj.leftOp
				obj[name] */
				obj[name] = value;
				console.log(obj);
			}
		});
		
		//동기 처리를 비동기로 전환
		//주소, 파라미터(데이터), method, 응답데이터의 mime(dataType), 성공(success), 실패(error)
		$.ajax({
			url : url,
			data : obj,
			method : method,
			success : object.success
		})
		return false;
	});
	//console.log(element)
}
	
		