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
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourguide_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        final ArrayList<TourGuide> tourGuides=new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.hotel_compo_de_fiori),getString(R.string.phone_Compo),R.drawable.hotels_rome_campo_de_fiori));
        tourGuides.add(new TourGuide(getString(R.string.hotel_de_russia),getString(R.string.phone_de_russia),R.drawable.rome_de_russie));
        tourGuides.add(new TourGuide(getString(R.string.hotel_eden_hotel),getString(R.string.phone_eden),R.drawable.hotels_rome_eden));
        tourGuides.add(new TourGuide(getString(R.string.hotel_hassier),getString(R.string.phone_hassier),R.drawable.grand_hotel_minerva));
        tourGuides.add(new TourGuide(getString(R.string.hotel_grand_de_la_minerue),getString(R.string.phone_grand_de_la_minerue),R.drawable.grand_hotel_majestic));
        tourGuides.add(new TourGuide(getString(R.string.hotel_modestic_roma),getString(R.string.phone_modestic_roma),R.drawable.rome_st_regis));
        tourGuides.add(new TourGuide(getString(R.string.hotel_vila_spalletti_traivelli),getString(R.string.phone_Vila_Spalletti),R.drawable.villa_rome_spalleti));
        tourGuides.add(new TourGuide(getString(R.string.hotel_parco_del_principi_grand),getString(R.string.phone_parco_del_principi_grand),R.drawable.rome_parco_dei_principi));
        tourGuides.add(new TourGuide(getString(R.string.hotel_raphael),getString(R.string.phone_raphael),R.drawable.hotels_rome_raphael));
        tourGuides.add(new TourGuide(getString(R.string.hotel_inn_at_roman_forum),getString(R.string.hotel_inn_at_roman_forum),R.drawable.inn_at_the_roman_forum));


        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuides, R.color.background);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;

    }

}
