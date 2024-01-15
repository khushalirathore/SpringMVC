package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "UserList")
public class UserListCtl<UserServiceImpl> {
	
	@Autowired
	protected UserServiceInt service;
	
	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, Model m) {
//		UserDTO dto =  service.search(dto, pageNo, pageSize);
		
		System.out.println("userlist display method!!!");
		
	
		return "UserListView";
	}

}
