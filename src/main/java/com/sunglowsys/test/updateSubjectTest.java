package com.sunglowsys.test;

import com.sunglowsys.domain.Subject;
import com.sunglowsys.repository.SubjectRepositoryImpl;

public class updateSubjectTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.setSubjectName("Drowing");
        new SubjectRepositoryImpl().update(subject,1L);
    }
}
