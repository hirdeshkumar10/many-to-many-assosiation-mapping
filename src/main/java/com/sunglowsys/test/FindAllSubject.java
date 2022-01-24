package com.sunglowsys.test;

import com.sunglowsys.repository.SubjectRepositoryImpl;

public class FindAllSubject {
    public static void main(String[] args) {
        System.out.println(new SubjectRepositoryImpl().findAll());
    }
}
