package ParamveerSingh_C0788065_a8;

import javax.swing.*;

public class CheckTemperature {
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Welcome to the program.\n" +
                "Here you can calculate feels like temperature \n" +
                "based upon the day, temperature and wind speed.");

        while(true) {
            String day;
            float temp, wind_speed;
            try {
                day = getDay();
                temp = getFloat("Enter the temperature in Celsius for " + day + ": ");
                wind_speed = getFloat("Enter the wind speed in kilometre/hour: ");
            } catch (NullPointerException e) {
                System.out.println("Exception occurred.");
                return;
            }
            Temperature temperature = new Temperature(day, temp, wind_speed);
        }
    }

    public static String getDay(){
        return JOptionPane.showInputDialog("Enter the day of the week: ").trim();
    }

    public static float getFloat(String prompt){
        float temperature = 0;
        try{
            temperature = Float.parseFloat(JOptionPane.showInputDialog(prompt).trim());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter the valid input.");
            getFloat(prompt);
        }
        return temperature;
    }
}
