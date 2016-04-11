package repository;

import domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus on 10/04/16.
 */
public class UsuarioRepositoryInDataBase implements InterfaceUsuarioRepositoty{

    static {
        EntityManager em = PersistenceSingleton.getInstance();
        em.getTransaction().begin();
        for (int i = 0; i < 100; i++) {
            Usuario u = new Usuario();
            u.setEmail(i+"email@hotmail.com");
            u.setLogin(i+"login");
            u.setNome(i+"Nome");
            u.setSenha(i+"senha");
            em.persist(u);
        }
        em.getTransaction().commit();
        em.close();
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public Long count() {
        EntityManager em = PersistenceSingleton.getInstance();
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM Usuario u", Long.class);
        long count = query.getSingleResult();
        em.close();
        return count;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Usuario> findPagination(int page, int size) {
        EntityManager em = PersistenceSingleton.getInstance();
        TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u", Usuario.class);
        query.setMaxResults(size).setFirstResult(page*size);
        List usuarios = query.getResultList();
        em.close();
        return usuarios;
    }
}
