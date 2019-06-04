package com.sawforgarden.myapp.model;

public class RestorePassword {

	private String emailAddress;
	private String InputedCode;
	private String verificationCodeExpected;
	private String newPassword;
	private String repeateNewPassword;
	private boolean restore;
	private boolean thatCheckPoint=false;
	private boolean thatCheckPointSecond=false;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getInputedCode() {
		return InputedCode;
	}
	public void setInputedCode(String inputedCode) {
		InputedCode = inputedCode;
	}
	public String getVerificationCodeExpected() {
		return verificationCodeExpected;
	}
	public void setVerificationCodeExpected(String verificationCodeExpected) {
		this.verificationCodeExpected = verificationCodeExpected;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public boolean isRestore() {
		return restore;
	}
	public void setRestore(boolean restore) {
		this.restore = restore;
	}
	public String getRepeateNewPassword() {
		return repeateNewPassword;
	}
	public void setRepeateNewPassword(String repeateNewPassword) {
		this.repeateNewPassword = repeateNewPassword;
	}
	public boolean isThatCheckPoint() {
		return thatCheckPoint;
	}
	public void setThatCheckPoint(boolean thatCheckPoint) {
		this.thatCheckPoint = thatCheckPoint;
	}
	public boolean isThatCheckPointSecond() {
		return thatCheckPointSecond;
	}
	public void setThatCheckPointSecond(boolean thatCheckPointSecond) {
		this.thatCheckPointSecond = thatCheckPointSecond;
	}
	
	
}
