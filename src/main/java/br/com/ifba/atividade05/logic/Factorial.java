package br.com.ifba.atividade05.logic;

public class Factorial {
    private long num;
    private long factorial;
    private String formula;
    
    public void setValue(long n) {
        this.num = n;
        long result = 1;
        String form = "";
        
        for (long i = this.num; i >= 1;i--) {
            result *= i;
            form += i == 1?  i + "" :  i + " x ";
        }
        
        this.factorial = result;
        this.formula = form;
    }
    
    public long getFactorial() {
      return this.factorial;
    }
    
    public String getFormula() {
       return this.formula;
    }
}
