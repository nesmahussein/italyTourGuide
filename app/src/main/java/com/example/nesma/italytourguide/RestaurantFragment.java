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
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tourguide_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        final ArrayList<TourGuide> tourGuides=new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.restaurant_acquolina),getString(R.string.phone_via_del_vantagglo),R.drawable.acquolina));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_alle_testiere),getString(R.string.phone_da_vittorio),R.drawable.alle_testiere));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_club_del_doge_restaurant),getString(R.string.phone_club_del_doge),R.drawable.club_del_dog_restaurant));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_da_vittorio_brusaporto),getString(R.string.phone_ristoranta_la_sponda),R.drawable.da_vittorio_brusaporto));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_dal_pescatore_runate),getString(R.string.phone_dal_pescatore),R.drawable.dal_pescatore_runate));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_ii_pelicano),getString(R.string.phone_ll_pelicano),R.drawable.pellicano));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_RATANA_MILAN),getString(R.string.phone_ratana_millan),R.drawable.ratana_milan));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_RISTORANTE_LA_SPONDA),getString(R.string.phone_ristoranta_la_sponda),R.drawable.ristorante_la_sponda));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_la_pergola_Roma),getString(R.string.phone_la_pergola),R.drawable.la_pergola_rome));
        tourGuides.add(new TourGuide(getString(R.string.restaurant_la_rosetta),getString(R.string.phone_la_rosetta),R.drawable.la_rosetta));


        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuides, R.color.background);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;

    }

}
