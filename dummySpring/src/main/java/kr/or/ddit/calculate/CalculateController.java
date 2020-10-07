package kr.or.ddit.calculate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.vo.CalculateVO;

@Controller
@RequestMapping("/calculate.do")
public class CalculateController {
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public String form() {
		return "calculate/calForm";
	}
	
	//마샬링
	@PostMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public CalculateVO processAjax(@ModelAttribute("calVO") CalculateVO calVO) {
		calVO.calculate();
		return calVO;
	}
	
//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public String process(@ModelAttribute("calVO") CalculateVO calVO) {
		calVO.calculate();
		return "calculate/calForm"; //jsp
	}
	
	//위 post코드 이렇게도 쓸 수 있음
	public ModelAndView process(@RequestParam(required=true) int leftOp,
			@RequestParam(required=true) int rightOp, ModelAndView mav) {
	int result = leftOp + rightOp;
	mav.addObject("result", result);
	mav.setViewName("calculate/calForm"); //jsp
	return mav;
}
}
