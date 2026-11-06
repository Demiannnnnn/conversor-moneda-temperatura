
package Conversor;

public class ConversorTemperatura {
    
    public double Celsius(double valor, String opcion){
        if("Celsius a Fahrenheit".equals(opcion)){
            return ((valor*(9.0/5))+32) ;
        }
        else{
            return (valor+273.15);
        }
        
    }
    
    
    public double Fahrenheit(double valor, String opcion){
        if("Fahrenheit a Celsius".equals(opcion)){
            return ((valor-32)*(5.0/9));
        }
        else{
            return (((valor-32)*(5.0/9))+273.15);
        }
    }
    
    public double Kelvin(double valor, String opcion){
        if("Kelvin a Celsius".equals(opcion)){
            return (valor-273.15);
        }
        else{
            return (((valor-273.15)*(9.0/5))+32);
        }
    }

    
}
