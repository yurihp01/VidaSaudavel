package com.example.yurip.livehealth.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.yurip.livehealth.R
import com.example.yurip.livehealth.view.NodeListAdapter
import com.example.yurip.livehealth.view.Note
import kotlinx.android.synthetic.main.activity_list.*

open class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val recyclerView = note_list_recyclerview
        recyclerView.adapter = NodeListAdapter(notes(), this)
        val layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

    private fun notes(): List<Note> {
        return listOf(
                Note("Leitura", "Livro Android"),
                Note("Pesquisa", "Melhores Práticas para Android"),
                Note("Estudo", "Sincronizar API")
        )
    }




}
