package user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public UserModel addUser(@RequestBody UserModel user) {
		try {
			System.out.println("ユーザーを追加しました。");
			return userService.add(user);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@GetMapping("/{username}")
	public UserModel getByUsername(@PathVariable String username) {
		try {
			return userService.searchByUsername(username);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@PutMapping("/{username}")
	public UserModel updateUser(@PathVariable String username, @RequestBody UserModel user) {
		try {
			return userService.update(username, user);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@DeleteMapping("/{username}")
	public UserModel deleteUser(@PathVariable String username) {
		try {
			return userService.delete(username);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@GetMapping("/login")
	public String userLogin(@RequestParam String username, @RequestParam String password) {
		UserModel user = userService.login(username, password);
		if (user != null) {
			return "ログインしました";
		}
		return "ログインに失敗しました";
	}

	@GetMapping("/logout")
	public String userLogout() {
		return "ログアウトしました";
	}
}
