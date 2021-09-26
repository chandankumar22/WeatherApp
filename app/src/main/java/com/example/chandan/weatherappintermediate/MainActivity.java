package com.example.chandan.weatherappintermediate;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
//import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    static ViewPager vp;
    static Toolbar toolbar;
    ArrayList<String> searchedLocations = new ArrayList<>();
    static DrawerLayout drawer;
    static ActionBarDrawerToggle a;
    String name;
    static ImageView main;
    static String fname;
    SharedPreferences s;
    NavigationView navigation;
    Menu menuItem;
    String resName = "";
    SharedPreferences.Editor editor;

    int menuSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        s = getSharedPreferences("Location", MODE_PRIVATE);
        if (!s.contains("defaultLocation")) {
            SharedPreferences.Editor e = s.edit();
            e.putString("defaultLocation", "Delhi");
            e.apply();
        }


        editor = s.edit();
        editor.apply();

        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Weather");
        fname = s.getString("defaultLocation", "");
        Log.d("Inside oncreateelse", "Main layout created.setting viewpager");
        vp = (ViewPager) findViewById(R.id.vpid);
        final FragmentManager f = getSupportFragmentManager();
        vp.setAdapter(new FragmentAdapter(f, this));
        Log.d("Inside oncreateelse", "viewpagerset");

        main = (ImageView) findViewById(R.id.main);
        drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        Log.d("dis", "" + drawer);
        a = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string
                .drawer_close);
        drawer.addDrawerListener(a);
        navigation = (NavigationView) findViewById(R.id.navigationview);

        menuItem = navigation.getMenu();
        menuSize = menuItem.size();
        Log.d("menusizeis", menuItem.size() + "");
        Log.d("preferencefilesizeiis", s.getAll().size() + "");

        for (int i = menuItem.size(); i < menuSize + (s.getAll().size() - 1); i++) {
            Log.d("ontopofoncreateat", i + s.getString(i + "", "") + "");
            menuItem.add(s.getString(i + "", "") + "");
        }
        menuSize = menuItem.size();
        Log.d("menusizeafteraddingis", menuSize + "");
        Log.d("preffileaftersizeiis", s.getAll().size() + "");
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.settingsid) {
                    if (item.getItemId() == R.id.settingsid) {
                        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("size", menuItem.size());
                        i.putExtras(b);
                        startActivity(i);

                    }
                } else if (item.getItemId() == R.id.aboutid) {
                    FrontDialog d = new FrontDialog();
                    d.show(getFragmentManager(), "AboutDialog");
                    d.setCancelable(true);
                } else if (item.getItemId() == R.id.RateItid) {
                    Toast.makeText(MainActivity.this, "App is not in the PlayStore!!", Toast
                            .LENGTH_SHORT)
                            .show();
                } else {
                    String name = item.getTitle().toString();
                    if (name.equals("Recent Locations")) {
                    } else new MainPage().connectToNetwork(name);
                }

                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(resName)) {
            Log.d("onRestart", resName);
            new MainPage().connectToNetwork(resName);
        }
       /* if(menuItem.size()>4)
        {int s =  menuItem.size();
            for(int i=4;i<s;i++)
            {
                Log.d("removed",navigation.getMenu().getItem(i)+"");
                menuItem.removeItem(i);
                Log.d("size",navigation.getMenu().size()+"");

            }
        }*/

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("OnPost called", "actionbartoggler is" + a);
        a.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("oncreateoptionsmenu", "called");
        getMenuInflater().inflate(R.menu.menu_items, menu);
        //Retrive menu item by id
        MenuItem menuItem = menu.findItem(R.id.search);
        //
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(this);

        Log.d("enteredvalueis", "" + searchView.getQuery().toString());

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.setAsDefault) {
            String name = MainPage.location.getText().toString();
            editor.putString("defaultLocation", name);
            editor.apply();
            Toast.makeText(this, name + " set as default location", Toast.LENGTH_SHORT).show();

        }
        if (item.getItemId() == R.id.search) {

        }
        if (item.getItemId() == R.id.refresh) {
            new MainPage().connectToNetwork(MainPage.location.getText().toString());
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        name = query;
        new MainPage().connectToNetwork(name);
        menuItem.add(name);
        Log.d("itemaddedsizeisnow", menuItem.size() + "");
        searchedLocations.add(name);
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (MainPage.location != null) {
            resName = MainPage.location.getText().toString();
            outState.putString("Location name", MainPage.location.getText().toString());
            Log.d("onstateresaveswith", MainPage.location.getText().toString());
        }
    }


    @Override
    protected void onStop() {
        super.onStop();

        for (int i = menuSize; i < menuItem.size(); i++) {
            Log.d("menusizeisbeforeput", menuSize + "");
            Log.d("menusizeafteradd", menuItem.size() + "");
            Log.d("preferencefilesizeiis", s.getAll().size() + "");
            Log.d("onStopCalled", "item at " + i + "is " + menuItem.getItem(i));
            editor.putString(i + "", menuItem.getItem(i) + "");
            editor.apply();
        }
        for (int i = menuItem.size(); i < s.getAll().size(); i++) {
            Log.d("menusizeafteris", menuItem.size() + "");
            Log.d("preferencefilesizeiis", s.getAll().size() + "");
            Log.d("retrieved value is", s.getString(i + "", "") + "");
        }
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public void yahaao(RecyclerView rc, ArrayList<FutureTempData> a) {

    }


}



