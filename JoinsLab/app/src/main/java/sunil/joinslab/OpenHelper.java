package sunil.joinslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

public class OpenHelper extends SQLiteOpenHelper {

    private static OpenHelper helperInstance;

    public static final String DATABASE_NAME = "EmpJobTable.db";
    public static final int DATABASE_VERSION = 9;

    private OpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public static OpenHelper getInstance(Context context){
        if(helperInstance == null){helperInstance = new OpenHelper(context.getApplicationContext());}
        return helperInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Contracts.EmpTable.CREATE_TABLE);
        sqLiteDatabase.execSQL(Contracts.JobTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Contracts.EmpTable.DELETE_EMP_TABLE);
        sqLiteDatabase.execSQL(Contracts.JobTable.DELETE_DEPT_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addEmployeeRow(Employee em){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contracts.EmpTable.COL_SSN, em.getSoSec());
        values.put(Contracts.EmpTable.COL_FIRST, em.getFirstName());
        values.put(Contracts.EmpTable.COL_LAST, em.getLastName());
        values.put(Contracts.EmpTable.COL_YOB, em.getmYearBirth());
        values.put(Contracts.EmpTable.COL_CITY, em.getCity());
        db.insertOrThrow(Contracts.EmpTable.TABLE_NAME, null, values);
    }

    public void addJobRow(Job j){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contracts.EmpTable.COL_SSN,j.getSocSec());
        values.put(Contracts.JobTable.COL_COMP,j.getCompany());
        values.put(Contracts.JobTable.COL_SAL,j.getSalary());
        values.put(Contracts.JobTable.COL_EXP,j.getExperience());
        db.insertOrThrow(Contracts.JobTable.TABLE_NAME,null,values);
    }

    public Cursor getSameCompany(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(Contracts.EmpTable.TABLE_NAME+" JOIN "+
                Contracts.JobTable.TABLE_NAME+" ON "+ Contracts.EmpTable.COL_SSN+"="+
                Contracts.JobTable.COL_SSN);
        Cursor cursor = builder.query(db,
                new String[]{Contracts.EmpTable.COL_FIRST, Contracts.EmpTable.COL_LAST, Contracts.JobTable.COL_COMP},
                "%"+Contracts.JobTable.COL_COMP+"%",
                new String[]{"Macy's"},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst())
            return cursor;
        else return null;
    }

    public Cursor getBostonComp(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(Contracts.EmpTable.TABLE_NAME+" JOIN "+
                Contracts.JobTable.TABLE_NAME+" ON "+ Contracts.EmpTable.COL_SSN+"="+
                Contracts.JobTable.COL_SSN);
        Cursor cursor = builder.query(db,
                new String[]{Contracts.JobTable.COL_COMP, Contracts.EmpTable.COL_CITY},
                "%"+Contracts.EmpTable.COL_CITY+"%",
                new String[]{"Boston"},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst())
            return cursor;
        else return null;
    }

    public Cursor getHighestSalary(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Contracts.JobTable.TABLE_NAME,
                new String[]{Contracts.JobTable.COL_COMP, Contracts.JobTable.COL_SAL},
                Contracts.JobTable.COL_SAL+"=?",
                new String[]{"Boston"},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst())
            return cursor;
        else return null;
    }
}



