package com.n08.g701;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public  static  final int DB_VERSION =1;
    public  static  final String DB_NAME="product.sqlite";
    public  static  final String TBL_NAME= "Product";
    public  static  final String COL_B_ID= "pId";
    public  static  final String COL_B_NAME= "pName";
    public  static  final String COL_B_Hang_SX= "p_Hang_SX";

    public  static  final String COL_B_PRICE= "pPrice";
    public  static  final String COL_B_IMAGE= "pImage";
    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS "+TBL_NAME + "("+ COL_B_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_B_NAME+" VARCHAR(100), "+COL_B_Hang_SX+ " VARCHAR(200), "+COL_B_PRICE +" DOUBLE, "+COL_B_IMAGE +" INT )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(sqLiteDatabase);

    }


    public Cursor getData(String sql){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public void  execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public int getCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public void createSomeData(){
        int count = getCount();
        if(count == 0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Laptop HP Pavilion 14-dv0041TU (2H3L0PA)', 'HP', 250000, "+ R.drawable.iphone13+" )" );
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Laptop DEll', 'Dell', 250000, "+ R.drawable.asus+" )" );

//

        }
    }
}
