package data;

import java.util.*;

public class Examination {
	private Boolean HIV_detect_;
	private Boolean HCV_detect_;
	private Boolean HBS_detect_;
	
	private Date test_data_ = new Date();
	
	public Examination(){
		HIV_detect_ = false;
		HCV_detect_ = false;
		HBS_detect_ = false;
		test_data_.setTime(0);
	}
	
	public Examination(Boolean HIV, Boolean HCV, Boolean HBS, Date test_date){
		HIV_detect_ = HIV;
		HCV_detect_ = HCV;
		HBS_detect_ = HBS;
		test_data_ = test_date;
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
}
