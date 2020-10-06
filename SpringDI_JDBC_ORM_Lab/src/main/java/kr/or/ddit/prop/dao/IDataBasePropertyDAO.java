package kr.or.ddit.prop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DataBasePropertyVO;

@Repository
public interface IDataBasePropertyDAO {
	public List<DataBasePropertyVO> selectDataBaseProperties(@Param("propParam") DataBasePropertyVO param);
	public List<String> selectAllProperty_names();
}
