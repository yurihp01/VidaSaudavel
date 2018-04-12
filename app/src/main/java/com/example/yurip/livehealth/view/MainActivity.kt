package com.example.yurip.livehealth.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import com.example.yurip.livehealth.R

import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity

@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity() {

    @Click(R.id.list_disease)
    internal fun onClickedListDisease() {
        ListActivity_.intent(this).start()
    }

    @Click(R.id.list_disease_text)
    internal fun onClickedListDiseaseText() {
        ListActivity_.intent(this).start()
    }

    @Click(R.id.about_app)
    internal fun onClickedAboutApp() {
        AboutActivity_.intent(this).start()
    }

    @Click(R.id.about_app_text)
    internal fun onClickedAboutAppText() {
        AboutActivity_.intent(this).start()
    }

    @Click(R.id.nearest_hospital)
    internal fun OnClickedNearestHospital() {
        startActivity(Intent(this@MainActivity, HospitalActivity::class.java))

    }

    @Click(R.id.nearest_hospital_text)
    internal fun OnClickedNearestHospitalText() {
        startActivity(Intent(this@MainActivity, HospitalActivity::class.java))
    }

    @Click(R.id.contact)
    internal fun onClickedContact() {
        ContactActivity_.intent(this).start()
    }

    @Click(R.id.contact_text)
    internal fun onClickedContactText() {
        ContactActivity_.intent(this).start()
    }
}
