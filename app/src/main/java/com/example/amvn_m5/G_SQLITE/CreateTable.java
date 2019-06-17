package com.example.amvn_m5.G_SQLITE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CreateTable extends SQLiteOpenHelper {

    //region KHAI BÁO BIẾN TOÀN CỤC

    // Phiên bản SQLite
    private static final int DATABASE_VERSION = 1;

    // Tên CSDL
    private static final String DATABASE_NAME = "DB_VinaMobile";

    // Tên bảng
    private static final String TABLE_NAME_AUTHENCATION = "TMT_AUTHEN";

    //BẢNG TMT_AUTHEN
    private static final String TMT_AUTHEN_NGAYTAO = "NGAYTAO";
    private static final String TMT_AUTHEN_USERTAO = "USERTAO";
    private static final String TMT_AUTHEN_NGAYCN = "NGAYCN";
    private static final String TMT_AUTHEN_USERCN = "USERCN";
    private static final String TMT_AUTHEN_SDT = "SDT";
    private static final String TMT_AUTHEN_USERID = "USERID";
    private static final String TMT_AUTHEN_SESSIONID = "SESSION_ID";
    private static final String TMT_AUTHEN_THOIGIANDN = "THOIGIAN_DN";
    private static final String TMT_AUTHEN_LOCATIONID = "LOCATION_ID";
    private static final String TMT_AUTHEN_TENTHIETBI = "TEN_THIETBI";
    //endregion

    //region SỰ KIỆN CHÍNH TRONG CLASS
    public CreateTable(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // TẠO BẢNG
        Create_TMT_AUTHEN(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // XÓA BẢNG
        Drop_TMT_AUTHEN(sqLiteDatabase);
    }
//endregion

    //region TẠO BẢNG TRONG DATABASE

    // Tạo bảng TMT_AUTHEN
    public void Create_TMT_AUTHEN(SQLiteDatabase sqLiteDatabase) {
        try {
            // script tạo bảng
            String script = "CREATE TABLE " + TABLE_NAME_AUTHENCATION + " ( "
                    + TMT_AUTHEN_NGAYTAO + " DATETIME , "
                    + TMT_AUTHEN_USERTAO + " VARCHAR(10), "
                    + TMT_AUTHEN_NGAYCN + " DATETIME, "
                    + TMT_AUTHEN_USERCN + " VARCHAR(10), "
                    + TMT_AUTHEN_SDT + " VARCHAR(11), "
                    + TMT_AUTHEN_USERID + " VARCHAR(10), "
                    + TMT_AUTHEN_SESSIONID + " VARCHAR(100), "
                    + TMT_AUTHEN_THOIGIANDN + " DATETIME, "
                    + TMT_AUTHEN_LOCATIONID + " VARCHAR(40), "
                    + TMT_AUTHEN_TENTHIETBI + " VARCHAR(50) ) ";

            // chạy lệnh tạo bảng
            sqLiteDatabase.execSQL(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region XÓA BẢNG TRONG DATABASE
    // xóa bảng TMT_AUTHEN nếu tồn tại, tạo lại
    public void Drop_TMT_AUTHEN(SQLiteDatabase sqLiteDatabase) {
        try {
            //script xóa bảng
            String script = "DROP TABLE IF EXISTS " + TABLE_NAME_AUTHENCATION;

            // Xóa bảng
            sqLiteDatabase.execSQL(script);

            // tạo lại bảng
            onCreate(sqLiteDatabase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion
}
