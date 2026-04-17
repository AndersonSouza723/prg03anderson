package br.com.ifba.atividade07.logic;
import java.text.NumberFormat;
// NumberFormat para formatar uma string para o real na exibição
import java.util.Locale;
// Locale para pegar a localização do brasil ao formatar a string

public class PagamentoCartao implements Pagamento {
    private double valor;
    // taxa de 5%

    public PagamentoCartao(double valor) {
        this.valor = valor;
    }
    
    @Override
    public double calcularTotal() {
        return this.valor + (this.valor * 0.05);
    }

    @Override
    public String imprimirRecibo() {
        String reciboCartao = "<html>====== RECIBO DE PAGAMENTO ======<br>" +
                           "Método de pagamento: Cartão de crédito<br>" +
                           "Valor pagamento: R$ " + valor + "<br>" +
                           "<br>Com o pagamento em dinheiro, você receberá 5% de taxa nessa compra!!" + 
                           "<br>Valor total (com taxa aplicada): R$ " + this.calcularTotal() +
                           "<br>====== O mercado Swing agradece ======<html>";
        
        return reciboCartao;
    }
    
}
