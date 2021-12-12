package com.n08.g701;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.n08.adapter.ProductAdapter;

import com.n08.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProduct;
    ProductAdapter adapter;
    ArrayList<Product> products;
    public static  MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        prepareData();

        getDataFromDB();
        addEvent();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        loadData();
        super.onCreate(savedInstanceState, persistentState);
    }

    private void loadData(){
        adapter = new ProductAdapter(MainActivity.this, R.layout.item_layout,getDataFromDB());
        lvProduct.setAdapter(adapter);
    }

    private void addEvent() {
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ChiTietActivity.class);
                adapter= new ProductAdapter(MainActivity.this,R.layout.activity_chi_tiet,products);
                Product goal= (Product) adapter.getItem(i);
                intent.putExtra("San pham",products);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        prepareData();
    }
    private ArrayList<Product> getDataFromDB() {
        products = new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM "+MyDatabase.TBL_NAME);
        products.clear();
        while (cursor.moveToNext()){
            products.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getDouble(3),cursor.getInt(4)));
        }
        cursor.close();
        return products;
    }

    private void prepareData() {
        db= new MyDatabase(this);
//        db.createSomeData();
    }

    private void linkViews() {
        lvProduct = findViewById(R.id.lvProduct);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnAddTask){
            Intent intent = new Intent(MainActivity.this, ThemMoiActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}