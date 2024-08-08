package com.flipkart.client;

import java.util.Scanner;

public class CRSCient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Welcome to the CRS Application :-->");
            System.out.println();
            System.out.println("Press 1:-- Login");
            System.out.println("Press 2:-- Registration of the Student");
            System.out.println("Press 3:-- Update password");
            System.out.println("Press 4:-- Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginMenu(scanner);
                    break;
                case 2:
                    System.out.println("Registration of the Student");
                    break;
                case 3:
                    System.out.println("Update password");
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the CRS Application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void loginMenu(Scanner scanner) {
        scanner.nextLine();
        System.out.println();
        System.out.println("Login Menu");
        System.out.println();
        System.out.print("Enter the UserName: ");
        String username = scanner.nextLine();
        System.out.print("Enter the Password: ");
        String password = scanner.nextLine();
        System.out.print("Role (Student/Professor/Admin): ");
        String role = scanner.nextLine();
        System.out.println();
        switch (role.toLowerCase()) {
            case "student":
                System.out.println("Student Menu");

                break;
            case "professor":
                System.out.println("Professor Menu");

                break;
            case "admin":
                System.out.println("Admin Menu");
                break;
            default:
                System.out.println("Invalid role. Please choose either Student, Professor, or Admin.");
        }
        System.out.println();
    }
}
