package jpa;

//import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager;
//import org.apache.log4j.PropertyConfigurator;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class JPATest {

    private  EntityManagerFactory emf;
    private EntityManager em;

    public void init(){
//        PropertyConfigurator.configure();//log4jcose
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void createTransaction(){
        this.init();
        em.getTransaction();
        Query q = em.createQuery("select m from Person m");
    }
}
