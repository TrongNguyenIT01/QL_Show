package com.example.ql_show;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.Toast;

import  java.util.Locale;
import java.util.Calendar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Tao_Moi extends AppCompatActivity {

    Button btnback, btnSave;
    EditText tg , edtTenShow, edtDiaDiem, edtThoiGian, edtBauShow, edtGhiChu;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tao_moi);

        btnback =findViewById(R.id.back);
        btnback.setOnClickListener(v ->{
           finish();
        });

        tg = findViewById(R.id.edt_thoi_gian);
        tg.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            Locale.setDefault(new Locale("vi"));
            DatePickerDialog datePicker = new DatePickerDialog(
                    Tao_Moi.this,
                    android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                    (view, year1, month1, dayOfMonth) -> {


                        String date = dayOfMonth + "/" + (month1+1) + "/" + year1;
                        tg.setText(date);

                    },
                    year, month, day
            );

            datePicker.show();
        });

        db = new DatabaseHelper(this);

        edtTenShow = findViewById(R.id.edt_ten_show);
        edtDiaDiem = findViewById(R.id.edt_dia_diem);
        edtBauShow = findViewById(R.id.edt_bau_show);
        edtThoiGian = findViewById(R.id.edt_thoi_gian);
        edtGhiChu = findViewById(R.id.edt_ghi_chu);

        btnSave =findViewById(R.id.save_show);




        btnSave.setOnClickListener(v -> {
            String tenshow = edtTenShow.getText().toString();
            String diadiem = edtDiaDiem.getText().toString();
            String baushow = edtBauShow.getText().toString();
            String ghichu = edtGhiChu.getText().toString();

            String inputDate = edtThoiGian.getText().toString();
            if(inputDate.isEmpty()){
                Toast.makeText(this,"Vui lòng nhập ngày",Toast.LENGTH_SHORT).show();
                return;
            }

            String [] parts = inputDate.split("/");

            String dbDate  = parts[2] + "-" + parts[1] + "-" + parts[0];

            AddShow show = new AddShow(tenshow, diadiem, baushow, ghichu, dbDate);

            boolean result = db.insertShow(show);
            if(result){
                Toast.makeText(this,"Lưu thành công", Toast.LENGTH_SHORT).show();
                edtTenShow.setText("");
                edtDiaDiem.setText("");
                edtThoiGian.setText("");
                edtBauShow.setText("");
                edtGhiChu.setText("");
            }else{
                Toast.makeText(this,"Lưu thất bại",Toast.LENGTH_SHORT).show();}
        });

    }
}