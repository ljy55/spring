package kr.or.ddit.buyer.service;

import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.buyer.dao.IBuyerDAO;
import kr.or.ddit.exception.CustomException;
import kr.or.ddit.vo.BuyerVO;

public class BuyerServiceImpe implements IBuyerService {
	private IBuyerDAO dao = BuyerDAOImpl.getInstance();
	
	private static BuyerServiceImpe self;
	
	public BuyerServiceImpe() {
		super();
	}

	public static BuyerServiceImpe getInstance() {
		if(self==null) self = new BuyerServiceImpe();
		return self;
	}
	@Override
	public BuyerVO retrieveBuyer(String buyer_id) {
		BuyerVO buyer = dao.selectBuyer(buyer_id);
		if(buyer==null)
			throw new CustomException(buyer_id + "는 존재하지 않는 거래처 입니다");
		return buyer;
	}

}
