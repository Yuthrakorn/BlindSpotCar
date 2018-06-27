package com.example.yuthrakorn.blindspotcar;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;



public class blindspotMap extends FragmentActivity implements OnMapReadyCallback {

   // FirebaseDatabase database;
   // DatabaseReference mSensor;
    private GoogleMap mMap;
    Context context;
    Global gb;

    //=======================================================================================
    //TEST
    //==========================================================================================
   // private FirebaseDatabase mSensor;
  //  public FirebaseDatabase firebaseDatabase;
  //  public DatabaseReference databaseReference_sensor;
  //  private static final String TAG = "https://blindspotcar-8fc56.firebaseio.com/";
  //  private LinearLayout ledLR;
  //  public Integer value,value_refer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

     //   database = FirebaseDatabase.getInstance();
     //   mSensor = database.getReference("sensor1");
     //   readFromDatabase();

        gb = Global.getInstance();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindowManager().getDefaultDisplay().getMetrics(gb.getDisplayMetrics());
        gb.initialResolution();



      //  ledLR = (LinearLayout) findViewById(R.id.ledLF);
        // FirebaseApp.initializeApp(this);
      //  FirebaseDatabase database = FirebaseDatabase.getInstance();
      //  final DatabaseReference databaseReference_sensor = database.getReference("SENSOR1");
     //databaseReference_sensor = firebaseDatabase.getReference("SENSOR1");


        //Fragment fragment = findViewById(R.layout.activity_blindspot_map);
        //View fragment = inflater.inflate(R.layout.selector, container, false);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //======================================================================================
        LinearLayout.LayoutParams map_view_size =
                new LinearLayout.LayoutParams(
                        gb.MATCH_PARENT,
                        gb.displayHeight(30));

        LinearLayout.LayoutParams sensor_view_size =
                new LinearLayout.LayoutParams(
                        gb.MATCH_PARENT,
                        gb.displayHeight(70));

        LinearLayout.LayoutParams car_view_size =
                new LinearLayout.LayoutParams(
                        gb.displayWidth(70),
                        gb.MATCH_PARENT);

        LinearLayout.LayoutParams led_size =
                new LinearLayout.LayoutParams(
                        gb.displayWidth(15),
                        gb.displayHeight(35));

        LinearLayout map_view = (LinearLayout) findViewById(R.id.mapView);
        LinearLayout sensor_view = (LinearLayout) findViewById(R.id.sensorView);
        map_view.setLayoutParams(map_view_size);
        sensor_view.setLayoutParams(sensor_view_size);

        final LinearLayout ledLF = (LinearLayout) findViewById(R.id.ledLF);
        LinearLayout ledLR = (LinearLayout) findViewById(R.id.ledLR);
        LinearLayout ledRF = (LinearLayout) findViewById(R.id.ledRF);
        LinearLayout ledRR = (LinearLayout) findViewById(R.id.ledRR);
        LinearLayout carView = (LinearLayout) findViewById(R.id.carView);

        carView.setBackgroundResource(R.drawable.mini_top_view);
        carView.setLayoutParams(car_view_size);
        ledLF.setLayoutParams(led_size);
        ledLR.setLayoutParams(led_size);
        ledRF.setLayoutParams(led_size);
        ledRR.setLayoutParams(led_size);

        ledLF.setBackgroundColor(Color.LTGRAY);
        ledLR.setBackgroundColor(Color.LTGRAY);
        ledRF.setBackgroundColor(Color.LTGRAY);
        ledRR.setBackgroundColor(Color.LTGRAY);


    }
    /*public void readFromDatabase() {
        // Read from the database
        mSensor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.v("sensor", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.v("sensor", "Failed to read value.", error.toException());
            }
        });
    }*/



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng mylocation = new LatLng(13.819552, 100.514812);
        mMap.addMarker(new MarkerOptions().position(mylocation).title("MY LOCATION"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylocation));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mylocation,30), 3000, null);


    }

}
