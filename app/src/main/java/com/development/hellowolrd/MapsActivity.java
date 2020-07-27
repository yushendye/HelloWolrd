package com.development.hellowolrd;

import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        personList = new ArrayList<>();

        try {
            Resources resources = getResources();
            InputStream inputStream = resources.openRawResource(R.raw.mock);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){
                String line = reader.readLine();
                String[] data = line.split(",");
                Person p = new Person();

                if(data[4].equals("lat"))
                    continue;
                p.setId(data[0]);
                p.setFirst_name(data[1]);
                p.setLast_name(data[2]);
                p.setGender(data[3]);
                p.setLat(Double.parseDouble(data[4]));
                p.setLon(Double.parseDouble(data[5]));

                personList.add(p);
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

    }

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

        for (int i = 0; i < personList.size(); i++){
            Person person = personList.get(i);
            double lat = person.getLat();
            double lon = person.getLon();
            String gen = person.getGender();
            LatLng position = new LatLng(lat, lon);

            if(gen.equals("Male"))
                mMap.addMarker(new MarkerOptions().position(position).title(person.getFirst_name() + " " + person.getLast_name()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            else
                mMap.addMarker(new MarkerOptions().position(position).title(person.getFirst_name() + " " + person.getLast_name()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
    }
}