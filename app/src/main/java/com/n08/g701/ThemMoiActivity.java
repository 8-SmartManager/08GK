package com.n08.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.n08.adapter.ImageAdapter;
import com.n08.model.Image_Product;

import java.util.ArrayList;

public class ThemMoiActivity extends AppCompatActivity {

    EditText edtTen, edtHangSX, edtGia;
    Button btnChon, btnLuu;
    ImageView imvPhoto;
    Image_Product bi;
    int imageId= R.drawable.iphone13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi);
        linkViews();
        getData();
        imvPhoto.setImageResource(R.drawable.iphone13);
        addEvent();
    }

    private void getData() {
        Intent intent= getIntent();
    }

    private void addEvent() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(ThemMoiActivity.this);
                dialog.setContentView(R.layout.dialog_image);
                GridView gvImage=dialog.findViewById(R.id.gvImage);
                ArrayList<Image_Product> image_products= new ArrayList<>();
                image_products.add(new Image_Product(R.drawable.asus));
                image_products.add(new Image_Product(R.drawable.galaxy_a12));
                image_products.add(new Image_Product(R.drawable.galaxy_a52));
                image_products.add(new Image_Product(R.drawable.iphone13));
                image_products.add(new Image_Product(R.drawable.asus));
                image_products.add(new Image_Product(R.drawable.galaxy_a12));
                image_products.add(new Image_Product(R.drawable.galaxy_a52));
                image_products.add(new Image_Product(R.drawable.iphone13));

                ImageAdapter adapter= new ImageAdapter(ThemMoiActivity.this,R.layout.item_dialog_image,image_products);
                gvImage.setAdapter(adapter);
                gvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        bi= (Image_Product) adapter.getItem(i);
                        imvPhoto.setImageResource(bi.getImageId());
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edtTen.getText().toString(), gia= edtGia.getText().toString(),
                        hangSX=edtHangSX.getText().toString();
                imageId= bi.getImageId();
                if(name.equals("")||gia.equals("")||hangSX.equals("")){
                    AlertDialog.Builder builder= new AlertDialog.Builder(ThemMoiActivity.this);
                    builder.setTitle("Lỗi!");
                    builder.setMessage("Vui lòng nhập đủ thông tin");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    builder.create().show();
                }
                else {
                    try {
                        MainActivity.db.execSql("INSERT INTO "+MyDatabase.TBL_NAME+" VALUES(null, '"+name+"', '"+hangSX+"','"+gia+"',"+imageId+",)");
                        Toast.makeText(ThemMoiActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    catch (Exception exception){
                        Toast.makeText(ThemMoiActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }



            }
        });
    }

    private void linkViews() {
        edtTen = findViewById(R.id.edtTen);
        edtHangSX = findViewById(R.id.edtHangSX);
        edtGia = findViewById(R.id.edtGia);

        btnChon = findViewById(R.id.btnChon);
        btnLuu = findViewById(R.id.btnLưu);

        imvPhoto = findViewById(R.id.imvPhoto);

    }
}