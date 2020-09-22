package kr.or.ddit.buyer.service;

import kr.or.ddit.vo.BuyerVO;

/**
 * 거래처 관리  Business Logic Layer
 *
 */
public interface IBuyerService {
	public BuyerVO retrieveBuyer(String buyer_id);
}
