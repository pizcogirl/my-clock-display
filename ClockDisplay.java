
/**
 * Reloj que muestra la hora que le damos, con la opción
 * de aumentarla minuto a minuto o devolverla
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Display para las horas
    private NumberDisplay hours;
    // Display para los minutos
    private NumberDisplay minutes;
    // Cadena de caracteres que contiene la hora y minutos
    private String currentTime;

    /**
     * Constructor del reloj. Inicia con un limite de 24h y de 60 minutos y
     * valores para la hora y minutos 00
     */
    public ClockDisplay()
    {
        // inicializa los valores en 0 y los limites en 24h/60min
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
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
        updateDisplay();
    }

    /**
     * Fijar un momento determinado de tiempo en horas y minutos 
     * en formato 24h:59min.
     */
    public void setTime(int newHour, int newMinute)
    {
        // Introduce la hora y los minutos
        hours.setValue (newHour);
        minutes.setValue (newMinute);
        updateDisplay();
    }

    /**
     * Hacer avanzar un minuto la hora del reloj
     */
    public void timeTick()
    {
        minutes.increment();

        if (minutes.getValue() == 0)
        {
            // Si se resetean los minutos, suma una hora
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Devolver una cadena de 5 caracteres con la hora y 
     * los minutos separados por dos puntos
     */
    public String getTime()
    {
        // Muestra el valor de las horas y minutos
        // currentTime = (hours.getDisplayValue() + ":" + minutes.getDisplayValue());
        return currentTime;
    }

    /**
     * Actualiza el atributo displayString
     */
    private void updateDisplay()
    {
        if (hours.getValue() > 11)
        {
            int changeHours;
            changeHours = hours.getValue() - 12;
            if (changeHours < 10)
            {
                currentTime = "0" + changeHours + ":" + minutes.getDisplayValue() + "PM";
            }
            else
            {
                currentTime = changeHours + ":" + minutes.getDisplayValue() + "PM";
            }
        }
        else 

            currentTime = (hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "AM");
    }
}
