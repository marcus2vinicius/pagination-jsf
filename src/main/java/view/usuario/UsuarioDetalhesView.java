package view.usuario;

import domain.Usuario;

import javax.faces.bean.*;

@ManagedBean
@ViewScoped
public class UsuarioDetalhesView {
    private Usuario usuario;

    @ManagedProperty(value = "#{usuarioListaView}")
    private UsuarioListaView usuarioListaView;
    private boolean render_Table2;



    public UsuarioDetalhesView() {
        this.usuario = new Usuario();
        render_Table2 = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void actionSalvar(){
        usuarioListaView.addUsuario(usuario);
        System.out.println(usuario);
    }


    public UsuarioListaView getUsuarioListaView() {
        return usuarioListaView;
    }

    public void setUsuarioListaView(UsuarioListaView usuarioListaView) {
        this.usuarioListaView = usuarioListaView;
    }

    public boolean isRender_Table2() {
        return render_Table2;
    }

    public void setRender_Table2(boolean render_Table2) {
        this.render_Table2 = render_Table2;
    }
}
