package com.example.ql_show;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        btn1 = findViewById(R.id.tao_moi);
        btn2 = findViewById(R.id.xem_lich);

        btn1.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, Tao_Moi.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, Xem_Lich.class);
            startActivity(intent);
        });




    }
}