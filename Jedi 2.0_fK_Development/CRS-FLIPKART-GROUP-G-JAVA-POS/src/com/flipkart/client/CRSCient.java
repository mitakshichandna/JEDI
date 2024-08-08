package com.flipkart.client;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.Student;
import com.flipkart.utils.Courses;

import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
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

    private static void adminMenu(Scanner sc){

        // Expect 2nd argument as a User class generic with Admin present within
        AdminBusiness admin;
        admin = new AdminBusiness();

        int choice = 0;
        boolean exit = false;
        int studentId;
        int profId;
        int courseId;

        while(!exit){
            System.out.flush();
            System.out.println("Choose function");
            System.out.println("1.Approve Student Registration");
            System.out.println("2.Send Grade");
            System.out.println("3.Remove Course");
            System.out.println("4.Add Prof");
            System.out.println("5.Remove Prof");
            System.out.println("6.Send Payment Notification");
            System.out.println("7.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID");
                    studentId = sc.nextInt();
                    System.out.println("Enter Course ID");
                    courseId = sc.nextInt();
                    admin.approveStudentReg(studentId, courseId);
                break;
                case 2:
                    System.out.println("Enter Student ID");
                    studentId = sc.nextInt();
                    admin.generateReportCard(studentId);
                break;
                case 3:
                    System.out.println("Enter Course ID");
                    courseId = sc.nextInt();
                    admin.removeCourse(admin.getCourse(courseId));
                break;
                case 4:
                    System.out.println("Enter Course ID");
                    courseId = sc.nextInt();
                    System.out.println("Enter Prof ID");
                    profId = sc.nextInt();
                    admin.addProf(courseId, profId);
                break;
                case 5:
                    System.out.println("Enter Course ID");
                    courseId = sc.nextInt();
                    System.out.println("Enter Prof ID");
                    profId = sc.nextInt();
                    admin.removeProf(courseId, profId);
                break;
                case 6:
                    System.out.println("Enter Student ID");
                    studentId = sc.nextInt();
                    admin.sendPaymentNotice(studentId);
                break;
                case 7:
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
        Courses courses = new Courses("CODE", true,123,students);
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
                        Student.registerCourse(courses);
                    case 2:
                        Student.addCourse(courses);
                    case 3:
                        Student.dropCourse(courses);
                    case 4:
                        Student.payFee(courses);
                    case 5:
                        Student.checkGrades();
                }

    }

    private static void professorMenu(String username, Scanner scanner) {
        Professor professor = new Professor();
        professor.setName(username);
        professor.setDepartment("Science");
        professor.setProfessorId(101);

        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Aman","depart1"));
        students.add(new Student(2,"Akhil","depart2"));

        List<Courses> courses = new ArrayList<Courses>();
        courses.add(new Courses("SB101",true,2500,students));

        int choice;
        int courseId;
        int profId;
        int studentId;
        boolean exit = false;

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
                    System.out.println("Enter course Id");
                    studentId = scanner.nextInt();
                    courseId = scanner.nextInt();
                    Grade grade = new Grade();
                    grade.setGrade("A");
                    ProfessorBusiness.viewGrades(grade);
                    break;
                case 3:
                    System.out.println("Removing Course...");
                    System.out.println("Enter course Id");
                    courseId = scanner.nextInt();
                    ProfessorBusiness.removeCourse(courseId,courses);
                    break;
                case 4:
                    System.out.println("Courses under Professor: ");
                    System.out.println("Enter course Id");
                    profId = scanner.nextInt();
                    professorBusiness.viewCoursesUnderProfessor(professor);
                    break;
                case 5:
                    System.out.println("Enter course name");
                    String courseName = scanner.nextLine();
                    Map<Integer,String> courseMap = new HashMap<Integer,String>();
                    courseMap.put(professor.getProfessorId(),courseName);
                    professor.setCourseMap(courseMap);
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
