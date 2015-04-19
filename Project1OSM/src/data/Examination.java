package data;

import java.util.*;

public class Examination {
	private Boolean HIV_detect_;
	private Boolean HCV_detect_;
	private Boolean HBS_detect_;
	
	private Boolean examination_flag_;
	
	private Date test_data_ = new Date();
	
	public Examination(){
		HIV_detect_ = false;
		HCV_detect_ = false;
		HBS_detect_ = false;
		examination_flag_ = false;
		test_data_.setTime(0);
	}
	
	public Examination(Boolean HIV, Boolean HCV, Boolean HBS, Date test_date){
		HIV_detect_ = HIV;
		HCV_detect_ = HCV;
		HBS_detect_ = HBS;
		test_data_ = test_date;
	}
	
	public Boolean getExamination_flag_() {
		return examination_flag_;
	}

	public void setExamination_flag_() {
		this.examination_flag_ = true;
	}
	
	public void eraseExamination_flag_() {
		this.examination_flag_ = false;
	}
	
	public Boolean getHIV_detect_() {
		return HIV_detect_;
	}

	public void setHIV_detect_(Boolean hIV_detect_) {
		HIV_detect_ = hIV_detect_;
	}

	public Boolean getHCV_detect_() {
		return HCV_detect_;
	}

	public void setHCV_detect_(Boolean hCV_detect_) {
		HCV_detect_ = hCV_detect_;
	}

	public Boolean getHBS_detect_() {
		return HBS_detect_;
	}

	public void setHBS_detect_(Boolean hBS_detect_) {
		HBS_detect_ = hBS_detect_;
	}

	public Date getTest_data_() {
		return test_data_;
	}

	public void setTest_data_(Date test_data_) {
		this.test_data_ = test_data_;
	}
	
	/** method for compare examinations */
	public boolean equals(Examination e){
		if(e==null || this.HBS_detect_ !=e.HBS_detect_ || this.HCV_detect_ !=e.HCV_detect_ || this.HIV_detect_ !=e.HIV_detect_)
			return false;
		else
			return false;
	}
	
	/** methods return object representation w String text */
	public String toString(){
		return ("HIV: " + String.valueOf(HIV_detect_) + "; " + "HBS: " + String.valueOf(HBS_detect_) + "; " + "HCV: " + String.valueOf(HCV_detect_));
	}
}
