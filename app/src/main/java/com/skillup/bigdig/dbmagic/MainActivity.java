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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.bt_add)
    void add() {
    }

    @OnClick(R.id.bt_delete)
    void delete() {
        if (personList.size() > 0) {
            personList.remove(personList.size()-1);
        }
    }

    @OnClick(R.id.bt_get_all)
    void getAll() {
        for (Person p :
                personList) {
            Log.d("danil",p.toString());
        }
    }
}
