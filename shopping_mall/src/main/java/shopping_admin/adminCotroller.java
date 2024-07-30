package shopping_admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminCotroller {
	
	PrintWriter pw = null;
	
	@GetMapping("/admin")
	public String index() {
		return "index";
	}
	
	@PostMapping("/admin_main.do")
	public String admin_main(@RequestParam(required=true) String id,@RequestParam(required=true) String pw,HttpServletResponse res){
		return "/admin/admin_list";
	}
	
	@GetMapping("/admin/add_master.do")
	public String add_master() {
		return "/admin/add_master";
	}
}
