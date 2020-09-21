package kr.or.ddit.commons.dao;

import java.util.List;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ZipCodeVO;

public interface IZipCodeSearchDAO {
	public int selectTotalCount(PagingVO pagingVO); //페이징 처리를 위한
	public List<ZipCodeVO> selectZipcodeList(PagingVO pagingVO); //우편번호 선택
}
