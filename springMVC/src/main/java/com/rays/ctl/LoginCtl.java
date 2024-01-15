package com.rays.ctl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "Login")
public class LoginCtl {

	@Autowired
	protected UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, Model m,HttpSession session) {
		System.out.println("login display method!!!");
		if(form.getLogout()!=null) {
			session.invalidate();
			m.addAttribute("success", "User Logged Out Successfully..!!!");
		}
		return "Login";
	}

	@PostMapping
	public String submit(@ModelAttribute("form")@Valid LoginForm form, BindingResult bindingresult,@RequestParam(required = false) String Operation, Model m, HttpSession session) {
		if (bindingresult.hasErrors()) {
			return "Login";
		}
		if (Operation.equalsIgnoreCase("signIn")) {

			UserDTO dto = service.authenticate(form.getLogin(), form.getPassword());

			if (dto != null) {
				session.setAttribute("user", dto);
				return "redirect:/Welcome";

			} else {

				m.addAttribute("error", "INVALID USERNAME OR PASSWORD....!!!!");
			}

		} else if (Operation.equalsIgnoreCase("signUp")) {
			return "redirect:/UserRegistration";
		}

		return "Login";

	}
}
