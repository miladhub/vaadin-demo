package org.sample.login.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.apache.commons.io.FileUtils;
import org.sample.login.model.User;
import org.sample.login.model.UsersStore;

@Singleton
public class FileBasedUsersStore implements UsersStore {

	private List<String> contents;

	@PostConstruct
	public void readUsersFile() {
		readUsersFile(new File(System.getProperty("user.home")
				+ File.separator + "users.txt"));
	}

	public void readUsersFile(File usersFile) {
		try {
			if (!usersFile.exists()) {
				FileUtils.touch(usersFile);
			}
			contents = FileUtils.readLines(usersFile, Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new UsersFileAccessException(e);
		}
	}

	@Override
	public boolean existsUserWithUsername(String username) {
		for (String line : contents) {
			if (line.startsWith(username)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUserWithUsername(String username) {
		for (String line : contents) {
			if (line.startsWith(username)) {
				return new User(username, line.split(";")[1]);
			}
		}
		return null;
	}

}
