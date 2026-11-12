package Conversor;
import javax.swing.JOptionPane;

public class Main {

    // Convierte el texto ingresado a número; acepta decimales con punto o coma.
    // Lanza NullPointerException si se canceló el cuadro (entrada null) y
    // NumberFormatException si el texto no es un número.
    public static double parsearMonto(String entrada) {
        if (entrada == null) {
            throw new NullPointerException("La entrada no puede ser null");
        }
        String normalizado = entrada.trim().replace(',', '.');
        if (normalizado.isEmpty()) {
            throw new NumberFormatException("Cadena vacía");
        }
        return Double.parseDouble(normalizado);
    }

    public static void main(String[] args) {
        ConversorTemperatura FuncTemp = new ConversorTemperatura();
        ConversorMoneda FuncMon = new ConversorMoneda();
        while (true){
            String opciones = (String)(JOptionPane.showInputDialog(null, 
                    "Seleccione una opción de conversión ", "Menu", JOptionPane.QUESTION_MESSAGE, 
                    null, new Object[] {"Conversor de Moneda", "Conversor de Temperatura"}, "Seleccion"));
            if(opciones == null){
                System.exit(0);
            }
           if("Conversor de Moneda".equals(opciones)){
               while (true){

                    try{
                         double moneda = parsearMonto(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desea convertir: "));
                         String opcion1 = (String)(JOptionPane.showInputDialog(null, 
                              "Seleccione una opción de conversión ", "Menu", JOptionPane.QUESTION_MESSAGE, 
                              null, new Object[] {"Peso a Dolar", "Peso a Euro", "Peso a Libras", "Peso a Yen", "Peso a Won Coreano", "Dolar a Pesos", "Euro a Pesos", "Libras a Pesos", "Yen a Pesos", "Won Coreano a Pesos"}, "Seleccion")); 
                         if(null == opcion1){
                             System. exit(0);

                         }
                         else switch (opcion1) {
                              case "Peso a Dolar", "Dolar a Pesos" -> {
                                  JOptionPane.showMessageDialog(null, "El valor seria de: " + FuncMon.dolar(moneda, opcion1));
                             }
                              case "Peso a Euro", "Euro a Pesos" -> {
                                  JOptionPane.showMessageDialog(null, "El valor seria de: " + FuncMon.euro(moneda, opcion1));
                             }
                              case "Peso a Libras", "Libras a Pesos" -> {
                                  JOptionPane.showMessageDialog(null, "El valor seria de: " + FuncMon.libras(moneda, opcion1));
                             }
                              case "Peso a Yen", "Yen a Pesos" -> {
                                 JOptionPane.showMessageDialog(null, "El valor seria de: " + FuncMon.yen(moneda, opcion1));
                             }
                              default ->{
                                  JOptionPane.showMessageDialog(null, "El valor seria: " + FuncMon.wonCoreano(moneda, opcion1));
                              }
                          }
                         
                        String [] botones = { " Yes", "No", "Cancel" };
                        int option = JOptionPane.showOptionDialog(null, "Desea continuar?", "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
  
                        if(option == 1){
                            JOptionPane.showMessageDialog(null, "El programa ha finalizado!");
                            System.exit(0);
                        }
                        if(option == 2){
                            break;
                        }
                        if(option < 0){
                            System.exit(0);
                        }
                    }catch(NumberFormatException | NullPointerException e){
                        if (e instanceof NullPointerException) {
                            System.exit(0); // se canceló el cuadro de entrada
                        }
                        JOptionPane.showMessageDialog(null, "Valor no válido. Ingrese un número (se aceptan decimales con punto o coma).");
                    }
               }
           }
           else{
               while (true){

                    try{
                         double temperatura = parsearMonto(JOptionPane.showInputDialog("Ingrese la temperatura: "));
                         String opcion1 = (String)(JOptionPane.showInputDialog(null, 
                              "Seleccione una opción de conversión ", "Menu", JOptionPane.QUESTION_MESSAGE, 
                              null, new Object[] {"Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Celsius", "Fahrenheit a Kelvin", "Kelvin a Celsius", "Kelvin a Fahrenheit"}, "Seleccion")); 
                         if(null == opcion1){
                             System. exit(0);

                         }
                         else switch (opcion1) {
                              case "Celsius a Fahrenheit", "Celsius a Kelvin" -> {
                                  JOptionPane.showMessageDialog(null, "La conversion seria: " + FuncTemp.Celsius(temperatura, opcion1));
                             }
                              case "Fahrenheit a Celsius", "Fahrenheit a Kelvin" -> {
                                  JOptionPane.showMessageDialog(null, "La conversion seria: " + FuncTemp.Fahrenheit(temperatura, opcion1));
                             }
                              case "Kelvin a Celsius", "Kelvin a Fahrenheit" -> {
                                  JOptionPane.showMessageDialog(null, "La conversion seria: " + FuncTemp.Kelvin(temperatura, opcion1));
                             }
                          }
                         
                        String [] botones = { " Yes", "No", "Cancel" };
                        int option = JOptionPane.showOptionDialog(null, "Desea continuar?", "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
  
                        if(option == 1){
                            JOptionPane.showMessageDialog(null, "El programa ha finalizado!");
                            System.exit(0);
                        }
                        if(option == 2){
                            break;
                        }
                        if(option < 0){
                            System.exit(0);
                        }
                    }catch(NumberFormatException | NullPointerException e){
                        if (e instanceof NullPointerException) {
                            System.exit(0); // se canceló el cuadro de entrada
                        }
                        JOptionPane.showMessageDialog(null, "Valor no válido. Ingrese un número (se aceptan decimales con punto o coma).");
                    }
               }
           }


        }
        
//cierre del while
   }
    
}
