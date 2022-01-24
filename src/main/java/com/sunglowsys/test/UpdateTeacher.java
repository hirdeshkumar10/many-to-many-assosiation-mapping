package com.sunglowsys.test;

import com.sunglowsys.domain.Teacher;
import com.sunglowsys.repository.TeacherRepositoryImpl;

public class UpdateTeacher {
    public static void main(String[] args) {
        Teacher teacher =  new Teacher();
        teacher.setFirstName("Tejveer");
        new TeacherRepositoryImpl().update(teacher,1L);
        System.out.println(teacher);
    }
}
