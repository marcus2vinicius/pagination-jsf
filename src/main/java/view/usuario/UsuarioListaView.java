package view.usuario;

import domain.Usuario;
import repository.InterfaceUsuarioRepositoty;
import repository.UsuarioRepositoryInDataBase;
import repository.UsuarioRepositoryInMemory;
import util.PaginationHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioListaView {
    private List<Usuario> usuarios;
    private PaginationHelper pagination;
    private InterfaceUsuarioRepositoty repositoty = new UsuarioRepositoryInDataBase();

    public UsuarioListaView(){
        int tamanhoPagina = 10;
        Long total = repositoty.count();
        pagination = new PaginationHelper(tamanhoPagina, total.intValue());
        usuarios = initLista();
    }

    public void proxima(){
        usuarios = repositoty.findPagination(pagination.nextPage(),pagination.getPageSize());
    }

    public void anterior(){
        usuarios = repositoty.findPagination(pagination.previousPage(),pagination.getPageSize());
    }

    private List<Usuario> initLista() {
        return usuarios = repositoty.findPagination(pagination.nextPage(),pagination.getPageSize());
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
