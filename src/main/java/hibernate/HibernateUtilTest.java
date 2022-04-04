package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;
import utils.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HibernateUtilTest {
    private static SessionFactory sessionFactory;
    private Session session;

    public HibernateUtilTest() {
    }

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    @Order(1)
    public void testCreate() {
        System.out.println("Running testCreate...");

        session.beginTransaction();

        Product product = new Product("iPhone 10", 699);
        Integer id = (Integer) session.save(product);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    @Order(2)
    public void testGet() {
        System.out.println("Running testGet...");

        Integer id = 1;

        Product product = session.find(Product.class, id);

        assertEquals("iPhone 10", product.getName());
    }

    @Test
    @Order(3)
    public void testList() {
        System.out.println("Running testList...");

        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> resultList = query.getResultList();

        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    @Order(4)
    public void testUpdate() {
        System.out.println("Running testUpdate...");

        Integer id = 1;
        Product product = new Product(id, "iPhone 11", 999);

        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();

        Product updatedProduct = session.find(Product.class, id);

        assertEquals("iPhone 11", updatedProduct.getName());
    }

    @Test
    @Order(5)
    public void testDelete() {
        System.out.println("Running testDelete...");

        Integer id = 1;
        Product product = session.find(Product.class, id);

        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();

        Product deletedProduct = session.find(Product.class, id);

        Assertions.assertNull(deletedProduct);
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }
}
