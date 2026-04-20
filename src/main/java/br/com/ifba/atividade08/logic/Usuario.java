package br.com.ifba.atividade08.logic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Usuario {
    private int id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private boolean ativo;     
    private List<LogAuditoria> logs = new ArrayList<>();
    private List<Sessao> sessoes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }  

    public List<LogAuditoria> getLogs() {
        return logs;
    }

    public void setLogs(List<LogAuditoria> logs) {
        this.logs = logs;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{Perfil do usuário = " + this.perfil +
                "\nNome do usuário = " + this.nomeUsuario +
                "\nEmail = " + this.email +
                "\nÚltimo login = " + this.ultimoLogin +
                "\nEstado do usuário = " + (this.ativo? "Ativo" : "Inativo") + "}"; 
    }
    
    private void registrarLog(String acao, String ip) {
        LogAuditoria log = new LogAuditoria();
        
        log.setAcao(acao);
        log.setIp(ip);
        log.setData(LocalDateTime.now());
        log.setUsuario(this); // Apenas "this" representa a instância do objeto
        this.logs.add(log);
        this.ultimoLogin = LocalDateTime.now();
    }
    
    public void criarSessao(Usuario user) {
        Sessao sessao = new Sessao();
        
        sessao.setUsuario(user);
        String tokenGerado = UUID.randomUUID().toString();
        sessao.setToken(tokenGerado);
        sessao.setId((long)(Math.random() * (10000 - 1 + 1)) + 1); // gera um id entre 1 e 10.000
        
        this.sessoes.add(sessao);
    }
    
    public void fazerLogin(String senhaRecebida) {
        String ipFicticio = "123.45.678.9";
        if (!this.ativo) {
            System.out.println("O usuário \"" + this.nomeUsuario + "\" Não possui conta ativa");
            return;
        }
        
        if (!senhaRecebida.equals(this.senha)) {
            System.out.println("Senha incorreta!");
            this.registrarLog("Senha incorreta na tentiva de login", ipFicticio);
            return;
        }
        
        this.registrarLog("Login realizado com sucesso", ipFicticio);        
    }
}
