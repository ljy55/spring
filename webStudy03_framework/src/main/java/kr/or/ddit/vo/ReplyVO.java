package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= {"rep_no", "bo_no"})
public class ReplyVO implements Serializable {
	@NotBlank
	private Integer renum;
	@NotBlank
	private Integer bonum;
	@NotBlank
	@Size(max = 15)
	private String name;
	@NotBlank
	@Size(max = 1000)
	private String cont;
	@NotBlank
	@Size(max = 7)
	private String redate;
}
