package kr.or.ddit.buyer.dao;

import kr.or.ddit.vo.BuyerVO;

/**
 * 거래처 관리 Persistence Layer
 *
 */
public interface IBuyerDAO {
	public BuyerVO selectBuyer(String buyer_id);
}
