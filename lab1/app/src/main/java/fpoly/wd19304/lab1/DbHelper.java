package fpoly.wd19304.lab1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todoList.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE todos (id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT)";
        db.execSQL(createTable);
        // Insert some sample data
        db.execSQL("INSERT INTO todos (task) VALUES ('Sample Task 1')");
        db.execSQL("INSERT INTO todos (task) VALUES ('Sample Task 2')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS todos");
        onCreate(db);
    }
}
