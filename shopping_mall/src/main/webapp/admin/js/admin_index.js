const login_btn = document.querySelector("button");
const sign_up = document.querySelectorAll(".admin_info > li")[0];


login_btn.addEventListener("click",(e)=>{
	const id = document.querySelector("input[type='text']");
	const pw = document.querySelector("input[type='password']");
	if(id.value == '' || pw.value == ''){
		alert("아이디 또는 패스워드를 입력해주세요");	
		e.preventDefault();
	} else {
		const f = document.createElement("form");
		const f_login = document.querySelector(".admin_login");
		const section = document.querySelector(".admin_bgcolor");
		f.method = "post";
		f.action = "/admin_main.do";
		f.enctype = "application/x-www-form-urlencoded";
		f.append(f_login);
		section.append(f);
	}
});	


sign_up.addEventListener("click",()=>{
	location.href = "./add_master.do";
})


