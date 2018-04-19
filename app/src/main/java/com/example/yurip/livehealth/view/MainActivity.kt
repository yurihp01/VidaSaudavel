package com.example.yurip.livehealth.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import com.example.yurip.livehealth.R

import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity

@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity() {

    @Click(R.id.list_disease)
    open fun onClickedListDisease() {
        ListActivity_.intent(this).start()
    }

    @Click(R.id.list_disease_text)
    open fun onClickedListDiseaseText() {
        ListActivity_.intent(this).start()
    }

    @Click(R.id.about_app)
    open fun onClickedAboutApp() {
        AboutActivity_.intent(this).start()
    }

    @Click(R.id.about_app_text)
    open fun onClickedAboutAppText() {
        AboutActivity_.intent(this).start()
    }

    @Click(R.id.nearest_hospital)
    open fun OnClickedNearestHospital() {
        startActivity(Intent(this, MapsActivity::class.java))
    }

    @Click(R.id.nearest_hospital_text)
    open fun OnClickedNearestHospitalText() {
        startActivity(Intent(this, MapsActivity::class.java))
    }

    @Click(R.id.contact)
    open fun onClickedContact() {
        ContactActivity_.intent(this).start()
    }

    @Click(R.id.contact_text)
    open fun onClickedContactText() {
        ContactActivity_.intent(this).start()
    }
}
