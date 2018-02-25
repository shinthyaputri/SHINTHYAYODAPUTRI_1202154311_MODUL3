package com.tugas.shinthya.shinthya_1202154311_sc3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class DetailActivity extends AppCompatActivity {
    ImageView battery;
    int container = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //membuat textview dengan menggunakan id DetailJudul
        TextView textView = findViewById(R.id.DetailJudul);

        //membuat image view atau header
        ImageView imageView = findViewById(R.id.pembatas);

        //membuat detail keterangan dengan memanggil id detail yang sebelumnya sudah dibuat di xml
        TextView lorem = findViewById(R.id.detail);

        textView.setText(getIntent().getStringExtra("title"));
        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        lorem.setText(getIntent().getStringExtra("detail"));
        battery = findViewById(R.id.imageView3);

        //melakukan set image gambar batre yang 20%
        battery.setImageResource(R.drawable.ic_battery_20_black_24dp);

    }
    //membuat tombol minus bisa berkurang
    public void decrease(View view) {
        if (between(container--, 1, 3))
            level(container);
    }
    //membuat agar button plus bisa bertambah
    public void increase(View view) {
        if (between(container++, 1, 3))
            level(container);
    }

    public boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive)
            return true;
        else
            return false;
    }

    //membuat level nya ada yang 20%, 50%, dan 100%
    public void level(int lvl) {
        switch (lvl) {
            case 1:
                battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
                Toast.makeText(this, "Baterai 20%", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
                Toast.makeText(this, "Baterai 50%", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                battery.setImageResource(R.drawable.ic_battery_full_black_24dp);
                Toast.makeText(this, "Baterai 100%", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (lvl > 3) {
                    container = 3;
                } else if(lvl < 1) {
                    container = 1;
                }
        }
    }

}
