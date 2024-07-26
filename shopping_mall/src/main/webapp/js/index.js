$(()=>{
	$("#btn").click(function(){
		var $data = new Array();
		$data[0] = "20";
		$data[1] = "30";
		$data[2] = "40";
		console.log($data.join(","));
		
		$.ajax({
			url:"./ajaxok.do"
		});
	});
});