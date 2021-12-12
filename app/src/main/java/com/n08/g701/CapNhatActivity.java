package com.n08.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CapNhatActivity extends AppCompatActivity {

    EditText edtTen, edtHangSX, edtGia;
    Button btnChon, btnCapNhat;
    ImageView imvPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat);

        linkViews();
    }

    private void linkViews() {
        edtTen = findViewById(R.id.edtTen);
        edtHangSX = findViewById(R.id.edtHangSX);
        edtGia = findViewById(R.id.edtGia);

        btnChon = findViewById(R.id.btnChon);
        btnCapNhat = findViewById(R.id.btnCapNhat);

        imvPhoto = findViewById(R.id.imvPhoto);

    }
}