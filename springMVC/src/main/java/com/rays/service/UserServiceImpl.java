package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dto.UserDTO;
import com.rays.dao.UserDAOInt;


@Service
@Transactional
public class UserServiceImpl implements UserServiceInt{
	
	@Autowired
	protected UserDAOInt dao;

	@Transactional(readOnly = false)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
			return pk;
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO authenticate(String login, String password) {
		UserDTO dto = dao.authenticate(login, password);
		return dto;
	}

	@Override
	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
 		dao.delete(dto);
	}

	@Override
	public UserDTO findByPk(long pk) {
	  return dao.findByPk(pk);
	}
	
}
