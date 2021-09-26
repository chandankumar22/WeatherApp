package com.example.chandan.weatherappintermediate;

//import android.icu.text.SimpleDateFormat;
import android.os.Build;
//import android.support.annotation.RequiresApi;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chandan on 22-06-2017.
 */

public class FutureTempData implements Serializable{

    private String cityName,country,mainDesc,weatherDesc,iconId;
    private double pressure,rain;
    long date;
    private int minTemp,maxTemp,avgTemp,dayTemp,eveTemp,nightTemp,mornTemp,speed,degree,clouds,
            weather_id,humidity;


    public FutureTempData(String cityName, String country, String mainDesc, String weatherDesc, String iconId,
                          double pressure, long date, int minTemp, int maxTemp, int avgTemp, int dayTemp,
                          int eveTemp, int nightTemp, int mornTemp, int speed, int degree, int clouds,
                          int weather_id, int humidity,double rain)
    {
        this.cityName = cityName;
        this.country = country;
        this.mainDesc = mainDesc;
        this.weatherDesc = weatherDesc;
        this.iconId = iconId;
        this.pressure = pressure;
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.avgTemp = avgTemp;
        this.dayTemp = dayTemp;
        this.eveTemp = eveTemp;
        this.nightTemp = nightTemp;
        this.mornTemp = mornTemp;
        this.speed = speed;
        this.degree = degree;
        this.clouds = clouds;
        this.weather_id = weather_id;
        this.humidity = humidity;
        this.rain=rain;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public String getMainDesc() {
        return mainDesc;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public String getIconId() {
        return iconId;
    }

    public double getPressure() {
        return pressure;
    }

    public long getDate() {
        return date;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getAvgTemp() {
        return avgTemp;
    }

    public int getDayTemp() {
        return dayTemp;
    }

    public int getEveTemp() {
        return eveTemp;
    }

    public int getNightTemp() {
        return nightTemp;
    }

    public int getMornTemp() {
        return mornTemp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDegree() {
        return degree;
    }

    public int getClouds() {
        return clouds;
    }

    public int getWeather_id() {
        return weather_id;
    }

    public int getHumidity() {
        return humidity;
    }
    public double getRain(){return Double.valueOf(String.format("%.2f",rain));}

    //@RequiresApi(api = Build.VERSION_CODES.N)
    public static String convertToDate(long l)
    {
        Date d = new Date(l*1000);
        SimpleDateFormat date = new SimpleDateFormat("E dd/MM");
        return (date.format(d));
    }
   // @RequiresApi(api = Build.VERSION_CODES.N)
    public static String convertToTime(long l)
    {
        Date d = new Date(l*1000);
        SimpleDateFormat date = new SimpleDateFormat("hh:mm");
        return (date.format(d));
    }

}
