package com.example.nesma.italytourguide;


import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourGuideAdapter extends ArrayAdapter<TourGuide> {
    private int mColorResource;

    public TourGuideAdapter(Activity context, ArrayList<TourGuide> tourGuide,int colorResource) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, tourGuide);
        mColorResource=colorResource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link tourguide place name like(restaurant,hotel,place)} object located at this position in the list
        TourGuide tourGuideName = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView TourGuideTextView = (TextView) listItemView.findViewById(R.id.place_name_text_view);
        TourGuideTextView.setText(tourGuideName.getName());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressNameTextView = (TextView) listItemView.findViewById(R.id.address_name_text_view);
        // Get the version number from the current address Name object and
        // set this text on the number TextView
        addressNameTextView.setText(tourGuideName.getAddress());

        // Find the imageView in the list_item.xml layout with the ID version_number
        ImageView TourGuideImageView = (ImageView) listItemView.findViewById(R.id.place_image_view);
        TourGuideImageView.setImageResource(tourGuideName.getImageResource());

        View textContainer=listItemView.findViewById(R.id.textContainer);
        int color= ContextCompat.getColor(getContext(),mColorResource);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
