package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kr.or.ddit.validate.UpdateGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of= {"prod_id"})
public class ProdVO implements Serializable{
	@NotBlank(groups=UpdateGroup.class)
	@Size(max = 10, groups=UpdateGroup.class)
	private String prod_id;
	@NotBlank
	@Size(max = 40)
	private String prod_name;
	@NotBlank
	@Size(max = 4)
	private String prod_lgu;
	private String lprod_nm;
	@NotBlank
	@Size(max = 6)
	private String prod_buyer;
	private Integer prod_cost;
	private Integer prod_price;
	private Integer prod_sale;
	@NotBlank
	@Size(max = 100)
	private String prod_outline;
	@Size(max = 4000)
	private String prod_detail;
	@NotBlank
	@Size(max = 40)
	private String prod_img;
	private Integer prod_totalstock;
	@Size(max = 7)
	private String prod_insdate;
	private Integer prod_properstock;
	@Size(max = 20)
	private String prod_size;
	@Size(max = 20)
	private String prod_color;
	@Size(max = 255)
	private String prod_delivery;
	private String prod_unit;
	private Integer prod_qtyin;
	private Integer prod_qtysale;
	private Integer prod_mileage;
	
	private BuyerVO buyer; // Prod has a Buyer 관계(1:1 관계 조인시 모델)
	
	private List<MemberVO> memberList; // 구매자 목록, Prod has many Member
}












