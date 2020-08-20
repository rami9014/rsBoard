package com.rs.board.test.contoller;

import org.springframework.web.bind.annotation.RestController;
import com.rs.board.test.entity.User;
import com.rs.board.test.repository.UserRepository;
import com.rs.board.test.util.Hashing;
import com.rs.board.test.util.Session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String registerUser(@RequestBody User user) {
		String username = user.getUsername();
		String password = Hashing.hashingPassword(user.getPassword());
		String email = user.getEmail();

		if (username.equals("") || password.equals("") || email.equals(""))
			return "failed";

		User accountInfo = new User();
		accountInfo.setUsername(username);
		accountInfo.setPassword(password);
		accountInfo.setEmail(email);

		if (userRepository.findByUsername(username) != null)  return "failed";

		userRepository.save(accountInfo);

		return "success";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody User account,HttpSession session) {
		try {
			String username = account.getUsername();
			String password = Hashing.hashingPassword(account.getPassword());
			User userInfo = userRepository.findByUsernameAndPassword(username, password);
			
			if(userInfo != null) {
				session.setAttribute(Session.SESSION_ID, userInfo);
				return "success";
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout (HttpSession session) {
		session.removeAttribute(Session.SESSION_ID);
		return "redirect:/";
	}
	
}