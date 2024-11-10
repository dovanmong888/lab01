package fpoly.wd19304.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

    private DbHelper dbHelper;

    public ToDoDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM todos", null);

        if (cursor.moveToFirst()) {
            do {
                tasks.add(cursor.getString(cursor.getColumnIndexOrThrow("task")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tasks;
    }

    public void addTask(String task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("task", task);
        db.insert("todos", null, values);
    }
}
