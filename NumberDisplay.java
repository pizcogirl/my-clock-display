
/**
 * Representa una pantalla con dos caracteres
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    // Valor almacenado
    private int value;
    // Limite del valor almacenado
    private int limit;

    /**
     * Crea el Display especificando un limite y con
     * un valor 0
     */
    public NumberDisplay(int max)
    {
        // Pone el valor como 0
        value = 0;
        // Pone el limite como el maximo introducido
        limit = max;
    }

    /**
     * Fija el valor del atributo valor a uno dado
     */
    public void setValue(int newValue)
    {
        // Añadimos el valor que debe tomar, comprueba si es valido
        if (newValue < limit && newValue >=0)
        {
            value = newValue;
        }
        else
        {
            System.out.println("Introduce una cantidad entre 0 y " + limit);
        }
    }

    /**
     * Devolver una cadena de 2 caracteres con el valor del display
     */
    public String getDisplayValue()
    {
        //Formato de la cadena para que sea siempre dos caracteres
        String displayValue = String.format("%02d", value);
        // Método alternativo:
        // String displayValue;
        // if (value < 10){
        //  displayValue = "o" + value;
        // }
        // else {
        //  displayValue = "" + value;
        // }
        return displayValue;
    }

    /**
     * Devuelve el valor del display como un entero
     */
    public int getValue()
    {
        //Devuelve el valor del display como entero
        return value;
    }
    
    /**
     * Hacer avanzar en uno el display. Si llega al limite, vuelve a 0
     */
    public void increment()
    {
       value = value + 1;
       // Si llega al limite, vuelve a 0
       if (value >= limit)
       {
           value = value - limit;
        }
    }
}
