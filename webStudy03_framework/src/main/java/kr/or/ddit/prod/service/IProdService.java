package kr.or.ddit.prod.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리 Business Logic Layer
 *
 */
public interface IProdService {
	/**
	 * 신규 상품 등록
	 * @param prod
	 * @return OK, FAILED, prod_id(pk)를 개발자가 생성해서 부여해줘야함
	 */
	public ServiceResult createProd(ProdVO prod);
	/**
	 * 상품 상세 조회
	 * @param prod_id
	 * @return 존재하지 않는다면, CustomException 발생
	 */
	public ProdVO retrieveProd(String prod_id);
}
