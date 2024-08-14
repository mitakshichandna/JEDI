package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDao;
import com.flipkart.exceptions.BillingNotFoundException;
import com.flipkart.exceptions.CourseAlreadyOptedException;
import com.flipkart.exceptions.CourseNotAvailableException;
import com.flipkart.exceptions.CourseNotFoundException;

import java.util.List;
import java.util.Set;

public class StudentBusiness implements StudentInterface {
	StudentDaoInterface sdi=new StudentDao();
    /**
     * Method to register the student in a course
     * @param courses: the course to register
     * @return true if registration was successful, false otherwise
     */
	public String register(Student student, List<String> courses) {
		String confirmedRegistration="";
		int count=0;
		float price=0;
		for(String courseID:courses) {
			if(count==4)break;
			float temp=0;
			try {
				temp = sdi.register(student, courseID);
			} catch (CourseAlreadyOptedException | CourseNotFoundException | CourseNotAvailableException e) {
				System.out.println(e.getMessage());
			}
            count++;
			confirmedRegistration=confirmedRegistration.concat(courseID+"\n");
			price+=temp;
			
		}
		return confirmedRegistration.concat("price: " + String.valueOf(price));
	}
    
    /**
     * Method to view courses registered by the student
     * @return list of registered courses
     */
	
    public String viewCoursesEnrolled(Student student) {
        //return student.courseList();
    	StringBuilder courses = new StringBuilder();
	    List<Course> courseList = sdi.viewCoursesEnrolled(student);
	    
	    courseList.forEach(course -> 
	        courses.append(course.getCourseID()).append("\t")
	               .append(course.getCourseName()).append("\t")
	               .append(course.getCourseProf()).append("\n")
	    );

	    return courses.toString();
    }
    
    /**
     * Method to get a report of registered courses
     * @return a string report of registered courses
     */
    public String getReport(Student student) {
        //return student.getReport();
    	StringBuilder report = new StringBuilder();
        ReportCard reportCard = sdi.getReport(student);
        
        reportCard.getGrades().forEach((key, value) -> 
            report.append(key).append(":").append(value).append("\n")
        );

        return report.toString();
    }
    
    /**
     * Method to get billing information
     * @return billing information
     */
    public String getBillingInfo(Student student) {
        //return student.getBilling().infoAboutPay();
    	Billing billing;
		try {
			billing = sdi.getBillingInfo(student);
	    	String status="Pending";
	    	if(billing.isStatus())status="Completed";
	    	return billing.getBillingID()+"\t"+billing.getBillamt()+"\t"+status;
		} catch (BillingNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
    }

	@Override
	public int getValidCount(List<String> courses) {
		return 0;
	}

	@Override
	public String viewCourses() {
		StringBuilder catalog = new StringBuilder();
	    Set<Course> courses = sdi.viewCourses();
	    
	    courses.forEach(course -> {
	        String prof = course.getCourseProf();
	        if (prof == null) prof = "Prof Awaited";
	        catalog.append(course.getCourseID()).append("\t")
	               .append(course.getCourseName()).append("\t\t")
	               .append(prof).append("\t\t")
	               .append(course.getSeats()).append("\n");
	    });

	    return catalog.toString();
	}
	
	@Override
	public String makePayment(Student student, float amount, String transactionID) {
	    // Retrieve billing information using the Student object
	    Billing billing;
		try {
			billing = sdi.getBillingInfo(student);
			if (billing.isStatus()) {
		        return "Payment already completed for billing ID: " + billing.getBillingID();
		    }

		    // Generate a unique transaction ID
		    billing.setTransactionID(transactionID);
		    billing.setBillamt(amount);

		    // Update billing information in the database
		    boolean paymentSuccess = sdi.updateBillingInfo(billing);
		    
		    if (paymentSuccess) {
		        return "Payment Successful. Transaction ID: " + transactionID;
		    } else {
		        return "Payment failed. Please try again.";
		    }
		} catch (BillingNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;

	    
	}

	@Override
	public float getCoursePricing(Student student) {
		float price=0;
    	List<Course> courseList=sdi.viewCoursesEnrolled(student);
    	for(Course course:courseList) {
    		price+=course.getPrice();
    	}
    	return price;
	}
}


