package kr.bit.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Data {

	@Max(100)
	private int num1;

	@Size(min = 4, max = 10)
	private String num2;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	
}
