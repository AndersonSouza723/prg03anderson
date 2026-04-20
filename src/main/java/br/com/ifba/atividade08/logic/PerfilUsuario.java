package br.com.ifba.atividade08.logic;

import java.util.ArrayList;
import java.util.List;

public class PerfilUsuario {
    private long id;
    private String descricao;
    private List<String> permissoes = new ArrayList<>();   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }
    
    public void adicionarPermissao(String permissao) {
        this.permissoes.add(permissao);
    }
    
    @Override
    public String toString() {
        return "PerfilUsuario {" +
                "\nid = " + this.id +
                "\n, descricao = '" + this.descricao + '\'' +
                "\n, permissoes = " + this.permissoes +
                '}';
    }
}
