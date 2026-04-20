package br.com.ifba.atividade08.logic;

import java.time.LocalDateTime;

public class LogAuditoria {
    private long id;
    private Usuario usuario;
    private String acao;
    private LocalDateTime dataHora;
    private String ip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setData(LocalDateTime data) {
        this.dataHora = data;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "LogAuditoria{" + "id = " + id +
               "\n, usuario = " + usuario +
               "\n, ação = " + acao + 
               "\n, Data = " + dataHora +
               "\n, ip = " + ip + '}';
    }
    
    
}
