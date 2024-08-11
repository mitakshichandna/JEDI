package com.flipkart.client;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.dao.Database;
import com.flipkart.dao.UserDAOInterface;
import com.flipkart.utils.Courses;

import java.util.*;

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
                    RegisterMenu(scanner);
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
public static void RegisterMenu(Scanner scanner) {
    System.out.println("Enter id:");
    Integer id = scanner.nextInt();
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
    UserDAOInterface user=new UserDAOInterface();
    try{
        user.registerStudent(id, name, password);
        System.out.println("Student registered successfully.");
    }
    catch(Exception e){}
}
    private static void loginMenu(Scanner scanner) {
        scanner.nextLine();
        System.out.println();
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("Login Menu");
        System.out.println();
        System.out.print("Enter the UserName: ");
        String username = scanner.nextLine();
        System.out.print("Enter the Password: ");
        String password = scanner.nextLine();
        UserDAOInterface user=new UserDAOInterface();
        if(user.validateLogin(username, password)){
            System.out.print("Role (Student/Professor/Admin): ");
            String role = scanner.nextLine();
            System.out.println();
            int studentChoice;
            switch (role.toLowerCase()) {
                case "student":
                    studentMenu(scanner);
                    break;
                case "professor":
                    System.out.println("Professor Menu");
                    professorMenu(username,scanner);
                    break;
                case "admin":
                    adminMenu(scanner);
                    break;
                default:
                    System.out.println("Invalid role. Please choose either Student, Professor, or Admin.");
            }
            System.out.println();
        }
        else{
            System.out.println("Invalid username or password. Please try again.");
        }

    }

    private static void adminMenu(Scanner sc){

        // Expect 2nd argument as a User class generic with Admin present within
        AdminBusiness admin;
        admin = new AdminBusiness();

        int choice = 0;
        boolean exit = false;
        String studentName;
        String profName;
        String courseName;

        while(!exit){
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("Choose function");
            System.out.println("1.Approve Student Registration");
            System.out.println("2.Send Grade");
            System.out.println("3.Remove Course");
            System.out.println("4.Add Prof");
            System.out.println("5.Remove Prof");
            System.out.println("6.Send Payment Notification");
            System.out.println("7.Show Prof List");
            System.out.println("8.Show Student List");
            System.out.println("9.Show Course List");
            System.out.println("10.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student Name");
                    studentName = sc.nextLine();
                    System.out.println("Enter Course Name");
                    courseName = sc.next();
                    admin.approveStudentReg(studentName, courseName);
                break;
                case 2:
                    System.out.println("Enter Student Name");
                    studentName = sc.nextLine();
                    admin.generateReportCard(studentName);
                break;
                case 3:
                    System.out.println("Enter Course Name");
                    courseName = sc.next();
                    admin.removeCourse(courseName);
                break;
                case 4:
                    System.out.println("Enter Course Name");
                    courseName = sc.next();
                    System.out.println("Enter Prof Name");
                    profName = sc.nextLine();
                    admin.addProf(courseName, profName);
                break;
                case 5:
                    System.out.println("Enter Course Name");
                    courseName = sc.next();
                    System.out.println("Enter Prof Name");
                    profName = sc.nextLine();
                    admin.removeProf(courseName, profName);
                break;
                case 6:
                    System.out.println("Enter Student Name");
                    studentName = sc.nextLine();
                    admin.sendPaymentNotice(studentName);
                break;
                case 7:
                break;
                case 8:
                break;
                case 9:
                break;
                case 10:
                    exit = true;
                break;
                default:
                    System.out.println("Wrong input.");
                    // Will appear for the briefest of moments
                    break;
            }

        }
    }

    private static void studentMenu(Scanner scanner) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"dummy1","depart1"));
        Courses courses = new Courses(Database.getCourseId(), "CODE", true,students);
                        System.out.println("Student Menu");
                System.out.println();
                System.out.println("choose:");
                System.out.println("press 1-- register course");
                System.out.println("press 2-- add course");
                System.out.println("press 3-- drop course");
                System.out.println("press 4-- pay fee");
                System.out.println("press 5-- check grades");
                int studentChoice=scanner.nextInt();
                scanner.nextLine();
                switch (studentChoice) {
                    case 1:
                        StudentBusiness.registerCourse();
                        break;
                    case 2:
                        StudentBusiness.addCourse();
                        break;
                    case 3:
                        StudentBusiness.dropCourse();
                        break;
                    case 4:
                        StudentBusiness.payFee();
                        break;
                    case 5:
                        StudentBusiness.checkGrades();
                        break;
                }

    }

    private static void professorMenu(String username, Scanner scanner) {
        Professor professor = new Professor();
        professor.setName(username);
        professor.setDepartment("Science");
        professor.setId(Database.getUserId());

        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Aman","depart1"));
        students.add(new Student(2,"Akhil","depart2"));

        List<Courses> courses = new ArrayList<Courses>();
        courses.add(new Courses(Database.getCourseId(),"SB101",true,students));

        int choice;
        String courseName;
        String profName;
        int studentId;
        boolean exit = false;
        List<String> courseMap = new ArrayList<>();

        System.out.print("Enter Prof Name: ");
        profName = scanner.nextLine();
        professor.setId(Database.getUserId());

        ProfessorBusiness professorBusiness = new ProfessorBusiness();

        while(!exit) {

            System.out.println("Professor Menu");
            System.out.println("1.Available Courses");
            System.out.println("2.Calculate Grade");
            System.out.println("3.Course Removal");
            System.out.println("4.Courses under Professor");
            System.out.println("5.Select Course");
            System.out.println("5.Exit");


            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Available courses: ");
                    professorBusiness.accessAvailableCourses(courses);
                    break;
                case 2:
                    System.out.println("Calculating Grade: ");
                    System.out.println("Enter student Id");
                    studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter course Name");
                    courseName = scanner.nextLine();
                    Grade grade = new Grade();
                    grade.setGrade("A");
                    ProfessorBusiness.viewGrades(grade);
                    break;
                case 3:
                    System.out.println("Removing Course...");
                    System.out.println("Enter course name");
                    courseName = scanner.nextLine();
                    ProfessorBusiness.removeCourse(courseName,professor);
                    break;
                case 4:
                    System.out.println("Courses under Professor: ");
                    professorBusiness.viewCoursesUnderProfessor(professor);
                    break;
                case 5:
                    System.out.println("Enter course name");
                    courseName = scanner.nextLine();
                    int id = -1;
                    for(Courses c:Database.courseMap.values()){
                        if(courseName.equals(c.getName())){
                            id = c.getId();
                            break;
                        }
                    }
                    if(id != -1){
                        professor.addCourse(id);
                    }else{
                        System.out.println("Course does not exist");
                    } 
                    break;
                case 6:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
