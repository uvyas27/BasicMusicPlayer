package in.utsav.basicmusicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.FileNotFoundException;


public class DetailActivity extends AppCompatActivity {

    boolean isSongPlaying;
    MediaPlayer mediaPlayer;
    Button playBtn;
    Thread thread;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle b = getIntent().getExtras();
        String song = b.getString("songLyrics");
        final int songId = b.getInt("songId");
        TextView v = (TextView)findViewById(R.id.songLyrics);
        v.setText(song);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        //MediaPlayer mediaPlayer = MediaPlayer.create(this, songId);
        //mediaPlayer.start();
        playBtn = (Button)findViewById(R.id.playButton);
        mediaPlayer = MediaPlayer.create(DetailActivity.this, songId);
        seekBar.setMax(mediaPlayer.getDuration());



        playSongOnClick();
        updateSeekBar();
        }

    private void updateSeekBar() {

        thread = new Thread() {
            @Override
            public void run() {
                int maxValue = mediaPlayer.getDuration();
                int minValue = 0;
                while (minValue < maxValue) {
                    try{
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                        minValue= mediaPlayer.getCurrentPosition();
                    }catch (Exception e){

                    }

                }
            }

        };
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

    }

    private void playSongOnClick() {

        playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (isSongPlaying){

                    mediaPlayer.pause();
                    playBtn.setText("Play");
                    isSongPlaying = !isSongPlaying;

                }
                else
                {

                    mediaPlayer.start();
                    try{
                        thread.start();


                    }catch (Exception e) {

                    }
                    playBtn.setText("Pause");
                    isSongPlaying = !isSongPlaying;

                }


            }

        });
    }
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

    }
}
