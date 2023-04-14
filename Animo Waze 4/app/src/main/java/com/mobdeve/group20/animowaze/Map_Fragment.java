package com.mobdeve.group20.animowaze;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class Map_Fragment extends Fragment {

    private final ArrayList<LatLng> dlsuBuildings = new ArrayList<>();
    private final ArrayList<LatLng> foodPlaces = new ArrayList<>();
    private final LatLng henrySy = new LatLng(14.56503, 120.9931);
    private final LatLng andrew = new LatLng(14.567178272467327, 120.99289288733337);
    private final LatLng jusAndJerrys = new LatLng(14.56590891281282, 120.99291800598445);
    private final LatLng bacsilog = new LatLng(14.566249161834014, 120.99252817687821);
    private GoogleMap gMap;
    public static Marker markerHenrySy;
    public static Marker markerAndrew;
    public static Marker markerJusAndJerrys;
    public static Marker markerBacsilog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map_,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.MY_MAP);
        dlsuBuildings.add(henrySy);
        dlsuBuildings.add(andrew);
        foodPlaces.add(jusAndJerrys);
        foodPlaces.add(bacsilog);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                    gMap = googleMap;

                    gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                        @Override
                        public void onMapClick(@NonNull LatLng latLng) {
                            //Creating Marker
                            MarkerOptions markerOptions = new MarkerOptions();
                            gMap.clear();
                            // Adds the Markers on the map for DLSU Buildings
                            for (int i = 0; i < dlsuBuildings.size(); i++){
                                if (dlsuBuildings.get(i) == henrySy){
                                    markerHenrySy = gMap.addMarker(markerOptions.position(dlsuBuildings.get(i)).title("DLSU Henry Sy, Sr. Hall"));
                                }

                                else{
                                    markerAndrew = gMap.addMarker(markerOptions.position(dlsuBuildings.get(i)).title("DLSU Br. Andrew Gonzalez Hall"));
                                }

                            }
                            // Adds the Markers on the map for Food Places.
                            for (int i = 0; i < foodPlaces.size(); i++){
                                if(foodPlaces.get(i) == jusAndJerrys){
                                    markerJusAndJerrys = gMap.addMarker(markerOptions.position(foodPlaces.get(i)).title("Jus & Jerry's EGI Taft"));
                                }

                                else{
                                    markerBacsilog = gMap.addMarker(markerOptions.position(foodPlaces.get(i)).title("Ate Rica's Bacsilog DLSU Branch"));
                                }

                            }
                            //Zoom the Marker
                            gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(henrySy, 18));
                            //Onclick Listener depending on the marker clicked by the user
                            gMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                @Override
                                public boolean onMarkerClick(@NonNull Marker marker) {
                                    if(marker.equals(markerHenrySy)){
                                        markerHenrySy.setTag(true);
                                        Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                                        startActivity(intent);
                                    }
                                    if(marker.equals(markerAndrew)){
                                        markerAndrew.setTag(true);
                                        Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                                        startActivity(intent);
                                    }
                                    if(marker.equals(markerJusAndJerrys)){
                                        markerJusAndJerrys.setTag(true);
                                        Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                                        startActivity(intent);
                                    }
                                    if(marker.equals(markerBacsilog)){
                                        markerBacsilog.setTag(true);
                                        Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                                        startActivity(intent);
                                    }
                                    return false;
                                }
                            });
                        }
                    });
                }
            });
        }
        // Inflate the layout for this fragment
        return view;
    }
}