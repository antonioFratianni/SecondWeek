package jpa;


import org.apache.log4j.PropertyConfigurator;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPATest {

    private static final String log4jProperties = "C:\\Users\\frati\\Desktop\\gitRepo\\SecondWeek\\src\\main\\resources\\log4j.properties";
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    private Query query;

    public void init() {
        PropertyConfigurator.configure(log4jProperties);
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void createTransaction() {
        init();
        et = em.getTransaction();
        et.begin();

        Family family;
        Person person;

        // Read the existing entries
        query = em.createQuery("select m from Person m");
        System.out.println("query");
        // Persons should be empty
    }

    public void print() {
        int numberRows = query.getResultList().size();
    }

    public static void main(String[] args) {
        JPATest jpaTest = new JPATest();
        jpaTest.createTransaction();

    }
}
