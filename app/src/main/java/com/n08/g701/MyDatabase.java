package com.n08.g701;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public  static  final int DB_VERSION =1;
    public  static  final String DB_NAME="book.sqlite";
    public  static  final String TBL_NAME= "Book";
    public  static  final String COL_B_ID= "bId";
    public  static  final String COL_B_NAME= "bName";
    public  static  final String COL_B_NXB= "bNhaXuatBan";
    public  static  final String COL_B_TAIBAN= "bTaiBan";
    public  static  final String COL_B_PRICE= "bPrice";
    public  static  final String COL_B_IMAGE= "bImage";
    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS "+TBL_NAME + "("+ COL_B_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_B_NAME+" VARCHAR(100), "+COL_B_NXB+ " VARCHAR(200), "+ COL_B_TAIBAN+" INT, "+COL_B_PRICE +" DOUBLE, "+COL_B_IMAGE +" INT )";
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
//            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Chủ nghĩa khắc kỷ', 'NXB Kim Đồng', 2, 250000, "+ R.drawable.chu_nghia_khac_ky +" )" );
//            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Đắc Nhân Tâm', 'NXB Văn Hóa', 2, 250000, "+ R.drawable.dac_nhan_tam +" )" );
//            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Đọc Vị Bất Kỳ Ai', 'NXB Bình Minh', 2, 250000, "+ R.drawable.doc_vi_bat_ky_ai +" )" );
//            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Trên Đường Băng', 'NXB Khánh Hòa', 2, 250000, "+ R.drawable.tren_duong_bang +" )" );

        }
    }
}
