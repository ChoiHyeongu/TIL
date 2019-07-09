package songpatechnicalhighschool.motivation.diaryapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE DIARYTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, CONTENT TEXT, DATE TEXT);");

        Log.d("DATABASEHelper", "TABLE 생성 완료");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Diary> getResult() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Diary> diaries = new ArrayList<>();
        Diary diary;
        Cursor cursor = db.rawQuery("SELECT * FROM DIARYTABLE", null);
        while (cursor.moveToNext()) {
           diary = new Diary(cursor.getString(1), cursor.getString(2), cursor.getString(3));
           diaries.add(diary);
        }
        return diaries;
    }

    public void insert(String title, String content, String date) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO DIARYTABLE VALUES(null, '" + title + "', '" + content + "', '" + date + "');");
        db.close();
        Toast.makeText(context, "저장 완료!", Toast.LENGTH_SHORT).show();
    }

    public void delete(String title) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM DIARYTABLE WHERE TITLE='" + title + "';");
        db.close();
    }
}
