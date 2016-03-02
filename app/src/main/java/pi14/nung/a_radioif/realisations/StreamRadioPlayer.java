package pi14.nung.a_radioif.realisations;

import android.app.Activity;
import android.app.FragmentManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import pi14.nung.a_radioif.dialogs.BufferingDialogFragment;
import pi14.nung.a_radioif.interfaces.Playable;

/**
 * Created by Богдан on 28.02.2016.
 */
public class StreamRadioPlayer implements Playable {

    // MediaPlayer which plays a music from stream
    private MediaPlayer mediaPlayer;

    // Url of station
    private String stationURL;


    /**
     * Use this method to create an instance of {@link StreamRadioPlayer}
     *
     * @param stationURL URL of station.
     * @throws IOException
     */
    public StreamRadioPlayer(String stationURL) throws IOException {
        this.stationURL = stationURL;
        mediaPlayer = createPlayer(stationURL);
    }


    /**
     * Use this method to set your instance of {@Link MediaPlayer}.
     *
     * @param mediaPlayer your instance of {@Link MediaPlayer}.
     */
    @Override
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    /**
     * Use this method to set a station.
     *
     * @param url
     * @throws IOException
     */
    @Override
    public void setStation(String url) throws IOException {
        mediaPlayer.setDataSource(url);
    }

    /**
     * Use this method to start playing.
     */
    @Override
    public void play() {
        mediaPlayer.start();
    }

    /**
     * Use this method to pause playing.
     */
    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    /**
     * Use this method to stop player.
     */
    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    /**
     * Use this method to prepare your player.
     *
     * @param fragmentManager
     */
    public void prepare(FragmentManager fragmentManager) {
        final BufferingDialogFragment dialogFragment = new BufferingDialogFragment();
        dialogFragment.show(fragmentManager, "BufferingDialog");
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                dialogFragment.dismiss();
            }
        });
        mediaPlayer.prepareAsync();
    }


    /**
     * Use this method to create an instance of {@link MediaPlayer}.
     *
     * @param url URL of station.
     * @return
     * @throws IOException
     */
    private MediaPlayer createPlayer(String url) throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(url);
        return mediaPlayer;
    }

}
