package com.flipkart.restController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.UserInterface;
import com.flipkart.business.UserBusiness;
import com.flipkart.exceptions.IncorrectPasswordException;
import com.flipkart.exceptions.UserNotFoundException;


@Path("/user")
public class UserAPI {
    private final UserInterface userService = new UserBusiness();

    @POST
    @Path("/login/{username}/{password}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(
            @FormParam("username") @NotNull String username,
            @FormParam("password") @NotNull String password) {
        try {
            User user = userService.retrieve(username, password);

            return Response.status(200).entity("Login successful. Welcome " + user.getID()).build();
        } catch (UserNotFoundException e) {
            return Response.status(401).entity("User not found: " + e.getMessage()).build();
        } catch (IncorrectPasswordException e){
            return Response.status(401).entity(e.getMessage()).build();
        }
    }


    @POST
    @Path("/studentRegistration/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(
            @NotNull @PathParam("username") String username,
            @NotNull Student student) {
        try {
            userService.registerStudent(
                    username,
                    student.getName(),
                    student.getContact(),
                    student.getEmail(),
                    student.getPassword(),
                    student.getBranch());

            return Response.status(201).entity("Registration Successful for " + student.getName()).build();
        } catch(Exception ex) {
            return Response.status(500).entity("Something went wrong! Please try again. " + ex.getMessage()).build();
        }
    }

    @POST
    @Path("/updatePassword/{username}/{oldPassword}/{newPassword}")
    public Response updatePassword(
            @NotNull @PathParam("username") String username,
            @NotNull @PathParam("oldPassword") String oldPassword,
            @NotNull @PathParam("newPassword") String newPassword) {
        try {
            System.out.println(userService.changePassword(username, oldPassword, newPassword));
            return Response.status(201).entity("Password updated successfully! ").build();
        } catch(UserNotFoundException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}