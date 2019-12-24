package com.file.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author vinod.nagulkar
 * This model is used to add question in DB.
 */
@Entity
@Table(name="Questions")
public class Questions implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Ques_No")
	int no;
	
	@Column(name="Ques")
	String ques;
	
	@Column(name="Option1")
	String option1;
	
	@Column(name="Option2")
	String option2;
	
	@Column(name="Option3")
	String option3;
	
	@Column(name="Option4")
	String option4;
	
	@Column(name="RightOpt")
	String rightOption;
	
	
	
	public Questions() {}
	
	public Questions(int no, String ques, String option1, String option2, String option3, String option4,
			String rightOption) {
		
		this.no = no;
		this.ques = ques;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightOption = rightOption;
		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getRightOption() {
		return rightOption;
	}
	public void setRightOption(String rightOption) {
		this.rightOption = rightOption;
	}

	@Override
	public String toString() {
		return "Questions [no=" + no + ", ques=" + ques + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", rightOption=" + rightOption + "]";
	}
	
	
}
