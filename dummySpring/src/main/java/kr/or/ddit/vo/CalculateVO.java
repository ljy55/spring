package kr.or.ddit.vo;

import lombok.Data;

@Data
public class CalculateVO {
	private int leftOp;
	private int rightOp;
	private int result;
	
	public void calculate() {
		result = leftOp + rightOp;
	}

		
}
