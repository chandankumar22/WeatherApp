package com.example.chandan.weatherappintermediate;

//import android.icu.text.SimpleDateFormat;
//import android.icu.util.TimeZone;

import android.os.Build;

import java.text.SimpleDateFormat;
//import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Created by chandan on 22-06-2017.
 */

public class TempData {

    private String cityName, country, mainDesc, weatherDesc, iconId;
    private double lat, lon, pressure, speed, rain;
    long date;
    int cnt;
    private int minTemp, maxTemp, avgTemp, dayTemp, eveTemp, nightTemp, mornTemp, degree, clouds,
            weather_id, humidity;


    public TempData(String cityName, String country, String mainDesc, String weatherDesc, String iconId,
                    double lat, double lon, double pressure, long date, int minTemp, int maxTemp,
                    int avgTemp, int dayTemp, int eveTemp, int nightTemp,
                    int mornTemp, double speed, int degree, int clouds, int weather_id, int
                            humidity, double rain, int cnt) {
        this.cityName = cityName;
        this.country = country;
        this.mainDesc = mainDesc;
        this.weatherDesc = weatherDesc;
        this.iconId = iconId;
        this.lat = lat;
        this.lon = lon;
        this.pressure = pressure;
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        Log.d("insidetempdatacons", "assingingvaluetoavgtempas " + avgTemp);
        this.avgTemp = avgTemp;
        Log.d("insidetempdatacons", "assingedas " + this.avgTemp);
        this.dayTemp = dayTemp;
        this.eveTemp = eveTemp;
        this.nightTemp = nightTemp;
        this.mornTemp = mornTemp;
        this.speed = speed;
        this.degree = degree;
        this.clouds = clouds;
        this.weather_id = weather_id;
        this.humidity = humidity;
        this.rain = rain;
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }

    public TempData() {

    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMainDesc() {
        return mainDesc;
    }

    public void setMainDesc(String mainDesc) {
        this.mainDesc = mainDesc;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getAvgTemp() {
        Log.d("insidegetavg", "returningavgtempas " + avgTemp);
        return avgTemp;
    }

    public void setAvgTemp(int avgTemp) {
        this.avgTemp = avgTemp;
    }

    public int getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(int dayTemp) {
        this.dayTemp = dayTemp;
    }

    public int getEveTemp() {
        return eveTemp;
    }

    public void setEveTemp(int eveTemp) {
        this.eveTemp = eveTemp;
    }

    public int getNightTemp() {
        return nightTemp;
    }

    public void setNightTemp(int nightTemp) {
        this.nightTemp = nightTemp;
    }

    public int getMornTemp() {
        return mornTemp;
    }

    public void setMornTemp(int mornTemp) {
        this.mornTemp = mornTemp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(int weather_id) {
        this.weather_id = weather_id;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getRain() {
        return Double.valueOf(String.format("%.2f", rain));
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    // @RequiresApi(api = Build.VERSION_CODES.N)
    public String convertToDate(long l) {
        Date d = new Date(l * 1000);
        SimpleDateFormat date = new SimpleDateFormat("E dd/MM/yyyy", Locale.getDefault());
        return (date.format(d));

    }

    //   @RequiresApi(api = Build.VERSION_CODES.N)
    public static String convertToTime() {
        Date d = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat date = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        TimeZone t = TimeZone.getTimeZone("GMT+5:30");
        date.setTimeZone(t);
        return (date.format(d));
    }
}
