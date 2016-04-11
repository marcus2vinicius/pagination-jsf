package repository;

import domain.Usuario;

import java.util.List;

/**
 * Created by marcus on 10/04/16.
 */
public interface InterfaceUsuarioRepositoty {
    public Long count();
    public List<Usuario> findPagination(int page, int size);
}
