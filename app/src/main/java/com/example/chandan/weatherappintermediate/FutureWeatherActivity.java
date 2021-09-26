package com.example.chandan.weatherappintermediate;

import android.os.Build;
//import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class FutureWeatherActivity extends AppCompatActivity {
    public static TextView cityOnExtras, countryOnExtras, dateOnExtras, morningTemp, nightTemp, eveTemp,
            dayTemp, humidity, pressure, clouds, windSpeed, min, max,windAngle,rain,futDesc,mor,days,nigh,eve,more,hum,clo,rai,prs,wins,wina;;;
static ImageView second;
    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_weather_info);
        second = (ImageView) findViewById(R.id.second);
        cityOnExtras = (TextView) findViewById(R.id.setCityOnExtraInfo);
        countryOnExtras = (TextView) findViewById(R.id.setCountryOnExtraInfo);
        dateOnExtras = (TextView) findViewById(R.id.futureDateid);
        morningTemp = (TextView) findViewById(R.id.setMorningTemp);
        dayTemp = (TextView) findViewById(R.id.setDayTemp);
        Log.i("Activity2","reference"+dayTemp);
        eveTemp = (TextView) findViewById(R.id.setEveningTemp);
        nightTemp = (TextView) findViewById(R.id.setNightTemp);
        humidity = (TextView) findViewById(R.id.setHumidity);
        pressure = (TextView) findViewById(R.id.setPressure);
        clouds = (TextView) findViewById(R.id.setClouds);
        windSpeed = (TextView) findViewById(R.id.setWindSpeed);
        min = (TextView) findViewById(R.id.setMin);
        max = (TextView) findViewById(R.id.setMax);
        windAngle = (TextView) findViewById(R.id.setWindAngle);
        rain = (TextView) findViewById(R.id.setRain);
        mor = (TextView)  findViewById(R.id.mor);
        days = (TextView)  findViewById(R.id.day);
        nigh = (TextView)  findViewById(R.id.nig);
        eve = (TextView)  findViewById(R.id.eve);
        more = (TextView)  findViewById(R.id.moreinfo);
        hum = (TextView)  findViewById(R.id.hum);
        prs = (TextView)  findViewById(R.id.prs);
        rai = (TextView)  findViewById(R.id.rai);
        clo = (TextView)  findViewById(R.id.clo);
        wina = (TextView)  findViewById(R.id.winan);
        wins = (TextView)  findViewById(R.id.winsp);

        futDesc= (TextView) findViewById(R.id.futdesc);
        FutureTempData d = (FutureTempData) getIntent()
                .getSerializableExtra("DATA");




            String date=FutureTempData.convertToDate(d.getDate());
            Log.i("at  " +date+"country",d
                     .getCountry());
            Log.i("at  " +date+"city",d .getCityName());
            Log.i("at  " +date+"morntemp",d .getMornTemp() + "");
            Log.i("at  " +date+"daytemp",d .getDayTemp() + "");
            Log.i("at  "+date+"evetemp",d .getEveTemp() + "");
            //Log.d("insidebindingelse","working"+ );
            Log.i("at  "+date+"nighttemp",d .getNightTemp() +
                    "");
            Log.i("at  "+ date+"humidity",d .getHumidity() + "");
            Log.i("at  " +date+"pressure",d .getPressure() + "");
            Log.i("at  "+ date+"degree",d .getDegree() + "");
            Log.i("at  "+ date+"speed",d .getSpeed() + "");
            Log.i("at  "+ date+"mintemp",d .getMinTemp() + "");
            Log.i("at  "+ date+"maxtemp",d .getMaxTemp() + "");




        second.setBackgroundResource(new IconFinder().findBackgroundIconId(d.getIconId
                (),d.getWeather_id()));
            cityOnExtras.setText(d .getCityName());
            countryOnExtras.setText(d.getCountry());
            morningTemp.setText(d .getMornTemp()+"");
            dayTemp.setText(d .getDayTemp() + "");
            eveTemp.setText(d .getEveTemp() + "");
            Log.d("insidebindingelse","working");
            nightTemp.setText(d .getNightTemp() + "");
            humidity.setText(d .getHumidity() + "%");
            pressure.setText(d .getPressure() + "");
            clouds.setText(d.getClouds() +"%");
        dateOnExtras.setText(date);
            windSpeed.setText(d .getSpeed() + "");
            min.setText(d .getMinTemp() + "");
            max.setText(d .getMaxTemp() + "");
        windAngle.setText(d.getDegree()+"deg");
        rain.setText(d.getRain()+"mm");
        futDesc.setText(new IconFinder().getWeatherMessage(d.getWeather_id()));

        FontSetter sa = new FontSetter(this);
        Log.d("morningoffuureis",mor+"");
        sa.fontSetter(cityOnExtras);
        sa.fontSetter(nightTemp);
        sa.fontSetter(morningTemp);
        sa.fontSetter(dayTemp);
        sa.fontSetter(eveTemp);
        sa.fontSetter(min);
        sa.fontSetter(max);
        sa.fontSetter(windSpeed);
        sa.fontSetter(windAngle);
        sa.fontSetter(rain);
        sa.fontSetter(futDesc);
        sa.fontSetter(countryOnExtras);
        sa.fontSetter(dateOnExtras);
        sa.fontSetter(clouds);
        sa.fontSetter(humidity);
        sa.fontSetter(pressure);
        sa.fontSetter(mor);
        sa.fontSetter(eve);
        sa.fontSetter(nigh);
        sa.fontSetter(days);
        sa.fontSetter(more);
        sa.fontSetter(hum);
        sa.fontSetter(wina);
        sa.fontSetter(wins);
        sa.fontSetter(rai);
        sa.fontSetter(prs);
        sa.fontSetter(clo);
    }

}
