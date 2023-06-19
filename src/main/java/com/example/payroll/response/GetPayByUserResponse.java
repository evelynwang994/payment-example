package com.example.payroll.response;

import java.util.List;

import com.example.payroll.entity.Payment;

public class GetPayByUserResponse extends BaseResponse {
	
	private List<Payment> paymentRecord;

	public List<Payment> getPaymentRecord() {
		return paymentRecord;
	}

	public void setPaymentRecord(List<Payment> paymentRecord) {
		this.paymentRecord = paymentRecord;
	}

}
