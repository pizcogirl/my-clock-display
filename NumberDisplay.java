
/**
 * Representa las horas o minutos del reloj
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    // Valor de las horas/minutos
    public int value;
    // Limite de las horas/minutos
    public int limit;

    /**
     * Crea las horas/minutos. 
     */
    public NumberDisplay(int max)
    {
        // Pone el valor como 0
        value = 0;
        // Pone el limite como el maximo introducido
        limit = max;
    }

    /**
     * Fijar un momento determinado de tiempo en horas y minutos 
     * en formato 23h:59min
     */
    public void setValue(int newTime)
    {
        // Añadimos el valor que debe tomar, comprueba si es valido
        if (newTime <= limit && newTime >=0)
        {
            value = newTime;
        }
        else
        {
            System.out.println("Introduce una cantidad de horas entre 0 y " + limit);
        }
    }

    /**
     * Devolver una cadena de 2 caracteres con el valor del display
     */
    public String getDisplayValue()
    {
        //Formato de la cadena para que sea siempre dos caracteres
        String displayValue = String.format("%02d", value);
        //String currentTime = hours.value +":" + minutes.value;
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
       // Si llega a 60 minutos, suma 1 hora
       if (value >= limit)
       {
           value = value - limit;
        }
    }
}
