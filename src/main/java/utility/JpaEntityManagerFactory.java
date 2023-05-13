package utility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaEntityManagerFactory {

    private static JpaEntityManagerFactory instance;
    private static final String PERSISTENCE_UNIT_NAME = "postgres";
    private static EntityManagerFactory emf;

    private JpaEntityManagerFactory(){
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static synchronized JpaEntityManagerFactory getInstance(){
        if(instance == null) {
            instance = new JpaEntityManagerFactory();
        }
        return instance;
    }

    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public void close(){emf.close();}
}