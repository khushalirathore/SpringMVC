package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {
	
	public long add(UserDTO dto);
	
	public void update(UserDTO dto);
	
	public void delete(UserDTO ids);
	
	public UserDTO authenticate(String login, String password);
	public List search(UserDTO dto, int pageNo, int pageSize);
	
	public UserDTO findByPk(long pk);
	

}
