package com.bean;

import com.gestion.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManyToManyTest {
    public static void main(String[] args){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Marque m1 = new Marque();
        m1.setNom("Renault");

        session.save(m1);

        Voiture v1 = new Voiture();
        v1.setNom("Clio");
        v1.setMatricule("1-1245");
        v1.setMarque(m1);

        session.save(v1);

        Chauffeur c1 = new Chauffeur();
        c1.setNom("chauffeur");
        c1.getVoitures().add(v1);
        v1.getChauffeurs().add(c1);

        session.save(c1);

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }
}
