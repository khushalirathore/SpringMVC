package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.AddForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl {
	
	@Autowired
	public UserServiceInt service;
	
	@ModelAttribute("form")
	public void Preload(@RequestParam(required = false) String operation,UserForm form,Model model) {
		List list = service.search(null, 0, 0);
		model.addAttribute("userList", list);
	}
	
	@GetMapping()
	public String display(@ModelAttribute("form") UserForm form, Model m, @RequestParam(required = false) Long id) {
		UserDTO dto = null;
		if (form.getId() > 0) {
			dto = service.findByPk(form.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLogin(dto.getLogin());
			form.setPassword(dto.getPassword());
			form.setDob(DataUtility.dateToString(dto.getDob()));
			form.setAddress(dto.getAddress());

			m.addAttribute("form", form);
		}

		return "UserView";

	}
	@PostMapping
	public String Update(@ModelAttribute("form") UserForm form,@RequestParam(required = false) String operation, Model m) {
		
		UserDTO dto = null;
		if(operation.equals("Update")) {
			dto = new UserDTO();	
			dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());
		service.update(dto);
		m.addAttribute("message","User updated Successfully");
		
	} else if (operation.equals("Add")) {
		dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		service.add(dto);
	}
	return "UserView";
}
	

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {
		int pageNo = 1;
		int pageSize = form.pageSize;
		List list = service.search(null, pageNo, pageSize);
		form.setPageNo(pageNo);
		model.addAttribute("list",list);
		return "UserListView";

	}
	
	@PostMapping("search")
	public String search(@ModelAttribute("form") UserForm form,@RequestParam(required=false) String operation,Model model) {
		UserDTO dto = null;
		int pageNo = form.getPageNo();
		int pageSize = form.pageSize;
		long[] ids = form.getIds();
		
		if(operation.equals("search")) {
			dto =  new UserDTO();
			 dto.setFirstName(form.getFirstName());
			 dto.setUserId(form.getUserId());
		}

		if(operation.equals("Add")) {
			return "redirect:/ctl/User";
			}
		 if(operation.equals("Next")) {
				pageNo++;
				
			}
			if(operation.equals("Previous")) {
				pageNo--;
				
			}
		
		if(operation.equals("Delete")) {
			pageNo =1;
		if(ids!= null && ids.length>0) {
			for (long id : ids) {	
				UserDTO delete = new UserDTO();
				System.out.println("ids=" + id);
				delete.setId(id);
				service.delete(delete);
			}
			}
		}
		form.setPageNo(pageNo);
		List list = service.search(dto, pageNo, pageSize);
		model.addAttribute("list",list);
		return "UserListView";
	}
	
}
