package br.com.ifba.atividade03.logic;
import java.time.LocalDate;

public class AgeCalculator {
    // Method belongs to that class
    public static int calculateAge(int birthYear) {
        LocalDate actualDate = LocalDate.now();
        
        int actualYear = actualDate.getYear();
        return actualYear - birthYear;        
    }
}
