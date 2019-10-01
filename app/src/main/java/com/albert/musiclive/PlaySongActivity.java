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
import android.widget.Toast;

import com.albert.musiclive.models.PlayList;
import com.albert.musiclive.models.Song;
import com.albert.musiclive.models.User;
import com.albert.musiclive.tools.Serializer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PlaySongActivity extends AppCompatActivity implements MediaPlayer.OnBufferingUpdateListener,MediaPlayer.OnCompletionListener{
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_playlist = database.getReference("PlayLists");
    private ImageButton btn_play_pause;
    private ImageButton btn_play_prev;
    private ImageButton btn_play_next;
    private ImageButton btn_add_playlist;
    private TextView tvTimer;
    private TextView tvTitle;
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
         String title = i.getStringExtra("title");
         final String music = i.getStringExtra("musicId");

       // final Song song = Parcels.unwrap(getIntent().getParcelableExtra("song"));
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        btn_play_prev = (ImageButton)findViewById(R.id.btn_play_prev);
        btn_play_pause = (ImageButton)findViewById(R.id.btn_play_pause);
        btn_play_next = (ImageButton) findViewById(R.id.btn_play_next);
        btn_add_playlist = (ImageButton) findViewById(R.id.ib_add_play_list);

        btn_add_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMusic(music);
            }
        });

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
                play(songLink);
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnCompletionListener(this);
    }

    public void play( String songLink){
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

    public void addMusic(final String musicId){

        final User user = (User) Serializer.deSerialize("saveUser",this);
        String playlistId = table_playlist.push().getKey();

            PlayList playList = new PlayList(musicId,user.getUserName());
            playList.setPlaylistId(playlistId);
            table_playlist.child(playlistId).setValue(playList);
            Toast.makeText(getApplicationContext(), "Successfuly added", Toast.LENGTH_SHORT).show();
            return;

        /*table_playlist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String playlistId = table_playlist.push().getKey();
                if(dataSnapshot.child(playlistId).exists()) {
                    Toast.makeText(getApplicationContext(), "Music already added", Toast.LENGTH_SHORT).show();
                }else
                {
                    PlayList playList = new PlayList(musicId,user.getUserName());
                    playList.setPlaylistId(playlistId);
                    table_playlist.child(playlistId).setValue(playList);
                    Toast.makeText(getApplicationContext(), "Successfuly added", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });*/



    }
}
