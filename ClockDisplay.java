
/**
 * Reloj que muestra la hora que le damos, con la opción
 * de aumentarla minuto a minuto o devolverla
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Crea las horas
    private NumberDisplay hours;
    // Crea los minutos
    private NumberDisplay minutes;
    // Cadena de caracteres
    String currentTime;

    /**
     * Constructor del reloj. Inicia con un limite de 24h y de 60 minutos y
     * valores para la hora y minutos 00
     */
    public ClockDisplay()
    {
        // inicializa los valores en 0 y los limites en 24h/60min
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        currentTime = (hours.getDisplayValue() + ":" + minutes.getDisplayValue());
    }
    /**
     * Constructor del reloj con parametros para fijar la hora. Inicia con un limite
     * de 24h y 60 minutos
     */
    public ClockDisplay(int iniHours, int iniMinutes)
    {
        // inicializa los valores, limites fijados y hora y minutos que le demos
        hours = new NumberDisplay(24);
        hours.setValue(iniHours);
        minutes = new NumberDisplay (60);
        minutes.setValue(iniMinutes);
        currentTime = (hours.getDisplayValue() + ":" + minutes.getDisplayValue());
    }

    /**
     * Fijar un momento determinado de tiempo en horas y minutos 
     * en formato 23h:59min
     */
    public void setTime(int newHour, int newMinute)
    {
        // Introduce la hora y los minutos
        hours.setValue (newHour);
        minutes.setValue (newMinute);
    }

    /**
     * Hacer avanzar un minuto el tiempo fijado.
     */
    public void timeTick()
    {
        minutes.increment();

        if (minutes.value == 00)
        {
            // Si se resetean los minutos, suma una hora
            hours.increment();
        }

    }

    /**
     * Devolver una cadena de 5 caracteres consistente en la hora y 
     * los minutos separados por dos puntos
     */
    public String getTime()
    {
        // Muestra el valor de las horas y minutos
        String currentTime = (hours.getDisplayValue() + ":" + minutes.getDisplayValue());
        return currentTime;
    }
}
