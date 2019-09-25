package com.albert.musiclive;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PlaySongActivity extends AppCompatActivity implements MediaPlayer.OnBufferingUpdateListener,MediaPlayer.OnCompletionListener{

    private ImageButton btn_play_pause;
    private ImageButton btn_play_prev;
    private ImageButton btn_play_next;
    private TextView tvTimer;
    private SeekBar seekBar;

    private MediaPlayer mediaPlayer;

    private int mediaFileLength;
    private int realTimeLength;
    String songLink;
    final Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        Intent i = getIntent();
         songLink = i.getStringExtra("songLink");
        btn_play_prev = (ImageButton)findViewById(R.id.btn_play_prev);
        btn_play_pause = (ImageButton)findViewById(R.id.btn_play_pause);
        btn_play_next = (ImageButton) findViewById(R.id.btn_play_next);

       tvTimer = findViewById(R.id.tvTimer);
       seekBar = findViewById(R.id.seek_bar);
       seekBar.setMax(99);// 100% (0~99)
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(mediaPlayer.isPlaying()){
                    SeekBar seekBar1 = (SeekBar)v;
                    int playPosition = (mediaFileLength/100)*seekBar1.getProgress();
                    mediaPlayer.seekTo(playPosition);
                }
                return false;
            }
        });

        btn_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(PlaySongActivity.this);

                AsyncTask<String,String,String> mp3Play = new AsyncTask<String, String, String>() {

                    @Override
                    protected void onPreExecute() {
                        mDialog.setMessage("Please Wait...");
                        mDialog.show();
                    }

                    @Override
                    protected String doInBackground(String... strings) {

                        try{
                            mediaPlayer.setDataSource(strings[0]);
                            mediaPlayer.prepare();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return "";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        mediaFileLength = mediaPlayer.getDuration();
                        realTimeLength = mediaFileLength;
                        if(!mediaPlayer.isPlaying()){
                            mediaPlayer.start();
                            btn_play_pause.setImageResource(R.drawable.ic_pause);

                        }else{
                            mediaPlayer.pause();
                            btn_play_pause.setImageResource(R.drawable.ic_play);
                        }

                        updateSeekBar();
                        mDialog.dismiss();
                        

                    }
                };
                mp3Play.execute(songLink);
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnCompletionListener(this);
    }

    private void updateSeekBar() {

        seekBar.setProgress((int) (((float)mediaPlayer.getCurrentPosition()/mediaFileLength)*100));
        if(mediaPlayer.isPlaying()){

            Runnable updater = new Runnable() {
                @Override
                public void run() {
                    updateSeekBar();
                    realTimeLength-=1000;// declare 1 secondes
                    tvTimer.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(realTimeLength),
                            TimeUnit.MILLISECONDS.toSeconds(realTimeLength)-
                                    TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes(realTimeLength))));
                }
            };
            handler.postDelayed(updater,1000);
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        seekBar.setSecondaryProgress(percent);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
            btn_play_pause.setImageResource(R.drawable.ic_play);
    }
}
