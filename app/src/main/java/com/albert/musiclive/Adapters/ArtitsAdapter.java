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
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.tools.Serializer;

import java.util.List;

public class ArtitsAdapter extends RecyclerView.Adapter<ArtitsAdapter.ViewHolder>{

    private Context context;
    private List<Artist> posts;

    public ArtitsAdapter(Context context, List<Artist> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.artist_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Artist post = posts.get(i);
        viewHolder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

            private TextView tvHandle;
            private ImageButton ivImage;
            private TextView tvDescription;
            private LinearLayout container;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvHandle = itemView.findViewById(R.id.tvHandle);
                ivImage = itemView.findViewById(R.id.ivImage);
                tvDescription = itemView.findViewById(R.id.tvDescription);
                container=itemView.findViewById(R.id.container);
            }

            public void bind(final Artist artist){

                tvHandle.setText(artist.getName());
                /*ParseFile image = post.getImage();
                if(image!=null)
                {
                    Glide.with(context).load(image.getUrl()).into(ivImage);
                }*/
                tvDescription.setText(artist.getNbreAbon());
                container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Artist artist1 =(Artist) Serializer.deSerialize("artist",context);
                        //Toast.makeText(context, artist1.getArtistId(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context, Main2Activity.class);
                        i.putExtra("artistId",artist.getArtistId());
                        context.startActivity(i);
                    }
                });
            }
        }
}
