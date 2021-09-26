package com.example.chandan.weatherappintermediate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chandan on 24-06-2017.
 */

public class FrontDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("About");
        b.setMessage("A simple Weather App designed for getting temperature and other details " +
                "like pressure,wind speed,rain, etc from all over the world. The forecast is given for the current day and for next 15 days");
        Dialog d = b.create();
        return d;
    }
}
