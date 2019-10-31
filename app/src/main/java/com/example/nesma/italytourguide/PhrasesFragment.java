package com.example.nesma.italytourguide;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {
    static MediaPlayer media;
    private AudioManager mAudioManager;

    public PhrasesFragment() {
        // Required empty public constructor
    }

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                media.pause();
                media.seekTo(0);

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                media.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourguide_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        //Create ArrayList and store the data on it
        final ArrayList<TourGuide> tourGuides = new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.phrases_bonjour), getString(R.string.phrases_italy_bonjour), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_bonjour));
        tourGuides.add(new TourGuide(getString(R.string.phrases_goodbye), getString(R.string.phrases_italy_goodbye), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_goodbye));
        tourGuides.add(new TourGuide(getString(R.string.phrases_Can_you_speak_English), getString(R.string.phrases_italy_Can_you_speak_English), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_can_you_speak_english));
        tourGuides.add(new TourGuide(getString(R.string.phrases_thank_you), getString(R.string.phrases_italy_thank_you), R.drawable.ic_play_circle_filled_black_24dp, R.raw.pheases_thankyou));
        tourGuides.add(new TourGuide(getString(R.string.phrases_my_name_is), getString(R.string.phrases_italy_my_name_is), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_my_name_is));
        tourGuides.add(new TourGuide(getString(R.string.phrases_Im_lost), getString(R.string.phrases_italy_Im_lost), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_im_sorry));
        tourGuides.add(new TourGuide(getString(R.string.phrases_what_is_your_name), getString(R.string.phrases_italy_what_is_your_name), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_what_is_your_name));
        tourGuides.add(new TourGuide(getString(R.string.phrases_Where_is_the_bathroom), getString(R.string.phrases_italy_Where_is_the_bathroom), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_where_is_the_bathroom));
        tourGuides.add(new TourGuide(getString(R.string.phrases_Help), getString(R.string.phrases_italy_Help), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_help));
        tourGuides.add(new TourGuide(getString(R.string.phrases_please), getString(R.string.phrases_italy_please), R.drawable.ic_play_circle_filled_black_24dp, R.raw.phrases_please));


        PhrasesAdapter adapter = new PhrasesAdapter(getActivity(), tourGuides, R.color.background);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                TourGuide word=tourGuides.get(position);
                releaseMediaPlayer();
                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    media = MediaPlayer.create(getActivity(), word.getAudioResource());
                    // Start the audio file
                    media.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
        return  rootView;
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null) {

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            media.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}

