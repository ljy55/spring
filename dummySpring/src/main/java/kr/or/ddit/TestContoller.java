package kr.or.ddit;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestContoller {
	@RequestMapping("/test.do")
	public String test(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		return "testView";
	}
}
