package lk.ijse.book.util;


import lk.ijse.book.Entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(Book.class);
        sessionFactory=configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null)?
                factoryConfiguration=new FactoryConfiguration():
                factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
