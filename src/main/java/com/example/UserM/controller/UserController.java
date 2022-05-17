package com.example.UserM.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserM.entity.User;
import com.example.UserM.repository.UserRepository;
import com.example.UserM.service.UserService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
public class UserController {
	@Autowired
	private UserService userSer;

	@Autowired
	private UserRepository UserRepo;

	@Autowired
	private BCryptPasswordEncoder bp;

	@GetMapping("/")
	public String home(Model m) {
		List<User> user = userSer.getAllUser();
		m.addAttribute("user", user);
		return "index";
	}

	@GetMapping("/dashboard")
	public String dasboard(Model m) {
		List<User> user = userSer.getAllUser();
		m.addAttribute("user", user);
		return "dashboard";
	}

	@GetMapping("/addUser")
	public String addUser() {
		return "addUser";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User e, HttpSession session) {
		System.out.println(e);

		e.setPassword(bp.encode(e.getPassword()));

		e.setRole("ROLE_USER");
		e.setDob(LocalDateTime.now());
		UserRepo.save(e);
		// userSer.addUser(e);
		session.setAttribute("msg", "User Added Successfully");
		return "redirect:/";

	}

	@GetMapping("/login")
	public String login() {

		return "login";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		User u = userSer.getUserByID(id);
		m.addAttribute("user", u);
		return "edit";

	}

	@PostMapping("/update")
	public String update(@ModelAttribute User e, HttpSession session) {
		userSer.addUser(e);
		session.setAttribute("msg", "User updated successfully");
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {

		userSer.deleteById(id);
		session.setAttribute("msg", "User deleted successfully");
		return "redirect:/";

	}

	@GetMapping("/delete/")
	public String deleteAll() {

		userSer.deleteAll();
		return "redirect:/";

	}

}
