
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
    // Contiene el dia de la fecha
    private NumberDisplay day;
    // Contiene el mes de la fecha
    private NumberDisplay month;
    // Contiene el año de la fecha
    private NumberDisplay year;
    // Cadena para contener la fecha completa
    private String todayIs;

    /**
     * Constructor del reloj. Inicia con un limite de 24h y de 60 minutos y
     * valores para la hora y minutos 00
     */
    public ClockDisplay()
    {
        // inicializa los valores en 0 y los limites en 24h/60min
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        day = new NumberDisplay (31);
        month = new NumberDisplay (13);
        year = new NumberDisplay (99);
        updateDisplay();
        whatDay();
    }

    /**
     * Constructor del reloj con parametros para fijar la hora. Inicia con un limite
     * de 24h y 60 minutos. Introduce la fecha separa en dia, mese y año
     */
    public ClockDisplay(int iniHours, int iniMinutes, int iniDay, int iniMonth, int iniYear)
    {
        // inicializa los valores, limites fijados y hora y minutos que le demos
        hours = new NumberDisplay(24);
        hours.setValue(iniHours);
        minutes = new NumberDisplay (60);
        minutes.setValue(iniMinutes);
        updateDisplay();
        day = new NumberDisplay (31);
        month = new NumberDisplay (13);
        year = new NumberDisplay (99);
        updateDisplay();
        day.setValue(iniDay);
        month.setValue(iniMonth);
        year.setValue(iniYear);
        whatDay();
    }

    /**
     * Fijar un momento determinado de tiempo en horas y minutos 
     * en formato 24h:59min. Introduce la fecha separa en dia, mese y año
     */
    public void setTime(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        // Introduce la hora y los minutos
        hours.setValue (newHour);
        minutes.setValue (newMinute);
        updateDisplay();
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);
        whatDay();
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
            if (hours.getValue() == 00)
            {
                day.increment();
                
                if (day.getValue() == 00)
                {
                    day.increment();
                    month.increment();
                    
                    if (month.getValue() == 00)
                    {
                        month.increment();
                        year.increment();
                    }
                    
                }
            }
        }
        updateDisplay();
        whatDay();
    }

    /**
     * Devolver una cadena de 5 caracteres con la hora y 
     * los minutos separados por dos puntos
     */
    public String getTime()
    {
        // Muestra el valor de las horas y minutos
        // currentTime = (hours.getDisplayValue() + ":" + minutes.getDisplayValue());
        return currentTime + " " + todayIs;
    }

    /**
     * Actualiza el atributo displayString
     */
    // El metodo updateDisplay muestra las horas en formato AM/PM, conversión mediante IF
    private void updateDisplay()
    {
        String pm = "PM";
        String am = "AM";
        int tempHour = hours.getValue();
        if (tempHour == 00)
        {
            currentTime = "12" + ":" + minutes.getDisplayValue() + am;
        }
        else
        {
            if (tempHour > 12)
            {
                int changeHours;
                changeHours = tempHour - 12;
                currentTime = String.format("%02d", changeHours) + ":" + minutes.getDisplayValue() + pm;
            }
            else
            {
                if (tempHour == 12)
                {
                    currentTime = "12" + ":" + minutes.getDisplayValue() + pm;
                }
                else
                // Si la hora es menor que 12;
                {
                    currentTime = (String.format("%02d", tempHour) + ":" + minutes.getDisplayValue() + am);
                }

            }
        }
    }
    /**
     * Metodo para actualizar la fecha
     */
    private void whatDay()
    {
       todayIs = day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();
    }
}
