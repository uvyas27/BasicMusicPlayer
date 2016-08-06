package in.utsav.basicmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import in.utsav.adapters.CustomAdapter;
import in.utsav.model.MusicArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerview);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setAdapter(new CustomAdapter(new MusicArray().musicObjectsList,this));
    }


}
