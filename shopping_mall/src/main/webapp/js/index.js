$(()=>{
	
	$("#btn2").click(function(){
		var $data = new Array();
		$data[0] = "홍길동";
		$data[1] = "강감찬";
		$data[2] = "이순신";
		// JSON.stringify : Object 형태로 전달
		$.ajax({
			url : "./ajaxok2.do",
			type : "post",
			cache : false,
			dataType : "json",
			contentType : "application/json",
			data:JSON.stringify({
				"all_data" : $data
			}),
			success : function($result){
				console.log($result);
			}, error : function(){
				console.log("error!!!");
			}
		})
	});
	
	
	
	$("#btn").click(function(){
		var $data = new Array();
		$data[0] = "20";
		$data[1] = "30";
		$data[2] = "40";
		//join → JSON.stringfy 형태로 변환
		console.log($data.join(","));
		
		$.ajax({
			url:"./ajaxok.do",
			cache : false,
			dataType : "json",
			contentType:"application/json;",
			type:"get",
			data:{
				"all_data":$data.join(",")
			},
			success:function($result){
				console.log($result)
			},
			error:function(){
				console.log("error!!");
			}
		});
	});
});