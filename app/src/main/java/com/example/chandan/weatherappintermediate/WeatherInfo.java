package com.example.chandan.weatherappintermediate;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherInfo extends Fragment {

    public static TextView cityOnExtras, countryOnExtras, dateOnExtras, morningTemp, nightTemp, eveTemp,
            dayTemp, humidity, pressure, clouds, windSpeed, min, max, windAngle, rain, futdesc, mor, days, nigh, eve, more, hum, clo, rai, prs, wins, wina;
    ;
    FontSetter sa = new FontSetter(getActivity());

    public WeatherInfo() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cityOnExtras = (TextView) getActivity().findViewById(R.id.setCityOnExtraInfo);
        countryOnExtras = (TextView) getActivity().findViewById(R.id.setCountryOnExtraInfo);
        dateOnExtras = (TextView) getActivity().findViewById(R.id.futureDateid);
        morningTemp = (TextView) getActivity().findViewById(R.id.setMorningTemp);
        dayTemp = (TextView) getActivity().findViewById(R.id.setDayTemp);
        eveTemp = (TextView) getActivity().findViewById(R.id.setEveningTemp);
        nightTemp = (TextView) getActivity().findViewById(R.id.setNightTemp);
        humidity = (TextView) getActivity().findViewById(R.id.setHumidity);
        pressure = (TextView) getActivity().findViewById(R.id.setPressure);
        clouds = (TextView) getActivity().findViewById(R.id.setClouds);
        windSpeed = (TextView) getActivity().findViewById(R.id.setWindSpeed);
        min = (TextView) getActivity().findViewById(R.id.setMin);
        max = (TextView) getActivity().findViewById(R.id.setMax);
        windAngle = (TextView) getActivity().findViewById(R.id.setWindAngle);
        rain = (TextView) getActivity().findViewById(R.id.setRain);
        futdesc = (TextView) getActivity().findViewById(R.id.futdesc);
        mor = (TextView) getView().findViewById(R.id.mor);
        days = (TextView) getView().findViewById(R.id.day);
        nigh = (TextView) getView().findViewById(R.id.nig);
        eve = (TextView) getView().findViewById(R.id.eve);
        more = (TextView) getView().findViewById(R.id.moreinfo);
        hum = (TextView) getView().findViewById(R.id.hum);
        prs = (TextView) getView().findViewById(R.id.prs);
        rai = (TextView) getView().findViewById(R.id.rai);
        clo = (TextView) getView().findViewById(R.id.clo);
        wina = (TextView) getView().findViewById(R.id.winan);
        wins = (TextView) getView().findViewById(R.id.winsp);


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("morningofinfois", mor + "");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sa.fontSetter(WeatherInfo.eve);
        sa.fontSetter(WeatherInfo.nigh);
        sa.fontSetter(WeatherInfo.days);
        sa.fontSetter(WeatherInfo.more);
        sa.fontSetter(WeatherInfo.hum);
        sa.fontSetter(WeatherInfo.wina);
        sa.fontSetter(WeatherInfo.wins);
        sa.fontSetter(WeatherInfo.rai);
        sa.fontSetter(WeatherInfo.prs);
        sa.fontSetter(WeatherInfo.clo);
        sa.fontSetter(WeatherInfo.cityOnExtras);
        sa.fontSetter(WeatherInfo.countryOnExtras);
        sa.fontSetter(WeatherInfo.nightTemp);
        sa.fontSetter(WeatherInfo.morningTemp);
        sa.fontSetter(WeatherInfo.dayTemp);
        sa.fontSetter(WeatherInfo.eveTemp);
        sa.fontSetter(WeatherInfo.min);
        sa.fontSetter(WeatherInfo.max);
        sa.fontSetter(WeatherInfo.windSpeed);
        sa.fontSetter(WeatherInfo.windAngle);
        sa.fontSetter(WeatherInfo.rain);
        sa.fontSetter(WeatherInfo.futdesc);
        sa.fontSetter(WeatherInfo.dateOnExtras);
        sa.fontSetter(WeatherInfo.clouds);
        sa.fontSetter(WeatherInfo.humidity);
        sa.fontSetter(WeatherInfo.pressure);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_info, container, false);
    }

}
