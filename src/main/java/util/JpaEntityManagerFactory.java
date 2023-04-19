package util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaEntityManagerFactory {

    private static final String PERSISTENCE_UNIT_NAME = "postgres";
    private static EntityManagerFactory emFactory;

    public static EntityManager getEntityManager() {
        if (emFactory == null || !emFactory.isOpen()) {
            emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emFactory.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emFactory != null && emFactory.isOpen()) {
            emFactory.close();
        }
    }

}