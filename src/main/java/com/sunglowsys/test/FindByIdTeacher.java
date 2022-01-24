package com.sunglowsys.test;

import com.sunglowsys.repository.TeacherRepositoryImpl;

public class FindByIdTeacher {
    public static void main(String[] args) {
        System.out.println(new TeacherRepositoryImpl().findById(1L));
    }
}
