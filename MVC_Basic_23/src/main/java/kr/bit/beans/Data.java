package kr.bit.beans;

import javax.validation.constraints.*;

public class Data {

	@Size(min = 4, max = 10)
	private String num1;

	private String num2;

	private String num3;

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}
}
