package com.flipkart.bean;

import java.util.List;

public class GradeCard{
    private int studentId;
    private int semester;
    private float cpi;
    private List<RegisteredCourses> registeredCourses;

    public float calculateCpi(){
        return 1.0f;
    }
}