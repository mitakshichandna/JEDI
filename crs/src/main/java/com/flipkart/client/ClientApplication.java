package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Catalog;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.*;
import java.util.Scanner;

public class ClientApplication {
	static UserBusiness userInstance;
	static Catalog catalog;
	
	public static void main(String[] args) {
		int input = 0;
		String username = null, password = null;
		userInstance = new UserBusiness();
		catalog = new Catalog();
		Scanner s = new Scanner(System.in);
		
		// Main menu loop
		while (input != 4) {
//			System.out.println("\u001B[34m"+"TEST"+"\u001B[0m");
//			System.out.print("\\u033[H\\033[2J");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.flush();
			System.out.println("Welcome to the CRS Application :-->");
			System.out.println("1: Login");
			System.out.println("2: Registration");
			System.out.println("3: Update Password");
			System.out.println("4: Exit");
			input = s.nextInt();
			
			switch (input) {
				case 1:
					System.out.println("Enter the Username :--");
					username = s.next();
					System.out.println("Enter the Password :--");
					password = s.next();
					login(username, password);
					break;
				case 2:
					studentRegistration();
					break;
				case 3:
					updatePassword();
					break;
				case 4:
					continue;
				default:
					System.out.println("Invalid command");
			}
		}
	}
	
	/**
	 * Handles user login based on username and password.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 */
	public static void login(String username, String password) {
		User user = userInstance.retrieve(username, password);
		
		if (user == null) {
			System.out.println("Wrong username/password. \nTRY AGAIN\n");
			return;
		}

        switch (user.getRole()) {
            case "Student":
                if (!((Student) user).isApproved()) return;
                StudentMenu studentOps = new StudentMenu();
                studentOps.studentMenu((Student) user, username);
                break;
            case "Professor":
                ProfMenu profops = new ProfMenu();
                profops.professorMenu((Professor) user, username);
                break;
            case "Admin":
                AdminMenu adminops = new AdminMenu();
                adminops.adminMenu((Admin) user, username);
                break;
        }
	}
	
	/**
	 * Handles student registration by taking user input and registering a new student.
	 */
	public static void studentRegistration() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Username :");
		String username = s.next();
		s.nextLine();
		System.out.println("Enter Display Name :");
		String name = s.nextLine();
		System.out.println("Enter Details: \ncontact \temail \tbranch \tpassword");
		
		String details = s.nextLine();
        
        // Split the details input into separate fields
        String[] detailsArray = details.split(" ");
        
		String contact = detailsArray[0], email = detailsArray[1], 
				branch = detailsArray[2], password = detailsArray[3];
		
		System.out.println(userInstance.registerStudent(username, name, contact, email, password, branch));		
	}
	
	/**
	 * Handles password update for a user.
	 * username The username of the user whose password needs to be updated.
	 * password The old password of the user.
	 * newPassword The new password to be set.
	 */
	public static void updatePassword() {
		Scanner s = new Scanner(System.in);
		String username, password, newPassword;
		System.out.println("Enter the Username :-");
		username = s.next();
		System.out.println("Enter old Password :-");
		password = s.next();
		System.out.println("Enter new Password :-");
		newPassword = s.next();
		
		if (userInstance.changePassword(username, password, newPassword)) {
			System.out.println("Password changed successfully");
		}
	}
}
