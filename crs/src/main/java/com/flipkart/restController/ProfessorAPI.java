package com.flipkart.restController;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorBusiness;

@Path("/professor")
public class ProfessorAPI {
    @GET
    @Path("/welcome/{username}")
    public Response welcome(@PathParam("username") String username) {
        String message = "Welcome to CRS Application " + username + "\nLOGIN TIME: " + LocalDateTime.now();
        return Response.ok(message).build();
    }

    ProfessorInterface professorService = new ProfessorBusiness();

    /**
     * Endpoint for View available courses for professor
     *
     * @return 201, list of courses if user is logged in, else 500 in case of error
     */
    @GET
    @Path("/viewAvailableCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAvailableCourses() {
        try {
            return Response.ok(professorService.viewCourses()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Something went wrong").build();
        }
    }



    /**
     * Endpoint for Indicating courses
     *
     * @param courseID which is the courdse Id
     * @return 201, if course successfully selected by professor, else 500 in case of error
     */
    @PUT
    @Path("/selectCourse/{courseID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response selectCourse(@PathParam("courseID") String courseID, @NotNull Professor prof)
    {
        try {
            String courses=professorService.offerCourse(courseID, prof);
            return Response.status(201).entity("Course selected:\n"+courses).build();
        }
        catch(Exception e) {
            return Response.status(500).entity("Error : " + e.getMessage()).build();
        }

    }

    /**
     * Endpoint for View enrolled students in a course
     *
     * @param courseID which is the course Id
     * @return 201, list of students if user is logged in and teaches the given course, else 500 in case of error
     */
    @GET
    @Path("/viewEnrolledStudents/{courseID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledStudents(
            @NotNull
            @PathParam("courseID") String courseID, @NotNull Professor prof) {
        try {
            String enrolledStudents=professorService.getStudents(courseID,prof);
            return Response.ok(enrolledStudents).build();
        } catch (Exception e) {
            return Response.status(500).entity("Something went wrong Error: "+e.getMessage()).build();
        }
    }



    /**
     * Endpoint for Grading the student
     *
     * @param grade
     * @return 201, if grade successfully added, else 500 in case of error
     */
    @POST
    @Path("/gradeStudent/{grade}/{studentID}/{courseID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response gradeStudent(@NotNull @PathParam("grade") String grade, @NotNull @PathParam("studentID") String studentID, @NotNull @PathParam("studentID") String courseID, @NotNull Professor prof)
    {
        try {
            String enrolledStudents = professorService.giveGrade(courseID,studentID,grade,prof);

            return Response.status(500).entity("Student has been graded successfully.").build();
        }
        catch(Exception e) {
            return Response.status(500).entity("Error : " + e.getMessage()).build();
        }

    }

}