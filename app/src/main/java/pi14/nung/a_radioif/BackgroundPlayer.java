package pi14.nung.a_radioif;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

import pi14.nung.a_radioif.realisations.StreamRadioPlayer;

public class BackgroundPlayer extends Service {

    // Our player
    private StreamRadioPlayer player;

    public BackgroundPlayer(StreamRadioPlayer player) {
        this.player = player;
    }

    public BackgroundPlayer(){}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onStart(Intent intent, int startId) {
        player.play();
    }

    @Override
    public void onDestroy() {
        player.pause();
    }
}
