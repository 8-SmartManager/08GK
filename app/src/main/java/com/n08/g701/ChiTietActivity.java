package com.n08.g701;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.n08.model.Product;

public class ChiTietActivity extends AppCompatActivity {
    EditText edtID, edtName, edtPublisher, edtPrice;
    Button btnDelete, btnEdit;
    ImageView imvPhoto;
    Product selectedProduct=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        Drawable drawable=getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi tiết sản phẩm");
        linkViews();
        getData();
        addEvents();
    }

    private void addEvents() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ChiTietActivity.this,R.style.Theme_MaterialComponents_Light_Dialog_FixedSize);
                dialog.setContentView(R.layout.dialog_error);
                TextView txtTitle=dialog.findViewById(R.id.txtTitle),
                        txtMessage=dialog.findViewById(R.id.txtMessage);
                Button btnYes=dialog.findViewById(R.id.btnYes),
                        btnNo=dialog.findViewById(R.id.btnNo);
                txtTitle.setText("Xác nhận");
                txtMessage.setText("Bạn có chắc chắn muốn xóa?");
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity.db.execSql("DELETE FROM "+ MyDatabase.TBL_NAME+" WHERE "+MyDatabase.COL_B_ID + "=" +selectedProduct.getProductId());

                        finish();
                    }
                });
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietActivity.this,CapNhatActivity.class);


                intent.putExtra("San pham",selectedProduct);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getData() {
        Intent intent= getIntent();
        selectedProduct= (Product) intent.getSerializableExtra("San pham");
        imvPhoto.setImageResource(selectedProduct.getProductImage());
        edtID.setText(String.valueOf(selectedProduct.getProductId()));
        edtName.setText(selectedProduct.getProductName());
        edtPrice.setText(String.valueOf(selectedProduct.getProductPrice()));
        edtPublisher.setText(selectedProduct.getProductHangSanXuat());
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}