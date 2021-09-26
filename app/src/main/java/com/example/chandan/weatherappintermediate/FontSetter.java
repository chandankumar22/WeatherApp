package com.example.chandan.weatherappintermediate;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by chandan on 01-07-2017.
 */

public class FontSetter {

Context context;
    

    public FontSetter(Context context) {
        this.context = context;
        Log.d("ContextReceivedIs",context+"");
    }

    public void fontSetter(TextView textView)
    {
        if(context!=null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences
                    ("Settings", Context
                            .MODE_PRIVATE);
            if (textView != null) {
                if (sharedPreferences.getString("Font", "").equals("arcena")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/arcena.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("banffno")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/banffno.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("banglenormal")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/banglenormal.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("bauderiescriptssi")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/bauderiescriptssi.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("bookold")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/bookold.TTF");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("busorama")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/busorama.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("dauphinn")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/dauphinn.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("freehand")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/freehand.TTF");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("organo")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/organo.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("chiller")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/chiller.TTF");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("carpenterscript")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/carpenterscript.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("clairvauxroman")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/clairvauxroman.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("carpenterscript")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/carpenterscript.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("carpenterscript")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/carpenterscript.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("curlyq")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/curlyq.TTF");
                    textView.setTypeface(m);
                }
            }
        }
    }

    public void fontSetterRadioButton(RadioButton textView) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences
                    ("Settings", Context.MODE_PRIVATE);
            if (textView != null) {
                if (sharedPreferences.getString("Font", "").equals("arcena")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/arcena.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("banffno")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/banffno.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("banglenormal")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/banglenormal.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("bauderiescriptssi")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/bauderiescriptssi.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("bookold")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/bookold.TTF");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("busorama")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/busorama.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("dauphinn")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/dauphinn.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("organo")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/organo.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("chiller")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/chiller.TTF");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("carpenterscript")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/carpenterscript.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("clairvauxroman")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/clairvauxroman.ttf");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("curlyq")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/curlyq.TTF");
                    textView.setTypeface(m);
                }
                if (sharedPreferences.getString("Font", "").equals("freehand")) {
                    Typeface m = Typeface.createFromAsset(context.getAssets(), "fonts/freehand.TTF");
                    textView.setTypeface(m);
                }
            }
        }
    }
}
