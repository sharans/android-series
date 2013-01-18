package tw.workshop.datastore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import tw.workshop.model.Status;

public class StatusDataStore {
    private static final String DBName = "STATUS_UPDATE.db";
    private static final int DBVersion = 1;
    private StatusPersistenceHelper statusPersistenceHelper;
    private SQLiteDatabase db;

    public StatusDataStore(Context context) {
        statusPersistenceHelper = new StatusPersistenceHelper(context, DBName, null, DBVersion);
        db = statusPersistenceHelper.getWritableDatabase();
    }

    public void save(Status status){
        ContentValues contentValues = new ContentValues();
        contentValues.put(StatusPersistenceHelper.STORY_NUMBER, status.getStoryNumber());
        contentValues.put(StatusPersistenceHelper.STORY_STATUS, status.getStoryStatus());
        db.insert(StatusPersistenceHelper.TABLE_NAME, null, contentValues);
    }
}
