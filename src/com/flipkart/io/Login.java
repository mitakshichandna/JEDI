package com.flipkart.io;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Login {
    public void main(){
        int input;
        String userName;
        String password;
        String Role;
        Map<String, Menu> menus = new HashMap();
        boolean exit = false;
        boolean details = false;
        Scanner sc = new Scanner(System.in);

        menus.put("Admin", new AdminMenu());
        menus.put("Professor", new ProfessorMenu());
        menus.put("Student", new StudentMenu());

        while(!exit){
            System.out.flush();
            System.out.println("\tWelcome to CRS App");
            System.out.println("\tPress 1:-Login");
            System.out.println("\tPress 2:-Registration for Student");
            System.out.println("\tPress 3:-Update Password");
            System.out.println("\tPress 4:-Exit");
            input = sc.nextInt();
            switch(input){
                case 1:
                while(!details){
                        System.out.flush();
                        System.out.println("\tEnter Username");
                        userName = sc.next();
                        System.out.println("\tEnter Password");
                        password = sc.nextLine();
                        System.out.println("\t Enter Role");
                        Role = sc.next();

                        //Authenticate

                    Menu menu = menus.get(Role);
                    if(menu != null){
                        details = true;
                        //use menu
                    }else{
                        System.out.println("Enter Correct role");
                        break;
                    }
                }

                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                    exit = true;
                break;
                default:
                    System.out.println("\tWrong input try again");
            }
        }


        sc.close();
    }
}
