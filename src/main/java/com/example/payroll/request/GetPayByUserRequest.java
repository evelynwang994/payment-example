package com.example.payroll.request;

public class GetPayByUserRequest {
	
	private String userId;
	
	// For pagination
	private int page;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
