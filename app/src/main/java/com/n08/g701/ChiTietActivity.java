package com.n08.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ChiTietActivity extends AppCompatActivity {
    EditText edtID, edtName, edtPublisher, edtPrice;
    Button btnDelete, btnEdit;
    ImageView imvPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        Drawable drawable=getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi tiết sẩm");
        linkViews();
    }

    private void linkViews() {
        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtPublisher = findViewById(R.id.edtPublisher);
        edtPrice = findViewById(R.id.edtPrice);

        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);

        imvPhoto = findViewById(R.id.imvPhoto);
    }
}