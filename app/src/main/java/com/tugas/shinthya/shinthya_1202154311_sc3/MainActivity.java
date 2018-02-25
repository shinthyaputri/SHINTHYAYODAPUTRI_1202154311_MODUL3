package com.tugas.shinthya.shinthya_1202154311_sc3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private ArrayList<water> mDataAir;
    private waterAdapter mWaterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memasukan data recyclerview kedalam method mRecycleView
        mRecycleView = findViewById(R.id.recyclerview);

        //membuat integer grid column count yang sebelumnya sudah dibuat di values > integer kemudian dipanggil pada MainActivity
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //melakukan setlayout
        mRecycleView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //membuat baru arrayList
        mDataAir = new ArrayList<>();

        //membuat baru adapter
        mWaterAdapter = new waterAdapter(this, mDataAir);

        //kemudian melakukan set adapter
        mRecycleView.setAdapter(mWaterAdapter);

        initializeData();
        // If there is more than one column, disable swipe to dismiss

        //membuat swipe pada menu water
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }


        //membuat menu agar ketika di touch bisa digerakan kesegala arah bisa kanan, kiri, atas, bawah
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mDataAir, from, to);
                mWaterAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mDataAir.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                mWaterAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecycleView);

    }

    private void initializeData() {

        TypedArray watersImageRes = getResources().obtainTypedArray(R.array.water_images);

        //Get the resources from the XML file
        String[] watersList = getResources().getStringArray(R.array.water_images);

        //Clear the existing data (to avoid duplication)
        mDataAir.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<watersList.length;i++){

            //membuat judul title pada menu
            String[] judul = {"AQUA", "ADES", "AMIDIS", "CLEO", "CLUB", "EQUIL",
                    "EVIAN", "LEMINERALE", "PRISTINE", "VIT", "NESTLE"};

            //membuat keterangan details ketika di klik gambar
            mDataAir.add(new water(judul[i], "Air minum merk "+judul[i], "Air mineral adalah air yang mengandung mineral atau bahan-bahan larut " +
                    "lain yang mengubah rasa atau memberi nilai-nilai terapi."+ "Banyak kandungan Garam, sulfur, dan gas-gas yang larut di dalam air ini."+"Air mineral biasanya masih memiliki buih. " +
                    "Air mineralbersumber dari mata air yang berada di alam."+"Di Indonesia, bisnis air mineral dimulai pada tahun 1973 dengan merek Aqua,bisnis tersebut didirikan oleh Tirto Utomo dan Ibnu Sutowo.",

                    watersImageRes.getResourceId(i,0)));
        }
        watersImageRes.recycle();
        mWaterAdapter.notifyDataSetChanged();
    }
}

