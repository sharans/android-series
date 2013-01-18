package tw.workshop.datastore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StatusPersistenceHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "STATUS";
    public static final String COLUMN_ID = "_ID";
    public static final String STORY_NUMBER = "STORY_NUMBER";
    public static final String STORY_STATUS = "STORY_STATUS";

    public StatusPersistenceHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {
        sqLiteDB.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                STORY_NUMBER + " TEXT, " +
                STORY_STATUS + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDB, int i, int i1) {
        sqLiteDB.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(sqLiteDB);
    }
}
