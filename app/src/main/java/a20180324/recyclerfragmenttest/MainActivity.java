package a20180324.recyclerfragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "---MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.recycler_container);
        Log.e(TAG, "fragment:"+fragment);
        if(fragment==null){
            fragment = new xxxFragment();
            fm.beginTransaction()
                    .add(R.id.recycler_container,fragment)
                    .commit();

        }

    }
}
