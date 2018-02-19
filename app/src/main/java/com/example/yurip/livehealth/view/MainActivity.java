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

    @Click(R.id.list_disease_text)
    void onClickedListDiseaseText() {
        ListActivity_.intent(this).start();
    }

    @Click(R.id.about_app)
    void onClickedAboutApp() {
        AboutActivity_.intent(this).start();
    }

    @Click(R.id.about_app_text)
    void onClickedAboutAppText() {
        AboutActivity_.intent(this).start();
    }

    @Click(R.id.nearest_hospital)
    void OnClickedNearestHospital()  {
        HospitalActivity_.intent(this).start();
    }

    @Click(R.id.nearest_hospital_text)
    void OnClickedNearestHospitalText() {
        HospitalActivity_.intent(this).start();
    }

    @Click(R.id.contact)
    void onClickedContact() {
        ContactActivity_.intent(this).start();
    }

    @Click(R.id.contact_text)
    void onClickedContactText() {
        ContactActivity_.intent(this).start();
    }
}
