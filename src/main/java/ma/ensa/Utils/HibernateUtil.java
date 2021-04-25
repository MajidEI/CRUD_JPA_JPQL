package ma.ensa.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public static EntityManager getEm() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("GI4");
            em = emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em;
    }
}
