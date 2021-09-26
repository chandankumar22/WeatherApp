package com.example.chandan.weatherappintermediate;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by chandan on 22-06-2017.
 */

public class BackgroundTask {

    private static final double KELVIN_TEMP = 273.15;
    static Context con;
    static SharedPreferences s;

    public static ArrayList<Object> dataFromServer(String url, Context context) {

        con = context;
        String settingTemp = "", settingWind = "", settingPressure = "";
        SettingsHandler settingsHandler = new SettingsHandler();
        Log.d("Inside datafromserver", "urlstringreceived");
        TempData weatherDataList;
        ArrayList<Object> result = new ArrayList<>();
        if (con != null) {
            s = con.getSharedPreferences("Settings", MODE_PRIVATE);
            settingTemp = s.getString("Temperature", "");
            settingWind = s.getString("WindSpeed", "");
            settingPressure = s.getString("Pressure", "");
        }

        if (TextUtils.isEmpty(url)) return null;
        URL u = createtURL(url);
        Log.d("Inside datafromserver", "urlobjectcreated...reqforhttp");
        String jsonRespone = requestForHTTP(u);
        Log.d("Inside datafromserver", "jsonresponserecd");


        if (TextUtils.isEmpty(jsonRespone)) {
            Log.d("Inside datafromserver", "checkingfornulljsonresponse");
            return null;
        }


        try {
            JSONObject obj = new JSONObject(jsonRespone);
            String status = obj.getString("cod");
            if (status.equals("400")) return null;
            JSONObject city = obj.getJSONObject("city");
            Log.d("Inside datafromserver", "extractcityname");
            String cityName = city.getString("name");  //1.STORING CITYNAME
            int cnt = obj.getInt("cnt");

            JSONObject cord = city.getJSONObject("coord");
            Log.d("Inside datafromserver", "extractlatlon");
            double lat = cord.getDouble("lat");//2.LATITUDE
            double lon = cord.getDouble("lon");//3.LONGITUDE


            Log.d("Inside datafromserver", "extractcountryname");
            String country = city.getString("country");//4.COUNTRY

            JSONArray list = obj.getJSONArray("list");
            JSONObject list1 = list.getJSONObject(0);
            long date = list1.getLong("dt");//5.DATE

            JSONObject temperature = list1.getJSONObject("temp");
            double minTemp = (temperature.getDouble("min") - KELVIN_TEMP);//6.MINIMUM
            // TEMPERATURE
            double maxTemp = (temperature.getDouble("max") - KELVIN_TEMP);//7.MAXIMUM TEMPURATURE
            double avgTemp = ((minTemp + maxTemp) / 2.0);//8.AVERAGE TEMPERATURE

            Log.d("AVGTEMP is", avgTemp + "");
            double dayTemp = (temperature.getDouble("day") - KELVIN_TEMP);//9.DAY TEMPERATURE
            double nightTemp = (temperature.getDouble("night") - KELVIN_TEMP);//10.NIGHT
            // TEMPERATURE
            double eveTemp = (temperature.getDouble("eve") - KELVIN_TEMP);//11.EVENING TEMPERATURE
            double morningTemp = (temperature.getDouble("morn") - KELVIN_TEMP);//12.MORNING
            // TEMPERATURE
            if (settingTemp.equals("Fahrenheit")) {
                avgTemp = settingsHandler.toFahrenheit(avgTemp);
                maxTemp = settingsHandler.toFahrenheit(maxTemp);
                minTemp = settingsHandler.toFahrenheit(minTemp);
                eveTemp = settingsHandler.toFahrenheit(eveTemp);
                dayTemp = settingsHandler.toFahrenheit(dayTemp);
                nightTemp = settingsHandler.toFahrenheit(nightTemp);
                morningTemp = settingsHandler.toFahrenheit(morningTemp);
            }
            if (settingTemp.equals("Kelvin")) {
                avgTemp = settingsHandler.toKelvin(avgTemp);
                maxTemp = settingsHandler.toKelvin(maxTemp);
                minTemp = settingsHandler.toKelvin(minTemp);
                eveTemp = settingsHandler.toKelvin(eveTemp);
                dayTemp = settingsHandler.toKelvin(dayTemp);
                nightTemp = settingsHandler.toKelvin(nightTemp);
                morningTemp = settingsHandler.toKelvin(morningTemp);
            }


            double pressure = list1.getDouble("pressure");//13.PRESSURE
            if (settingPressure.equals("Pascal")) {
                pressure = settingsHandler.toPascal(pressure);
            }
            if (settingPressure.equals("mmOfHg")) {
                pressure = settingsHandler.toMmOfHg(pressure);
            }
            if (settingPressure.equals("atm")) {
                pressure = settingsHandler.toAtm(pressure);
            }

            int humidity = list1.getInt("humidity");//14.HUMIDITY

            double speed = list1.getInt("speed");//15.SPEED
            if (settingWind.equals("km/h")) {
                speed = settingsHandler.toKmph(speed);
            }
            if (settingWind.equals("m/h")) {
                speed = settingsHandler.toMph(speed);
            }
            int degree = list1.getInt("deg");//16.DEGREE
            int clouds = list1.getInt("clouds");//17.CLOUDS

            JSONArray weather = list1.getJSONArray("weather");
            JSONObject weatherlist1 = weather.getJSONObject(0);
            int weather_id = weatherlist1.getInt("id");//18.WEATHER ID
            String weather_desc = weatherlist1.getString("description");//19.DESCRIPTION
            String main = weatherlist1.getString("main");//20.MAIN
            String icon_id = weatherlist1.getString("icon");//21.ICON ID
            double rain;
            if (list1.has("rain")) rain = list1.getDouble("rain");
            else rain = 0.0;

            weatherDataList = new TempData(cityName, country, main, weather_desc, icon_id,
                    lat, lon, pressure, date, (int) minTemp, (int) maxTemp,
                    (int) avgTemp, (int) dayTemp, (int) eveTemp, (int) nightTemp,
                    (int) morningTemp, speed, degree, clouds, weather_id, humidity, rain, cnt);
            Log.d("Inside datafromserver", "returningobj");


            ArrayList<FutureTempData> futureList = new ArrayList<>();
            Log.d("Inside datafromserver", "lengthoflistis" + list.length());
            for (int i = 0; i < list.length(); i++) {
                JSONObject j = list.getJSONObject(i);
                long fDate = j.getLong("dt");


                JSONObject ftemperature = j.getJSONObject("temp");
                double fminTemp = (ftemperature.getDouble("min") - KELVIN_TEMP);//6.MINIMUM
                double fmaxTemp = (ftemperature.getDouble("max") - KELVIN_TEMP);//7.MAXIMUM
                double favgTemp = ((fminTemp + fmaxTemp) / 2.0);//8.AVERAGE TEMPERATURE

                Log.d("AVGTEMP is", avgTemp + "");
                double fdayTemp = (ftemperature.getDouble("day") - KELVIN_TEMP);//9.DAY
                double fnightTemp = (ftemperature.getDouble("night") - KELVIN_TEMP);//10.NIGHT
                double feveTemp = (ftemperature.getDouble("eve") - KELVIN_TEMP);//11.EVENING
                double fmorningTemp = (ftemperature.getDouble("morn") - KELVIN_TEMP);//12.MORNING


                if (settingTemp.equals("Fahrenheit")) {
                    favgTemp = settingsHandler.toFahrenheit(favgTemp);
                    fmaxTemp = settingsHandler.toFahrenheit(fmaxTemp);
                    fminTemp = settingsHandler.toFahrenheit(fminTemp);
                    feveTemp = settingsHandler.toFahrenheit(feveTemp);
                    fdayTemp = settingsHandler.toFahrenheit(fdayTemp);
                    fnightTemp = settingsHandler.toFahrenheit(fnightTemp);
                    fmorningTemp = settingsHandler.toFahrenheit(fmorningTemp);
                }
                if (settingTemp.equals("Kelvin")) {
                    favgTemp = settingsHandler.toKelvin(favgTemp);
                    fmaxTemp = settingsHandler.toKelvin(fmaxTemp);
                    fminTemp = settingsHandler.toKelvin(fminTemp);
                    feveTemp = settingsHandler.toKelvin(feveTemp);
                    fdayTemp = settingsHandler.toKelvin(fdayTemp);
                    fnightTemp = settingsHandler.toKelvin(fnightTemp);
                    fmorningTemp = settingsHandler.toKelvin(fmorningTemp);
                }


                double fpressure = j.getDouble("pressure");//13.PRESSURE
                if (settingPressure.equals("Pascal")) {
                    fpressure = settingsHandler.toPascal(fpressure);
                }
                if (settingPressure.equals("mmOfHg")) {
                    fpressure = settingsHandler.toMmOfHg(fpressure);
                }
                if (settingPressure.equals("atm")) {
                    fpressure = settingsHandler.toAtm(fpressure);
                }

                int fhumidity = j.getInt("humidity");//14.HUMIDITY

                double fspeed = j.getInt("speed");//15.SPEED

                if (settingWind.equals("km/h")) {
                    fspeed = settingsHandler.toKmph(fspeed);
                }
                if (settingWind.equals("m/h")) {
                    fspeed = settingsHandler.toMph(fspeed);
                }
                int fdegree = j.getInt("deg");//16.DEGREE
                int fclouds = j.getInt("clouds");//17.CLOUDS

                JSONArray fweather = j.getJSONArray("weather");
                JSONObject fweatherlist1 = fweather.getJSONObject(0);
                int fweather_id = fweatherlist1.getInt("id");//18.WEATHER ID
                String fweather_desc = fweatherlist1.getString("description");//19.DESCRIPTION
                String fmain = fweatherlist1.getString("main");//20.MAIN
                String ficon_id = fweatherlist1.getString("icon");//21.ICON ID
                double frain;
                if (j.has("rain")) frain = j.getDouble("rain");
                else frain = 0.0;


                Log.d("Inside datafromserver", "date stores at " + i + "as " + fDate);

                futureList.add(i, new FutureTempData(cityName, country, fmain,
                        fweather_desc, ficon_id,
                        fpressure, fDate, (int) fminTemp, (int) fmaxTemp, (int) favgTemp, (int) fdayTemp,
                        (int) feveTemp, (int) fnightTemp, (int) fmorningTemp, (int) fspeed, fdegree, fclouds,
                        fweather_id, fhumidity, frain));

                Log.d("Inside datafromserver", "date added at " + i + "as " + fDate);
            }

            result.add(weatherDataList);
            result.add(futureList);
            Log.d("Inside datafromserver", "lengthofresultis" + result.size());
            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;

    }


    public static URL createtURL(String url) {
        URL u = null;
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public static String requestForHTTP(URL url) {
        HttpURLConnection weatherConnection = null;
        String response = "";
        InputStream dataResponse = null;
        if (url == null) return response;

        try {
            weatherConnection = (HttpURLConnection) url.openConnection();
            weatherConnection.setRequestMethod("GET");
            weatherConnection.setConnectTimeout(10000);
            weatherConnection.setReadTimeout(10000);
            weatherConnection.connect();
            Log.d("Inside httprequest", "connected");
            if (weatherConnection.getResponseCode() == 200) {
                Log.d("Inside httprequest", "success");
                dataResponse = weatherConnection.getInputStream();
                response = byteToString(dataResponse);
            } else {
                Log.d("Inside httprequest", "unsuccess" + weatherConnection.getResponseCode());
                return "";
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (weatherConnection != null)
                weatherConnection.disconnect();
            Log.d("Inside httprequest", "disconnected");
            if (dataResponse != null)
                try {
                    dataResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return response;


    }

    public static String byteToString(InputStream is) throws IOException {
        StringBuffer data = new StringBuffer();
        String string;
        if (is != null) {
            InputStreamReader byteData = new InputStreamReader(is);
            BufferedReader bufferedData = new BufferedReader(byteData);
            string = bufferedData.readLine();
            while (string != null) {
                data.append(string);
                string = bufferedData.readLine();
            }
        }
        return data.toString();
    }


}
