package com.jsp.medicworld.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jsp.medicworld.entity.User;


@Repository
@Component
public interface UserDao extends JpaRepository<User, Integer>
{
	@Query(value="select email from user where email=?1",nativeQuery=true)
	public String getusermail(String email);
	
	@Query(value="select * from user where email=?1",nativeQuery=true)
	public User getusermaill(String email);
	
	
	@Query(value="select * from user where email=?1  OR phone=?1",nativeQuery=true)
	public List<User> getnooremail();
	
	@Query("SELECT u FROM user u WHERE u.userName=:query OR u.email=:query")
	User findUser(String query);
	Optional<User> findByemail(String email);
	

	
	
}
