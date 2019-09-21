package com.albert.musiclive;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.albert.musiclive.models.Artist;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistAdapterViewHolder> {

    Context context;
    List<Artist> artistList;

    public ArtistAdapter(Context context,  List<Artist> artistList){
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public ArtistAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.artist_item,viewGroup,false);
        return new ArtistAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapterViewHolder holder, int i) {
            final Artist artist = artistList.get(i);
          //  holder.tvNameArtist.setText(artist.getName());
           // holder.tvNbreAbon.setText(artist.getNbreAbon());
            /*holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent i = new Intent(context,)
                    Toast.makeText(context, artist.getName(), Toast.LENGTH_SHORT).show();
                }
            });*/
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ArtistAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tvNameArtist, tvNbreAbon;
     // LinearLayout container;
        public ArtistAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
           // tvNameArtist = itemView.findViewById(R.id.tvNameArtist);
            //tvNbreAbon = itemView.findViewById(R.id.tvNbrAbon);
            //container = itemView.findViewById(R.id.container);
        }
    }
}
