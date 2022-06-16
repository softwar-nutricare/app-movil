package com.example.nutricare

import android.content.Intent//
import androidx.appcompat.app.AppCompatActivity//
import android.os.Bundle//
import android.view.Menu//
import android.view.MenuInflater//
import android.view.MenuItem//

import androidx.recyclerview.widget.LinearLayoutManager//
import com.google.gson.Gson//
import kotlinx.android.synthetic.main.activity_diets_recipes.*
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfo : AppCompatActivity(), OnItemClickListenerInfo{

    override fun OnItemClicked(info: Info) {
    }

    lateinit var infos: List<Info>

    //utilizo el adaptador del RV
    lateinit var infoAdapter: InfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val actionBar = supportActionBar
        actionBar!!.title = "Más Información"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    //este metodo se carga en c/cambio
    override fun onResume() {
        super.onResume()
        loadInfos()

        infoAdapter = InfoAdapter(infos, this)
        rvUInform.adapter = infoAdapter
        rvUInform.layoutManager = LinearLayoutManager(this)
    }

    private fun loadInfos() {
        infos = AppDatabaseInfo.getInstance(this).getDao().getAll()
    }
}