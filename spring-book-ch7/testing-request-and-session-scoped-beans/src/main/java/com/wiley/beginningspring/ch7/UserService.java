package com.wiley.beginningspring.ch7;

public class UserService {
	private LoginAction loginAction;
	private UserPreferences userPreferences;
	public LoginAction getLoginAction() {
		return loginAction;
	}
	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}
	public UserPreferences getUserPreferences() {
		return userPreferences;
	}
	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}
}
