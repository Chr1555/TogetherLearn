package util;

import java.util.ArrayList;
import model.Questions;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataAkses {

    public static SessionFactory factory;

    public DataAkses() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("[ERROR] Gagal membuat session factory");
            e.printStackTrace();
        }
    }

    public Users login(String email, String password) {
        Session session = factory.openSession();
        Users hasil = null;
        Transaction tx = session.beginTransaction();

        Query q = session.createQuery("from Users u where u.email = :em and u.password = :pwd");
        q.setParameter("em", email);
        q.setParameter("pwd", password);
        hasil = (Users) q.uniqueResult();

        tx.commit();
        session.close();

        return hasil;
    }

    public boolean register(Users u) {
        boolean res = true;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(u);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        session.close();
        return res;
    }

    public ArrayList<Questions> getAllQuestions() {
        Session session = factory.openSession();
        ArrayList<Questions> hasil = null;
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Questions");
        hasil = (ArrayList<Questions>) q.list();
        tx.commit();
        session.close();
        return hasil;
    }
    
    public Users getUser(String email){
        Session session = factory.openSession();
        Users u = null;
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Users u where u.email = :em");
        q.setParameter("em", email);
        u = (Users) q.uniqueResult();
        tx.commit();
        session.close();
        
        return u;
    }
    
    public boolean newQuestion(Questions q){
        boolean res = true;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(q);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        session.close();
        return res;
    }
}
