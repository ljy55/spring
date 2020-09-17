package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.validate.rule.PasswordCheck;
import kr.or.ddit.validate.rule.TelNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
@EqualsAndHashCode(of= {"mem_id"})
@ToString(exclude= {"mem_regno1", "mem_regno2"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO implements Serializable{
	
	@NotBlank(groups= {Default.class, DeleteGroup.class})
	@Size(max=15, groups= {Default.class, DeleteGroup.class})
	private String mem_id;
	@NotBlank(groups= {Default.class, DeleteGroup.class})
	@Size(max=15, groups= {Default.class, DeleteGroup.class})
	@PasswordCheck
	private String mem_pass;
	@NotBlank
	@Size(max=20)
	private String mem_name;
	@NotBlank(groups=InsertGroup.class)
	@Size(max=6, groups=InsertGroup.class)
	private String mem_regno1;
	@Size(max=7, groups=InsertGroup.class)
	@NotBlank(groups=InsertGroup.class)
	private String mem_regno2;
	private String mem_bir;
	@NotBlank
	@Size(max=7)
	private String mem_zip;
	@NotBlank
	@Size(max=100)
	private String mem_add1;
	@NotBlank
	@Size(max=80)
	private String mem_add2;
	@NotBlank
	@Size(max=14)
	@TelNumber
	private String mem_hometel;
	@NotBlank
	@Size(max=14)
	@TelNumber
	private String mem_comtel;
	@Size(max=15)
	@TelNumber
	private String mem_hp;
	@Email
	@NotBlank
	@Size(max=40)
	private String mem_mail;
	@Size(max=40)
	private String mem_job;
	@Size(max=40)
	private String mem_like;
	@Size(max=40)
	private String mem_memorial;
	private String mem_memorialday;
	private Integer mem_mileage;
	private String mem_delete;
}
