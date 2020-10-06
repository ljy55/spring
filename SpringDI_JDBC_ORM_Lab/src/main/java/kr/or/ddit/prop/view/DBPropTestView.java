package kr.or.ddit.prop.view;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.prop.service.IDataBasePropertyService;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DBPropTestView {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new GenericXmlApplicationContext("classpath:/kr/or/ddit/conf/DBProp-Context.xml");
		DataSource dataSource = context.getBean(BasicDataSource.class);
		System.out.println(dataSource.toString());
		IDataBasePropertyService service = context.getBean(IDataBasePropertyService.class);
		System.out.println(service);
		List<String> names = service.readAllProperty_names();
		System.out.println(names);
		List<DataBasePropertyVO> list = service.readDataBaseProperties(null);
		for(DataBasePropertyVO tmp : list) {
			System.out.println(tmp);
		}
	}
}
