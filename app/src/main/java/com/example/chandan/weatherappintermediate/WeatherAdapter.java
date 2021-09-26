package com.example.chandan.weatherappintermediate;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
//import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by chandan on 22-06-2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.FutureWeatherHolder> {

    LayoutInflater l;
    Context con;
    int count;
    ArrayList<FutureTempData> dataArrayList;

    public WeatherAdapter(Context con, ArrayList<FutureTempData> dataArrayList, int count) {
        this.con = con;
        l = LayoutInflater.from(con);
        this.dataArrayList = dataArrayList;
        this.count = count;
    }


    @Override
    public FutureWeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (parent == null) Log.i("Inside fwh", "parent is null");
        View v = l.inflate(R.layout.future_temp, parent, false);

        Log.d("Inside oncreatevhrcv", "inflated successfully");

        FutureWeatherHolder h = new FutureWeatherHolder(v);
        return h;
    }

    @Override
    public int getItemCount() {
        return count;
    }


    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(FutureWeatherHolder holder, final int position) {
        Log.i("Inside bindview", "binding data" + position);


        if (dataArrayList.isEmpty()) {
            Log.i("insidebindview", "nullarraylist");
            holder.futDate.setText("notavailable");
        } else {
            Log.i("insidebindview", "notnullarraylist" + dataArrayList.isEmpty());

            String date = FutureTempData.convertToDate(dataArrayList.get(position).getDate());
            Log.i("aboverecyclerimage", position + "time");
            holder.img.setImageResource(new IconFinder().findIconId(dataArrayList.get(position)
                    .getIconId(), dataArrayList.get(position).getWeather_id()));
            Log.i("belowrecyclerimage", "valueis" + dataArrayList.get(position).getIconId());
            holder.futDate.setText(date);
            holder.desc.setText(dataArrayList.get(position).getMainDesc());
            new FontSetter(con).fontSetter(holder.desc);
            new FontSetter(con).fontSetter(holder.futDate);
            new FontSetter(con).fontSetter(holder.temperature);
            holder.temperature.setText(dataArrayList.get(position).getAvgTemp() + "");
            int id = new IconFinder().findBackgroundSwipeIconId(dataArrayList.get(position).getIconId
                    (), dataArrayList.get(position).getWeather_id());
            holder.ll.setBackgroundResource(id);
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!dataArrayList.isEmpty()) {
                        //FutureWeatherActivity.updateData(dataArrayList);
                        Intent i = new Intent(con, FutureWeatherActivity.class);
                        i.putExtra("DATA", dataArrayList.get(position));
                        con.startActivity(i);
                    } else {
                        Toast.makeText(con, "no data available", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public class FutureWeatherHolder extends RecyclerView.ViewHolder {
        TextView futDate, temperature, desc;
        LinearLayout ll;
        ImageView img;

        public FutureWeatherHolder(View itemView) {
            super(itemView);
            futDate = (TextView) itemView.findViewById(R.id.futureDateid);
            temperature = (TextView) itemView.findViewById(R.id.futureTempid);
            desc = (TextView) itemView.findViewById(R.id.futureDescid);
            ll = (LinearLayout) itemView.findViewById(R.id.rootid);
            img = (ImageView) itemView.findViewById(R.id.futureIconid);


        }
    }


}
