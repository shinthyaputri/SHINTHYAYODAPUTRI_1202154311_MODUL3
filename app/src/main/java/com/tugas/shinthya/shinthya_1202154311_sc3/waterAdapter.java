package com.tugas.shinthya.shinthya_1202154311_sc3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


//membuat adapter dengan viewHolder
public class waterAdapter extends RecyclerView.Adapter<waterAdapter.WaterViewHolder> {

    //mendeklarasikan arraylist kedalam mWaterData
    private ArrayList<water> mWaterData;
    private Context context;

    public waterAdapter(Context context, ArrayList<water> waters) {
        this.context = context;
        mWaterData = waters;
    }

    //membuat adapter ketika di create akan ke layout list item
    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    //membuat posisi
    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {
        water currentWater = mWaterData.get(position);
        holder.bindTo(currentWater);
    }

    @Override
    public int getItemCount() {
        return mWaterData.size();
    }

    //membuat agar menu water ada title,deskripsi, image dengan memanggil id masing-masing
    class WaterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitle, mDescription;
        ImageView mWatersImage;
        public WaterViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.subTitle);
            mWatersImage = itemView.findViewById(R.id.watersImage);
            itemView.setOnClickListener(this);
        }

        void bindTo(water currentWater) {
            //melakukan set text title
            mTitle.setText(currentWater.getTitle());
            //melakukan set text description
            mDescription.setText(currentWater.getDescpription());
            //melakukan set image
            mWatersImage.setImageResource(currentWater.getImage());
        }

        //membuat agar ketika di klik akan menyesuaikan posisi
        @Override
        public void onClick(View view) {
            water currentWater = mWaterData.get(getAdapterPosition());

            //kemudian muncul dengan memanggil class DetailActivity
            Intent intent = new Intent(context, DetailActivity.class);
            //dengan memanggil title yaang sudah dibuat dengan getTitle
            intent.putExtra("title", currentWater.getTitle());
            //dengan memanggil gambar yaang sudah dibuat dengan getImage
            intent.putExtra("image", currentWater.getImage());
            //dengan memanggil detail yaang sudah dibuat dengan getDetail
            intent.putExtra("detail", currentWater.getDetail());
            //kemudian melakukan staractivity
            context.startActivity(intent);

        }
    }
}