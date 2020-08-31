/**
 * 
 */
$.fn.convertForm=function(resultArea){
	//var resultArea = $("#resultArea");
	resultArea = $(resultArea);
	var element = this.on("submit",function(event){ //$("[name=calForm]").on~
		event.preventDefault();
		var input = $(this).find(":input");
		let obj = {};
		let url = this.action;
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
		$.ajax({
			url : url,
			data : obj,
			success : function(resp){
				//console.log(resp);
				resultArea.text(resp);
			}
		})
		return false;
	});
	//console.log(element)
}
	
		