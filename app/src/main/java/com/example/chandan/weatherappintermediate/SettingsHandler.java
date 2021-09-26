package com.example.chandan.weatherappintermediate;

import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by chandan on 27-06-2017.
 */

public class SettingsHandler {

    public int toCelsius(double celsius) {
        return (int) celsius;
    }

    public int toFahrenheit(double celsius) {
        return (int) ((celsius * 9) / 5) + 32;
    }

    public int toKelvin(double celsius) {
        return (int) (celsius + 273.15);
    }
    public double toPascal(double hPa)
    {
        return hPa*100;
    }
    public double toAtm(double hPa){
        return (Double.valueOf(String.format(Locale.getDefault(),"%.2f",(hPa/1013.25))));
    }
    public double toMmOfHg(double hPa){
        return (Double.valueOf(String.format(Locale.getDefault(),"%.2f",(hPa/1.33))));
    }
    public double toKmph(double mps){
        return (Double.valueOf(String.format(Locale.getDefault(),"%.2f",(mps*3.6))));
    }
    public double toMph(double mps){
        return (Double.valueOf(String.format(Locale.getDefault(),"%.2f",(mps*2.23))));
    }


}
