package shopping_admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class adminCotroller {
	
	PrintWriter pw = null;
	
	@GetMapping("/admin")
	public String index() {
		return "index";
	}
	
	@PostMapping("/admin_main.do")
	public String admin_main(HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		this.pw.print("<script>"
				+ "alert('test')"
				+ "</script>");
	//	System.out.println(a.toString());
		return null;
	}
}
