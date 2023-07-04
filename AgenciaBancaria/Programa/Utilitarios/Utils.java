package AgenciaBancaria.Programa.Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    
    static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");

    // tranformar de double para String retornar o valor 
    public static String doubleToString(Double valor){
        return formatandoValores.format(valor); 
    }
}
