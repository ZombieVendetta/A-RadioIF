package pi14.nung.a_radioif.interfaces;

import android.app.FragmentManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Bogdan Shvets on 28.02.2016.
 *
 * Interface that represents a structure of player.
 */
public interface Playable {


    /**
     * Use this method to set your instance of {@Link MediaPlayer}.
     * @param mediaPlayer your instance of {@Link MediaPlayer}.
     */
    void setMediaPlayer(MediaPlayer mediaPlayer);


    /**
     * Use this method to set a station.
     *
     * @param url
     * @throws IOException
     */
    void setStation(String url) throws IOException;


    /**
     * Use this method to start playing.
     */
    void play();


    /**
     * Use this method to pause playing.
     */
    void pause();


    /**
     * Use this method to stop player.
     */
    void stop();


    /**
     * Use this method to prepare your player.
     *
     * @param fragmentManager
     */
    void prepare(FragmentManager fragmentManager);

}
