package br.com.ifba.atividade06.logic;
import java.text.NumberFormat;
// NumberFormat para formatar uma string para o real na exibição
import java.util.Locale;
// Locale para pegar a localização do brasil ao formatar a string

public class ContaBancaria {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    private String saldoFormatado;

    ContaBancaria() {
        this.setSaldo(0);
        this.status = false;
    }
    
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!"cc".equals(tipo) && !"cp".equals(tipo)) {
            System.out.println("Os únicos tipos de conta permitidas são \"cc\""
                    + "Para conta corrente e \"cp\" Para conta poupança");
            return;
        }
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double valor) {
        this.saldo += valor;
        this.setSaldoFormatado(this.saldo);
        // Método privado pois o cliente deve usar o saldo através de deposito e saque
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void abrirConta(String tipoConta) {
        this.status = true;
        this.setSaldo("cc".equals(tipoConta)? 50 : 150);
    }
    
    public boolean fecharConta() {
        if (saldo != 0) {
            System.out.println("O saldo da conta precisa ser zerado para fechar a conta.");
            System.out.println("Saldo atual -> " + this.saldoFormatado);
            return false;
        }
        
        this.status = false;
        System.out.println("A conta foi fechada com sucesso!");
        return true;
    }
    
    private void setSaldoFormatado(double novoValor) {
        Locale brasil = new Locale("pt", "BR");
            
        NumberFormat formatBRL = NumberFormat.getCurrencyInstance(brasil);
        this.saldoFormatado = formatBRL.format(novoValor);
    }
    
    public String getSaldoFormatado() {
        // retorna a string de exibição do valor, não deve ser usada em cálculos
        return this.saldoFormatado;
    }
    
    public boolean depositar(double valor) {
        if (!status) {
            System.out.println("Esta conta está fechada! Não é possível efetuar depósitos");
            return false;
        }
        
        this.setSaldo(valor);
        System.out.println("Operação efetuada com sucesso!");        
        return true;
    }
    
    public boolean sacar(double saque) {
        if (!status) {
            System.out.println("Esta conta está fechada! Não é possível efetuar depósitos");
            return false;
        }
        if (this.saldo <= 0) {
            System.out.println("Não é possível efetuar saque em conta negativada.");
            return false;
        }
        if ((this.saldo - saque) < 0) {
            System.out.println("Seu saldo ficará negativo com este saque. Operação negada!");
            return false;
        }
        
        this.setSaldo(saque - (saque * 2));
        System.out.println("Saque efetuado com sucesso!");
        return true;    
    }
    
    public void pagarMensalidade() {
        this.setSaldo(this.tipo.equals("cc")? -12 : -20);
    }
}
