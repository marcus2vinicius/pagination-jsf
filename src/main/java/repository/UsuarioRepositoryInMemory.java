package repository;

import domain.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by marcus on 10/04/16.
 */
public class    UsuarioRepositoryInMemory implements InterfaceUsuarioRepositoty{
    private static List<Usuario> usuarios;

    static {
        usuarios = new ArrayList<Usuario>();
        for (int i = 0; i < 1000; i++) {
            Usuario u = new Usuario();
            int prefixo = i+1;
            u.setEmail(prefixo+"email@hotmail.com");
            u.setId(prefixo);
            u.setLogin(prefixo+"login");
            u.setNome(prefixo+"Nome");
            u.setSenha(prefixo+"senha");
            usuarios.add(u);
        }
    }

    @Override
    public Long count() {
        return new Long(usuarios.size());
    }

    @Override
    public List<Usuario> findPagination(int page, int size) {
        return usuarios.stream().skip(page*size).limit(size).collect(Collectors.toList());
    }
}
