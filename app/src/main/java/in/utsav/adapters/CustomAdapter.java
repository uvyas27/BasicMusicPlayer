package in.utsav.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.utsav.basicmusicplayer.DetailActivity;
import in.utsav.basicmusicplayer.MainActivity;
import in.utsav.basicmusicplayer.R;
import in.utsav.model.Music;

/**
 * Created by hp on 19-07-16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    ArrayList<Music> musicList;
    Context context;
    public CustomAdapter(ArrayList<Music> musicList,Context context){
        this.musicList = musicList;
        this.context = context;
    }

    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        CustomViewHolder cv = new CustomViewHolder(v);
        return cv;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.CustomViewHolder holder, int position)
    {
        holder.musicTitle.setText(musicList.get(position).getMusicTitle());
        holder.musicSinger.setText(musicList.get(position).getMusicSinger());
        holder.photo.setImageResource(musicList.get(position).getPhotoId());
        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Music musicObj = musicList.get(holder.getAdapterPosition());
                String title = musicObj.getMusicTitle();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("songLyrics",musicObj.getMusicLyrics());
                intent.putExtra("songId",musicObj.getSongId());
                context.startActivity(intent);


            }

        });
    }

    @Override
    public int getItemCount()
    {
        return musicList.size();
    }

    public  class CustomViewHolder extends  RecyclerView.ViewHolder{
        TextView  musicTitle;
        TextView  musicSinger;
        CardView  cardView;
        ImageView photo;
        CustomViewHolder(View itemView){
            super(itemView);

            musicTitle = (TextView)itemView.findViewById(R.id.musicTitle);
            musicSinger = (TextView)itemView.findViewById(R.id.musicSinger);
            cardView = (CardView)itemView.findViewById(R.id.cardview);
            photo = (ImageView)itemView.findViewById(R.id.photo);
        }
    }
}
