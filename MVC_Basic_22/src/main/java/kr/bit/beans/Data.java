package kr.bit.beans;

import javax.validation.constraints.*;

public class Data {

	@NotEmpty // 값의 길이가 0이면 오류 발생(공백도 글자로 인식)
	private String num1;

	@NotBlank // 공백제거하고 길이가 0이면 오류 발생
	private String num2;

	@Positive // 양수 아니면 오류
	private int num3;

	@PositiveOrZero
	private int num4;

	@Negative // 음수 아니면 오류
	private int num5;

	@Email // @기호가 있어야함(이메일 형식)
	private String num6;

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

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public String getNum6() {
		return num6;
	}

	public void setNum6(String num6) {
		this.num6 = num6;
	}

	public Data() {

		this.num1 = "aa";
		this.num2 = "aa";
		this.num3 = 40;
		this.num4 = 40;
		this.num3 = -3;

	}
}
