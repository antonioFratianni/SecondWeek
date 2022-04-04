package secondWeekEnd;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.*;

public class CRUD {

    private static SessionFactory sessionFactory;
    private Session session;

    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    public void create() {
        System.out.println("Running testCreate...");
        session.beginTransaction();

        List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();
        restaurantTables.add(new RestaurantTable(4));
        restaurantTables.add(new RestaurantTable(2));
        restaurantTables.add(new RestaurantTable(6));

        GregorianCalendar data1 = new GregorianCalendar(2021, Calendar.FEBRUARY,8);
        ReservationId reservationId = new ReservationId("rossi", data1);
        Reservation reservation = new Reservation(reservationId, 7, 1234567L);

//        Integer id = (Integer) session.save(restaurantTable);

        for(RestaurantTable restaurantTable : restaurantTables) {
            session.save(restaurantTable);
        }

        session.save(reservation);

        session.getTransaction().commit();

//        Assertions.assertTrue( id > 0);
    }

    public void Update() {
    }

    public void get() {
        session.beginTransaction();
        Query<RestaurantTable> query = session.createQuery("from RestaurantTable ", RestaurantTable.class);
        List<RestaurantTable> resultList = query.getResultList();
        System.out.println("Running testGet...");
    }

    public void List() {
    }

    public void Delete() {
    }

    public boolean reservationRequest(String surname, Date date, int capacity, String phoneNumber){

        return false;
    }

    public int tableAvailability(GregorianCalendar date, int capacity){
        Query<RestaurantTable> query = session.createQuery("from RestaurantTable where capacity >= :capacity", RestaurantTable.class).setParameter("capacity", capacity);
        List<RestaurantTable> resultList = query.getResultList();
        if (resultList.isEmpty()){
            return 0;
        }else return resultList.get(1).getNumber();
    }


    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }

    public static void main(String[] args) {
        GregorianCalendar data = new GregorianCalendar(2020, Calendar.FEBRUARY,8);

        setup();
        CRUD crud = new CRUD();
        crud.openSession();
        crud.create();
        crud.get();

        if (crud.tableAvailability(data,10) > 0){
            System.out.println("Il tavolo e disponibile");

        }else {
            System.out.println("Il tavolo non e disponibile");
        }
        crud.closeSession();
        tearDown();
    }
}

