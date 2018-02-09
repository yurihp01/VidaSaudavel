package com.example.yurip.livehealth.view;

import android.support.v7.app.AppCompatActivity;

import com.example.yurip.livehealth.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Click(R.id.list_disease)
    void onClickedListDisease() {
        ListActivity_.intent(this).start();
    }
}
