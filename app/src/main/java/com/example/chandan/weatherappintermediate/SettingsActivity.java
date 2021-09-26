package com.example.chandan.weatherappintermediate;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    RadioGroup rgTemp, rgPressure, rgWind, fontrg;
    RadioButton radioButtonC, radioButtonF, radioButtonK, radioButtonMph, radioButtonKmph,
            radioButtonMps, radioButtonhPa, radioButtonAtm, radioButtonMMofHg, radioButtonPascal, f1,
            f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14;
    SharedPreferences sharedPreferences, s2;
    SharedPreferences.Editor seditor, se2;
    TextView temp, sp, pr, fo, clear;
    FontSetter fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fs = new FontSetter(this);

        sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        s2 = getSharedPreferences("Location", MODE_PRIVATE);
        seditor = sharedPreferences.edit();
        se2 = s2.edit();
        /*seditor.putString("Temperature","Celsius");
        seditor.commit();*/

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("SETTINGS");
        clear = (TextView) findViewById(R.id.clear);
        toolBar.setNavigationIcon(getResources().getDrawable(R.drawable.backbutton));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int size = getIntent().getExtras().getInt("size");
                Log.d("defaultLocation", s2.getString("defaultLocation", "") + "");
                Log.d("size", s2.getAll().size() + "");
                Log.d("1", s2.getString("1", ""));
                Log.d("2", s2.getString("2", ""));
                Log.d("3", s2.getString("3", ""));
                Log.d("4", s2.getString("4", ""));
                Log.d("5", s2.getString("5", ""));
                Log.d("6", s2.getString("6", ""));
                Log.d("7", s2.getString("7", ""));
                Log.d("8", s2.getString("8", ""));
                Log.d("9", s2.getString("9", ""));
                Log.d("10", s2.getString("10", ""));
                Log.d("11", s2.getString("11", ""));
                Log.d("12", s2.getString("12", ""));
                Log.d("13", s2.getString("13", ""));
                for (int i = 4; i < size; i++) {
                    Log.d("clearrecnt", s2.getString(i + "", "") + "");
                    se2.remove(i + "");
                    se2.apply();
                }
                Toast.makeText(SettingsActivity.this, "Removed..Restart app to apply changes", Toast
                        .LENGTH_SHORT).show();
            }
        });

        // t.setFontFeatureSettings();
        rgTemp = (RadioGroup) findViewById(R.id.radioTemp);
        rgPressure = (RadioGroup) findViewById(R.id.pressurerg);
        rgWind = (RadioGroup) findViewById(R.id.windspeedrg);
        fontrg = (RadioGroup) findViewById(R.id.fontrg);


        radioButtonC = (RadioButton) findViewById(R.id.celsius);
        radioButtonF = (RadioButton) findViewById(R.id.fahr);
        radioButtonK = (RadioButton) findViewById(R.id.kelvin);


        radioButtonMps = (RadioButton) findViewById(R.id.mps);
        radioButtonMph = (RadioButton) findViewById(R.id.mph);
        radioButtonKmph = (RadioButton) findViewById(R.id.kmph);


        radioButtonhPa = (RadioButton) findViewById(R.id.hPA);
        radioButtonAtm = (RadioButton) findViewById(R.id.atm);
        radioButtonMMofHg = (RadioButton) findViewById(R.id.mmOfHg);
        radioButtonPascal = (RadioButton) findViewById(R.id.pascal);


        f1 = (RadioButton) findViewById(R.id.arcena);
        f2 = (RadioButton) findViewById(R.id.banffno);
        f3 = (RadioButton) findViewById(R.id.banglenormal);
        f4 = (RadioButton) findViewById(R.id.bauderiescriptssi);
        f5 = (RadioButton) findViewById(R.id.bookmanoldstyle);
        f6 = (RadioButton) findViewById(R.id.busorama);
        f7 = (RadioButton) findViewById(R.id.dauphinn);
        f8 = (RadioButton) findViewById(R.id.freehand);
        f9 = (RadioButton) findViewById(R.id.organo);
        f10 = (RadioButton) findViewById(R.id.chiller);
        f11 = (RadioButton) findViewById(R.id.carpenterscript);
        f12 = (RadioButton) findViewById(R.id.clairvauxroman);
        f13 = (RadioButton) findViewById(R.id.curlyq);


        temp = (TextView) findViewById(R.id.te);
        fs.fontSetter(temp);
        sp = (TextView) findViewById(R.id.wind);
        fs.fontSetter(sp);
        pr = (TextView) findViewById(R.id.pressure);
        fs.fontSetter(pr);
        fo = (TextView) findViewById(R.id.fo);
        fs.fontSetter(fo);
        fs.fontSetter(clear);
        fs.fontSetterRadioButton(radioButtonC);
        fs.fontSetterRadioButton(radioButtonF);
        fs.fontSetterRadioButton(radioButtonK);
        fs.fontSetterRadioButton(radioButtonMps);
        fs.fontSetterRadioButton(radioButtonMph);
        fs.fontSetterRadioButton(radioButtonKmph);
        fs.fontSetterRadioButton(radioButtonhPa);
        fs.fontSetterRadioButton(radioButtonAtm);
        fs.fontSetterRadioButton(radioButtonMMofHg);
        fs.fontSetterRadioButton(radioButtonPascal);
        fs.fontSetterRadioButton(f1);
        fs.fontSetterRadioButton(f2);
        fs.fontSetterRadioButton(f3);
        fs.fontSetterRadioButton(f4);
        fs.fontSetterRadioButton(f5);
        fs.fontSetterRadioButton(f6);
        fs.fontSetterRadioButton(f7);
        fs.fontSetterRadioButton(f8);
        fs.fontSetterRadioButton(f9);
        fs.fontSetterRadioButton(f10);
        fs.fontSetterRadioButton(f11);
        fs.fontSetterRadioButton(f12);
        fs.fontSetterRadioButton(f13);


        Log.d("Valuestoredis", sharedPreferences.getString("Temperature", ""));
        Log.d("celsius", radioButtonC.isChecked() + "");
        Log.d("fahr", radioButtonF.isChecked() + "");
        Log.d("kelvin", radioButtonK.isChecked() + "");

        if (sharedPreferences.getString("Temperature", "").equals("Celsius")) radioButtonC
                .setChecked(true);
        else if (sharedPreferences.getString("Temperature", "").equals("Fahrenheit")) radioButtonF
                .setChecked(true);
        else if (sharedPreferences.getString("Temperature", "").equals("Kelvin")) radioButtonK
                .setChecked(true);
        else {
            seditor.putString("Temperaure", "Celsius");
            seditor.apply();
            radioButtonC
                    .setChecked(true);
        }


        if (sharedPreferences.getString("WindSpeed", "").equals("m/s")) radioButtonMps
                .setChecked(true);
        else if (sharedPreferences.getString("WindSpeed", "").equals("km/h")) radioButtonKmph
                .setChecked(true);
        else if (sharedPreferences.getString("WindSpeed", "").equals("m/h")) radioButtonMph
                .setChecked(true);
        else {
            seditor.putString("WindSpeed", "m/s");
            seditor.apply();
            radioButtonMps
                    .setChecked(true);
        }


        if (sharedPreferences.getString("Pressure", "").equals("hPa")) radioButtonhPa
                .setChecked(true);
        else if (sharedPreferences.getString("Pressure", "").equals("Pascal")) radioButtonPascal
                .setChecked(true);
        else if (sharedPreferences.getString("Pressure", "").equals("atm")) radioButtonAtm
                .setChecked(true);
        else if (sharedPreferences.getString("Pressure", "").equals("mmOfHg")) radioButtonMMofHg
                .setChecked(true);
        else {
            seditor.putString("Pressure", "hPa");
            seditor.apply();
            radioButtonhPa
                    .setChecked(true);
        }


        if (sharedPreferences.getString("Font", "").equals("arcena")) f1
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("banffno")) f2
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("banglenormal")) f3
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("bauderiescriptssi")) f4
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("bookold")) f5
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("busorama")) f6
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("dauphinn")) f7
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("freehand")) f8
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("organo")) f9
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("chiller")) f10
                .setChecked(true);

        else if (sharedPreferences.getString("Font", "").equals("carpenterscript")) f11
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("clairvauxroman")) f12
                .setChecked(true);
        else if (sharedPreferences.getString("Font", "").equals("curlyq")) f13
                .setChecked(true);

        else {
            seditor.putString("Font", "banglenormal");
            seditor.apply();
            f3.setChecked(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.save) {
            int idTemp = rgTemp.getCheckedRadioButtonId();
            int idWind = rgWind.getCheckedRadioButtonId();
            int idPressure = rgPressure.getCheckedRadioButtonId();
            int idFont = fontrg.getCheckedRadioButtonId();
            switch (idTemp) {
                case R.id.celsius:
                    seditor.putString("Temperature", "Celsius");
                    seditor.commit();
                    radioButtonC.setChecked(true);
                    break;
                case R.id.fahr:
                    seditor.putString("Temperature", "Fahrenheit");
                    seditor.commit();
                    radioButtonF.setChecked(true);
                    break;
                case R.id.kelvin:
                    seditor.putString("Temperature", "Kelvin");
                    seditor.commit();
                    radioButtonK.setChecked(true);
                    break;
            }
            switch (idWind) {
                case R.id.mps:
                    seditor.putString("WindSpeed", "m/s");
                    seditor.commit();
                    radioButtonMps.setChecked(true);
                    break;
                case R.id.mph:
                    seditor.putString("WindSpeed", "m/h");
                    radioButtonMph.setChecked(true);
                    seditor.commit();
                    break;
                case R.id.kmph:
                    seditor.putString("WindSpeed", "km/h");
                    seditor.commit();
                    radioButtonKmph.setChecked(true);
                    break;
            }
            switch (idPressure) {
                case R.id.hPA:
                    seditor.putString("Pressure", "hPa");
                    seditor.commit();
                    radioButtonhPa.setChecked(true);
                    break;
                case R.id.pascal:
                    seditor.putString("Pressure", "Pascal");
                    seditor.commit();
                    radioButtonPascal.setChecked(true);
                    break;
                case R.id.mmOfHg:
                    seditor.putString("Pressure", "mmOfHg");
                    seditor.commit();
                    radioButtonMMofHg.setChecked(true);
                    break;
                case R.id.atm:
                    seditor.putString("Pressure", "atm");
                    seditor.commit();
                    radioButtonAtm.setChecked(true);
                    break;
            }
            switch (idFont) {
                case R.id.arcena:
                    seditor.putString("Font", "arcena");
                    seditor.commit();
                    f1.setChecked(true);
                    break;
                case R.id.banffno:
                    seditor.putString("Font", "banffno");
                    seditor.commit();
                    f2.setChecked(true);
                    break;
                case R.id.banglenormal:
                    seditor.putString("Font", "banglenormal");
                    seditor.commit();
                    f3.setChecked(true);
                    break;
                case R.id.bauderiescriptssi:
                    seditor.putString("Font", "bauderiescriptssi");
                    seditor.commit();
                    f4.setChecked(true);
                    break;
                case R.id.bookmanoldstyle:
                    seditor.putString("Font", "bookold");
                    seditor.commit();
                    f5.setChecked(true);
                    break;
                case R.id.busorama:
                    seditor.putString("Font", "busorama");
                    seditor.commit();
                    f6.setChecked(true);
                    break;
                case R.id.dauphinn:
                    seditor.putString("Font", "dauphinn");
                    seditor.commit();
                    f7.setChecked(true);
                    break;
                case R.id.freehand:
                    seditor.putString("Font", "freehand");
                    seditor.commit();
                    f8.setChecked(true);
                    break;
                case R.id.organo:
                    seditor.putString("Font", "organo");
                    seditor.commit();
                    f9.setChecked(true);
                    break;
                case R.id.chiller:
                    seditor.putString("Font", "chiller");
                    seditor.commit();
                    f10.setChecked(true);
                    break;
                case R.id.carpenterscript:
                    seditor.putString("Font", "carpenterscript");
                    seditor.commit();
                    f11.setChecked(true);
                    break;
                case R.id.clairvauxroman:
                    seditor.putString("Font", "clairvauxroman");
                    seditor.commit();
                    f12.setChecked(true);
                    break;
                case R.id.curlyq:
                    seditor.putString("Font", "curlyq");
                    seditor.commit();
                    f13.setChecked(true);
                    break;
            }

        }
        temp = (TextView) findViewById(R.id.te);
        fs.fontSetter(temp);
        sp = (TextView) findViewById(R.id.wind);
        fs.fontSetter(sp);
        pr = (TextView) findViewById(R.id.pressure);
        fs.fontSetter(pr);
        fo = (TextView) findViewById(R.id.fo);
        fs.fontSetter(fo);
        fs.fontSetterRadioButton(radioButtonC);
        fs.fontSetterRadioButton(radioButtonF);
        fs.fontSetterRadioButton(radioButtonK);
        fs.fontSetterRadioButton(radioButtonMps);
        fs.fontSetterRadioButton(radioButtonMph);
        fs.fontSetterRadioButton(radioButtonKmph);
        fs.fontSetterRadioButton(radioButtonhPa);
        fs.fontSetterRadioButton(radioButtonAtm);
        fs.fontSetterRadioButton(radioButtonMMofHg);
        fs.fontSetterRadioButton(radioButtonPascal);
        fs.fontSetterRadioButton(f1);
        fs.fontSetterRadioButton(f2);
        fs.fontSetterRadioButton(f3);
        fs.fontSetterRadioButton(f4);
        fs.fontSetterRadioButton(f5);
        fs.fontSetterRadioButton(f6);
        fs.fontSetterRadioButton(f7);
        fs.fontSetterRadioButton(f8);
        fs.fontSetterRadioButton(f9);
        fs.fontSetterRadioButton(f10);
        fs.fontSetterRadioButton(f11);
        fs.fontSetterRadioButton(f12);
        fs.fontSetterRadioButton(f13);
        fs.fontSetter(clear);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu_item, menu);
        return true;
    }


}
