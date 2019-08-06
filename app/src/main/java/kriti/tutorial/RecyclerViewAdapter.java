package kriti.tutorial;

/**
 * Created by kirti on 12/28/2018.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ClubViewHolder>{
    List<Clubs> clubs;

    RecyclerViewAdapter(List<Clubs> clubs){
        this.clubs=clubs;

    }
    public static class ClubViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        TextView textView;
        ImageView imageView;


        public ClubViewHolder(View itemView)
        {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardno1);
            textView = (TextView)itemView.findViewById((R.id.cardtv));
            imageView = (ImageView )itemView.findViewById(R.id.cardimg);
        }
    }


    @Override
    public RecyclerViewAdapter.ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card, parent,false);
        ClubViewHolder clubViewHolder = new ClubViewHolder(view);
        return clubViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ClubViewHolder holder, int position) {
        holder.textView.setText(clubs.get(position).text_info);
        holder.imageView.setImageResource(clubs.get(position).image_id);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {

        return clubs.size();

    }
}

