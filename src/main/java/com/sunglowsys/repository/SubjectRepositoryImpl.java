package com.sunglowsys.repository;

import com.sunglowsys.domain.Subject;
import com.sunglowsys.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectRepositoryImpl.class);

    private  static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Subject save(Subject subject) {
        LOGGER.debug("saving: {}",subject);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(subject);
        session.getTransaction().commit();
        session.close();
        return subject;
    }

    @Override
    public Subject update(Subject subject, Long id) {
        LOGGER.debug("updating : {}",subject);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Subject subject1 = session.get(Subject.class,id);
        subject1.setSubjectName(subject.getSubjectName());
        session.update(subject1);
        session.getTransaction().commit();
        session.close();
        return subject1;
    }

    @Override
    public Subject findById(Long id) {
        LOGGER.debug("finding by id: {}",id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Subject subject = session.get(Subject.class,id);
        return subject;
    }

    @Override
    public List<Subject> findAll() {
        LOGGER.debug("finding all : {}");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Subject");
        List<Subject> subjectList = query.list();
        return subjectList;
    }

    @Override
    public void delete(Long id) {
        LOGGER.debug("deleting : {}",id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Subject subject = session.get(Subject.class,id);
        session.delete(subject);
        session.getTransaction().commit();
        session.close();
        System.out.println("deleting:"+subject);

    }
}
