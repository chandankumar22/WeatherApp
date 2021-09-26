package com.example.chandan.weatherappintermediate;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.chandan.weatherappintermediate.MainActivity.fname;
import static com.example.chandan.weatherappintermediate.MainActivity.main;
import static com.example.chandan.weatherappintermediate.WeatherInfo.mor;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainPage extends Fragment {
    static RecyclerView rc;
    RecyclerView.Adapter<WeatherAdapter.FutureWeatherHolder> ad;
    String url;
    EditText et;
    static int ImgId;
    static Context context;
    Button b;
    static View mainroot;
    public static TextView location, country, latitude, longitude, date, time, temperature,
            description, dat, tim;

    public static ImageView iconfront;
    FontSetter sa;

    public MainPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_page, container, false);
        Log.d("oncreateviewm.p.frg", "settingrecyclerview,con" + getContext());
        rc = (RecyclerView) v.findViewById(R.id.rid);
        ad = new WeatherAdapter(this.getActivity(), new ArrayList<FutureTempData>(), 0);
        rc.setAdapter(ad);
        rc.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager
                .HORIZONTAL, false));
        context = getActivity();
        Log.d("oncreateviewm.p.frg", "returningview,act" + getActivity() + context);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainroot = getActivity().findViewById(R.id.drawerlayout);
        Log.d("ContextSendingIs", context + "");
        sa = new FontSetter(context);

        location = (TextView) getView().findViewById(R.id.setLocation);
        country = (TextView) getView().findViewById(R.id.setCountry);
        latitude = (TextView) getView().findViewById(R.id.setLat);
        longitude = (TextView) getView().findViewById(R.id.setLon);
        date = (TextView) getView().findViewById(R.id.setDate);
        time = (TextView) getView().findViewById(R.id.settime);
        temperature = (TextView) getView().findViewById(R.id.setTemperature);
        description = (TextView) getView().findViewById(R.id.setDesc);
        dat = (TextView) getView().findViewById(R.id.Date);
        tim = (TextView) getView().findViewById(R.id.Time);
        iconfront = (ImageView) getView().findViewById(R.id.iconfrontpage);
    }


    public void connectToNetwork(String loc) {
        String url = "http://api.openweathermap" +
                ".org/data/2.5/forecast/daily?q=" + loc + "&cnt=16&APPID" +
                "=cd1359c8f61b3d24fba116a5050d918d";
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo nf = cm.getActiveNetworkInfo();
        if (nf != null && nf.isConnected()) {
            new WeatherThread().execute(url);
            mainroot.setVisibility(View.VISIBLE);
        } else {
            mainroot.setVisibility(View.INVISIBLE);
//            root2.setVisibility(View.INVISIBLE);
            Toast.makeText(context, "NO NETWORK", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("onstaetmainpage", "" + fname);
        connectToNetwork(fname);
/*1stpagefontset*/
        sa.fontSetter(location);
        // sa.fontSetter(country);
        sa.fontSetter(latitude);
        sa.fontSetter(longitude);
        sa.fontSetter(country);
        sa.fontSetter(description);
        sa.fontSetter(time);
        sa.fontSetter(temperature);
        sa.fontSetter(date);
        sa.fontSetter(dat);
        sa.fontSetter(tim);

        /*Secondpage*/
        sa.fontSetter(mor);

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

    }


    public class WeatherThread extends AsyncTask<String, Void, ArrayList> {

        ProgressDialog p;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(context);
            p.setTitle("Wait..");
            p.setMessage("Getting Data From Server");
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected ArrayList doInBackground(String... params) {
            Log.d("Inside doinbg", "gettingdatafromserver");
            ArrayList<Object> t = BackgroundTask.dataFromServer(params[0], context);
            if (t == null) Log.d("Inside doinbg", "null t");
            // Log.d("Inside doinbg", "returningdatawitlengthofarraylist(2exp) " + t.size());
            return t;
        }

        ///@RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onPostExecute(ArrayList resultData) {
            //Log.d("Inside onpost","returningdatatom.p.frgtouiupdate"+tempData.getMainDesc()
            // +tempData
            // .getMaxTemp()+tempData.getWeatherDesc()+tempData.getDegree());


            if (resultData == null) {
                //  Log.d("getActivityis", getActivity().toString());
                p.dismiss();
                Toast.makeText(context, "Error getting data", Toast
                        .LENGTH_SHORT).show();
                return;
            }
            p.dismiss();
            TempData tempData = (TempData) resultData.get(0);
            ArrayList<FutureTempData> futureTempData = (ArrayList<FutureTempData>) resultData.get(1);

            Log.d("Inside onpost", "lengthofarraylist(2exp) " + futureTempData.size());
            String setdate = new TempData().convertToDate(tempData.getDate());
            Log.d("yahapeaarhahnull", "" + description);
            country.setText(tempData.getCountry());
            description.setText(new IconFinder().getWeatherMessage(tempData.getWeather_id()));
            latitude.setText("LAT: " + tempData.getLat());
            time.setText(TempData.convertToTime());
            longitude.setText("LON: " + tempData.getLon());
            location.setText(tempData.getCityName());
            temperature.setText(tempData.getAvgTemp() + "");
            date.setText(setdate);

            int backImgId = new IconFinder().findBackgroundIconId(tempData.getIconId(), tempData
                    .getWeather_id());
            main.setBackgroundResource(backImgId);

            ImgId = new IconFinder().findIconId(tempData.getIconId(), tempData.getWeather_id());
            iconfront.setImageResource(ImgId);

            WeatherInfo.cityOnExtras.setText(tempData.getCityName());
            WeatherInfo.countryOnExtras.setText(tempData.getCountry());
            WeatherInfo.morningTemp.setText(tempData.getMornTemp() + "");
            WeatherInfo.dayTemp.setText(tempData.getDayTemp() + "");
            WeatherInfo.eveTemp.setText(tempData.getEveTemp() + "");
            WeatherInfo.nightTemp.setText(tempData.getNightTemp() + "");
            WeatherInfo.humidity.setText(tempData.getHumidity() + "%");
            WeatherInfo.pressure.setText(tempData.getPressure() + "");
            WeatherInfo.clouds.setText(tempData.getClouds() + "%");
            WeatherInfo.windSpeed.setText(tempData.getSpeed() + "");
            WeatherInfo.min.setText(tempData.getMinTemp() + "");
            WeatherInfo.max.setText(tempData.getMaxTemp() + "");
            WeatherInfo.windAngle.setText(tempData.getDegree() + "degree");
            WeatherInfo.rain.setText(tempData.getRain() + "mm");
            WeatherInfo.futdesc.setText(tempData.getWeatherDesc().toUpperCase() + "");
            WeatherInfo.dateOnExtras.setText(new TempData().convertToDate(tempData.getDate()));

            if (rc == null) {
                Log.d("going to main activity", "bye bye");
                Log.d("onpostexecute", "canisetvphere" + new MainActivity().vp);
            }
            Log.d("onpostexecute",
                    "rcis" + rc);
            new MainActivity().yahaao(rc, futureTempData);
            Log.d("onpostexecute", "activityis" + getActivity());

            rc.setAdapter(new WeatherAdapter(context, futureTempData, tempData.getCnt()));
        }


    }


}


