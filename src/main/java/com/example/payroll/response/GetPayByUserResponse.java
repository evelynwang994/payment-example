package com.example.payroll.response;

import java.util.List;

import com.example.payroll.entity.Payment;

public class GetPayByUserResponse extends BaseResponse {
	
	private int page;
	
	private List<Payment> paymentRecord;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Payment> getPaymentRecord() {
		return paymentRecord;
	}

	public void setPaymentRecord(List<Payment> paymentRecord) {
		this.paymentRecord = paymentRecord;
	}

}
