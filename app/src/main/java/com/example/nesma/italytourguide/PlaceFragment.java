package com.example.nesma.italytourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {


    public PlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourguide_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        final ArrayList<TourGuide> tourGuides=new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.place_amalifi_coast),getString(R.string.address_amalfi_coast),R.drawable.amalfi_coast));
        tourGuides.add(new TourGuide(getString(R.string.place_capri),getString(R.string.address_capri),R.drawable.capri));
        tourGuides.add(new TourGuide(getString(R.string.place_cinque_terre),getString(R.string.address_cinque_terre),R.drawable.icinque_terre));
        tourGuides.add(new TourGuide(getString(R.string.place_colosseum),getString(R.string.address_colosseum),R.drawable.colosseum));
        tourGuides.add(new TourGuide(getString(R.string.place_florence_duomo),getString(R.string.address_forence_diomo),R.drawable.florence_duomo));
        tourGuides.add(new TourGuide(getString(R.string.place_lake_como),getString(R.string.address_lake_como),R.drawable.lake_como));
        tourGuides.add(new TourGuide(getString(R.string.place_leaning_tower_of_pisa),getString(R.string.address_leaning_tower_of_pisa),R.drawable.leaning_tower_of_pisa));
        tourGuides.add(new TourGuide(getString(R.string.place_pompeii),getString(R.string.address_pompeii),R.drawable.pompeii));
        tourGuides.add(new TourGuide(getString(R.string.place_vatican_city),getString(R.string.address_vatican),R.drawable.vatican_city));
        tourGuides.add(new TourGuide(getString(R.string.place_venice_canals),getString(R.string.address_venice_canals),R.drawable.venice_canals));


        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuides, R.color.background);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;

    }

}
