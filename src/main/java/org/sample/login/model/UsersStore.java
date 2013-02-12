package org.sample.login.model;

public interface UsersStore {
	boolean existsUserWithUsername(String username);

	User getUserWithUsername(String username);

}
