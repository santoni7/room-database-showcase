package com.skillup.bigdig.dbmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();
    private AppDatabase appDatabase;
    private PersonDAO personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appDatabase = AppDatabaseProvider.getInstance(this);
        personDAO = appDatabase.personDAO();
    }

    @OnClick(R.id.bt_add)
    void add() {
        personDAO.insert(new Person("vasya" , "vasya_pupkin@in.ua"));
    }

    @OnClick(R.id.bt_delete)
    void delete() {
        personList = personDAO.getAll();
        if (personList.size() > 0) {
            Person personToDelete = personList.get(personList.size()-1);
            personDAO.delete(personToDelete);
        }
    }

    @OnClick(R.id.bt_get_all)
    void getAll() {
        personList = personDAO.getAll();
        for (Person p :
                personList) {
            Log.d("mLog", p.toString());
        }
    }
}
