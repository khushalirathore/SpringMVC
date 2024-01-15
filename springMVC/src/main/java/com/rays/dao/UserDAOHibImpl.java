package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
    protected SessionFactory sessionFactory= null;
	
	
	public long add(UserDTO dto)  {
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
 		sessionFactory.getCurrentSession().update(dto);
	}

	public void delete(UserDTO ids) {
		sessionFactory.getCurrentSession().delete(ids);
		
	}

	public UserDTO findByPk(long pk) {
		return sessionFactory.getCurrentSession().get(UserDTO.class, pk);
	}

	
	public UserDTO authenticate(String login, String password) {
		Query q = sessionFactory.getCurrentSession().createQuery("from UserDTO where login=? and password=?");
		q.setString(0, login);
		q.setString(1, password);
		List list = q.list();
		UserDTO dto = null;
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	
	public List search(UserDTO dto, int pageNo, int pageSize) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {

				criteria.add(Restrictions.eq("firstName", dto.getFirstName()));

			}

			if (dto.getLastName() != null && dto.getLastName().length() > 0) {

				criteria.add(Restrictions.eq("lastName", dto.getLastName()));

			}

			if (dto.getDob() != null && dto.getDob().getTime() > 0) {

				criteria.add(Restrictions.eq("dob", dto.getDob()));

			}
			if(dto.getUserId()>0) {
				criteria.add(Restrictions.eq("id", dto.getUserId()));
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}

		List list = criteria.list();

		return list;

		
	}
		
	}
    
