package kr.or.ddit.prod.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.resolvers.ModelData;
import kr.or.ddit.mvc.annotation.resolvers.RequestParameter;
import kr.or.ddit.prod.dao.IOthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.validate.CommonValidator;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;

@CommandHandler
public class ProdUpdateController {
	IProdService service = new ProdServiceImpl();
	IOthersDAO othersDAO = new OthersDAOImpl();
	
	
	public void addAttribute(HttpServletRequest req){
		req.setAttribute("lprodList", othersDAO.selectLprodGuList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList());
	}
	
	
	@URIMapping(value="/prod/prodUpdate.do", method=HttpMethod.GET)
	public String getForm(@RequestParameter(name="what") String prod_id, HttpServletRequest req, HttpServletResponse resp) {
		addAttribute(req);
		ProdVO prod = service.retrieveProd(prod_id);
		req.setAttribute("command", "update");
		req.setAttribute("prod", prod);
		String goPage = "prod/prodForm";
		return goPage;		
	}
	
	@URIMapping(value="/prod/prodUpdata.do", method=HttpMethod.POST)
	public String modify(@ModelData(name="prod") ProdVO prod, HttpServletRequest req, HttpServletResponse resp) {
		addAttribute(req);
//		2. 검증(DB 스키마 구조 참고)
		Map<String, StringBuffer> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		CommonValidator<ProdVO> validator = new CommonValidator<>();
		boolean valid = validator.validate(prod, errors, UpdateGroup.class);
		
		String goPage = null;
		String message = null;
		if(valid) {
//		3. 통과
//		4. 통과한 경우, 로직을 이용한 수정
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case FAILED:
				goPage = "prod/prodForm";
				message = "서버 문제로 수정이 완료되지 않았습니다 잠시 후 다시 시도해주세요.";
				break;

			default:
				goPage = "redirect:/prodView.do?what=" + prod.getProd_id();
				break;
			}
			
		}else {
//		   불통
			goPage = "prod/prodForm";
			
		}
//		  등록 이후의 경우의 수에 대한 처리
		req.setAttribute("message", message);
		return goPage;
	}
}
