package br.com.ifba.atividade07.logic;

public class PagamentoDinheiro implements Pagamento {
    private double valor;
    // 10% de desconto
    
    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return this.valor - (this.valor * 0.10);
    }

    @Override
    public String imprimirRecibo() {
        String reciboDinheiro = "<html>====== RECIBO DE PAGAMENTO ======<br>" +
                           "Método de pagamento: Dinheiro<br>" +
                           "Valor pagamento: R$ " + valor +
                           "<br>Com o pagamento em dinheiro, você recebeu 10% de desconto nessa compra!!" + 
                           "<br>Valor total (com desconto aplicado): R$ " + this.calcularTotal() +
                           "<br>====== O mercado Swing agradece ====== <html>";
        
        return reciboDinheiro;
    }
    
}
