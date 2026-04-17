package br.com.ifba.atividade07.logic;


public class PagamentoPix implements Pagamento {
    private double valor;
    //cashback de 2%
    
    public PagamentoPix(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return this.valor - (this.valor * 0.02);
    }
    
    public double calcularCashback() {
        return this.valor * 0.02;
    }

    @Override
    public String imprimirRecibo() {
        String reciboPix = "<html>====== RECIBO DE PAGAMENTO ======<br>" +
                           "Método de pagamento: Pix<br>" +
                           "Valor pagamento: R$ " + valor +
                           "<br>Com o pagamento no pix, você recebeu 2% de cashback nessa compra!!" + 
                           "<br>Valor do cashback: R$ " + String.format("%.2f", this.calcularCashback()) +
                           "====== Loga Swing agradece! ====== <html>";
        
        return reciboPix;
    }
}
