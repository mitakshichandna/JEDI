package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.UserDao;
import com.flipkart.exceptions.StudentNotApprovedException;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.exceptions.UsernameAlreadyInUseException;
import com.flipkart.dao.UserDaoInterface;

public class UserBusiness implements UserInterface{
	//Map<String,User> users =new HashMap<>();
	UserDaoInterface udi=new UserDao()
;	
	public User retrieve(String username, String password) {
		User user;
		try {
			user = udi.getUser(username);
			if(user!= null && password.equals(user.getPassword()))
				return user;
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void createNewUser(String username, User user){
		users.put(username, user);
	}
	
	public boolean changePassword(String username, String password, String newPassword){
		try {
			return udi.updatePassword(username, password, newPassword);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public String registerStudent(String username, String name, String contact, 
			String email, String password, String branch) {
		try {
			return udi.registerStudent(username, name, contact, email, password, branch);
		} catch (UsernameAlreadyInUseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public User findByID(String id) {
		return users.values().stream()
	            .filter(user -> user.getID().equals(id))
	            .findFirst()
	            .orElse(null);
	}
	
	public void printUsers() {
		users.values().stream()
        .filter(user -> "Student".equals(user.getRole()))
        .map(user -> (Student) user)
        .forEach(stu -> System.out.println(stu.getID() + "-" + stu.getName()));
	}
}