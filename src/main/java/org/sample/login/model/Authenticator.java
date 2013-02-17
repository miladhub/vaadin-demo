package org.sample.login.model;

public final class Authenticator implements LoginService {

	private UsersStore usersStore;
	
	private PasswordMatcher passwordMatcher = new PasswordMatcher() {
		@Override
		public boolean passwordMatches(String userPassword, String password) {
			return userPassword.equals(password);
		}
	};
	
	public Authenticator(UsersStore usersStore) {
		super();
		this.usersStore = usersStore;
	}

	@Override
	public boolean authenticate(String username, String password) {
		if (!usersStore.existsUserWithUsername(username)) {
			return false;
		}
		User user = usersStore.getUserWithUsername(username);
		return passwordMatcher.passwordMatches(user.getPassword(), password);
	}

}
