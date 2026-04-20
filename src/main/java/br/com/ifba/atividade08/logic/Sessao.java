package br.com.ifba.atividade08.logic;

public class Sessao {
    private long id;
    private String token;
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Sessao{" + " id = " + id + "\n, token = " + token +
                "\n, usuario = " + usuario + '}';
    }
    
    
}
