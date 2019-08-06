package kriti.tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static android.provider.Telephony.Mms.Part.TEXT;
import static java.sql.Types.INTEGER;

/**
 * Created by kirti on 12/20/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COl_1= "ID";
    public static final String COl_2= "NAME";
    public static final String COl_3= "EMAIL";
    public static final String COl_4= "PASSWORD";
    public static final String COl_5= "PHONE";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null,1);
        //db=this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db = this.getWritableDatabase();
        String table = "CREATE TABLE " +TABLE_NAME +"("+ COl_1 +" INTEGER PRIMARY KEY AUTOINCREMENT," + COl_2 +" TEXT," +
                COl_3 + " TEXT," + COl_4 +
                " TEXT," + COl_5 + " TEXT" + ")";

        db.execSQL(table);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name, String email,String password,String phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2,name);
        contentValues.put(COl_3,email);
        contentValues.put(COl_4,password);
        contentValues.put(COl_5,phone);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
        {
            return false;

        }
        else
        {
            return true;
        }

    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+ TABLE_NAME, null);
        return  res;


    }
    public int checkuser(String email,String passwd)
    {
        int id=-1;

        SQLiteDatabase DB=this.getReadableDatabase();


        Cursor cb=DB.rawQuery( "SELECT ID FROM student_table WHERE EMAIL=? AND PASSWORD=? ",new String[]{email,passwd});
        //count=cb.getCount();
        if(cb.getCount()>0)

        {
            cb.moveToFirst();
            id=cb.getInt(0);
            cb.close();
        }

        return id;

    }
}
