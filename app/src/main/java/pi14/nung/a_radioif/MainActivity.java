package pi14.nung.a_radioif;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://radio.goha.ru:8000/grind.fm";

        getFragmentManager().beginTransaction().replace(R.id.frame_layout, PlayerFragment.newInstance(url), "Player").commit();
    }
}
