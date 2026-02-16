package petstore.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	List<UserModel> usersList = new ArrayList<>();
	Long userCount = 1L;

	public UserModel addUserInfo(UserModel user) {
		user.setId(userCount);
		userCount++;
		usersList.add(user);
		return user;
	}

	public UserModel userSearch(String username) {
		for (UserModel usn : usersList) {
			if (usn.getUsername().equals(username)) {
				return usn;
			}
		}
		return null;
	}

	public UserModel updateUserInfo(String username, UserModel user) {
		UserModel updUser = userSearch(username);
		if (updUser == null) {
			System.out.println("指定したユーザー名が存在しません");
			return null;
		}
		updUser.setFirstName(user.getFirstName());
		updUser.setLastName(user.getLastName());
		updUser.setEmail(user.getEmail());
		updUser.setPassword(user.getPassword());
		updUser.setPhone(user.getPhone());
		updUser.setUserStatus(user.getUserStatus());
		return updUser;
	}

	public UserModel deleteUserInfo(String username) {
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getUsername().equals(username)) {
				return usersList.remove(i);
			}
		}
		return null;
	}
}
