package com.example.nesma.italytourguide;


public class TourGuide {
    String name;
    String address;
    int imageResource=NO_IMAGE_RESOURCE;
    int audioImageResource;
    int audioResource;
    private static final int NO_IMAGE_RESOURCE=-1;

    TourGuide(String tName,String tAddress,int tImageResource){
        name=tName;
        address=tAddress;
        imageResource=tImageResource;
    }

    TourGuide(String tName,String tAddress,int tAudioImageResource,int tAudioResource){
        name=tName;
        address=tAddress;
        audioImageResource=tAudioImageResource;
        audioResource=tAudioResource;


    }
    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getImageResource(){
        return imageResource;
    }


    public int getAudioResource(){
        return audioResource;
    }


}
