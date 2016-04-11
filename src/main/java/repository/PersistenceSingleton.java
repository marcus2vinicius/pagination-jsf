package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

/**
 * Created by Marcus on 06/02/2016.
 */
public class PersistenceSingleton {
    private static EntityManagerFactory emf = null;

    public static EntityManager getInstance(){
        if(emf != null && emf.isOpen())
            return emf.createEntityManager();
        else
            emf = Persistence.createEntityManagerFactory("appLocal");
        return emf.createEntityManager();
    }


}
