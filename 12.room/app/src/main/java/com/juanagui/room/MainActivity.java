package com.juanagui.room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juanagui.room.db.AppDatabase;
import com.juanagui.room.db.Student;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private List<Student> _students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we get DB from RoomApplication
        AppDatabase appDatabase = ((RoomApplication) getApplication()).appDatabase;
        //Dao gets all students from DB
        appDatabase.studentDao().getAll()
                //Sends the query to another thread
                .subscribeOn(Schedulers.io())
                //Tells the thread where to deliver data (Main thread)
                .observeOn(AndroidSchedulers.mainThread())
                //Having all data on Main Thread uses them to interact
                .subscribe(new Consumer<List<Student>>() {
                    @Override
                    public void accept(List<Student> students) throws Throwable {
                        //We charge DB data on the students list
                        _students = students;
                        RecyclerView recyclerView = findViewById(R.id.recyclerview);
                        recyclerView.setAdapter(new StudentAdapter(_students, new StudentAdapter.StudentClickListener() {
                            @Override
                            public void onStudentEdit(int position) {
                                Student student = _students.get(position);
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, EditStudentActivity.class);
                                intent.putExtra(EditStudentActivity.STUDENT_ID_KEY, student.sid);
                                startActivity(intent);
                            }

                            @Override
                            public void onStudentDelete(int position) {
                                Student student = _students.get(position);
                                appDatabase.studentDao().deleteStudent(student)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Action() {
                                            @Override
                                            public void run() throws Throwable {
                                                _students.remove(position);
                                                recyclerView.getAdapter().notifyItemRemoved(position);
                                            }
                                        });
                            }
                        }));
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                });


        findViewById(R.id.add_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, EditStudentActivity.class);
                intent.putExtra(EditStudentActivity.STUDENT_ID_KEY, 0);
                startActivity(intent);
            }
        });
    }
}