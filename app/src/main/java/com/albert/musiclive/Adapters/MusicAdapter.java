package com.albert.musiclive.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.albert.musiclive.Main2Activity;
import com.albert.musiclive.PlaySongActivity;
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.models.Song;

import org.parceler.Parcels;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{

    private Context context;
    private final  List<Song> songs;

    public MusicAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.music_item,viewGroup,false);
        return new MusicAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder viewHolder, int i) {

        Song song = songs.get(i);
        viewHolder.bind(song);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private ImageButton ivImage;
        private TextView tvLikeCount;
        private LinearLayout containerMusic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvLikeCount = itemView.findViewById(R.id.tvLikeCount);
            containerMusic=itemView.findViewById(R.id.containerMusic);
        }

        public void bind(final Song song){

            tvTitle.setText(song.getTitle());
                /*ParseFile image = post.getImage();
                if(image!=null)
                {
                    Glide.with(context).load(image.getUrl()).into(ivImage);
                }*/
            tvLikeCount.setText(song.getLikesCount());
            containerMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(context, song.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, PlaySongActivity.class);
                   // i.putExtra("fragmentName","playsong");
                    i.putExtra("songLink",song.getSongLink());
                    i.putExtra("title",song.getTitle());
                    i.putExtra("musicId", song.getSongId());
                   // i.getCharSequenceArrayListExtra("listSong",songs);
                   // i.putArrayListExtra("listSong",songs);
                   // i.putExtra("song", Parcels.wrap(song));
                    context.startActivity(i);
                }
            });
        }
    }
}
