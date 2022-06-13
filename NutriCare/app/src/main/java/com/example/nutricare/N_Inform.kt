package com.example.nutricare

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_ninform.*


class N_Inform : AppCompatActivity(), OnItemClickListenerInfo {

    override fun OnItemClicked(info: Info) {
        //CON ESTE CODIGO paso los valores al adddietrecipesActivity
        val intent = Intent(this, Add_Info::class.java)
        val gson = Gson()
        intent.putExtra("info", gson.toJson(info))
        startActivity(intent)
    }

    lateinit var displayedList : List<Info>
    lateinit var infos: List<Info>

    //utilizo el adaptador del RV
    lateinit var infoAdapter: InfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninform)

        val actionBar = supportActionBar
        actionBar!!.title = "Informate Mas"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val etInfo_Search = findViewById<EditText>(R.id.etInfo_Search)

        /*etInfo_Search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                filterSearch(s.toString())
            }
        })*/
    }

    /*fun filterSearch(text: String?) {
        val temp: MutableList<Info> = ArrayList()
        for (d in displayedList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.getEnglish().contains(text)) {
                temp.add(d)
            }
        }
        //update recyclerview
        infoAdapter.updateList(temp)
    }*/

    //este metodo se carga en c/cambio
    override fun onResume() {
        super.onResume()
        loadInfos()

        infoAdapter = InfoAdapter(infos, this)
        rvNInform.adapter = infoAdapter
        rvNInform.layoutManager = LinearLayoutManager(this)
    }

    private fun loadInfos() {
        infos = AppDatabaseInfo.getInstance(this).getDao().getAll()
    }

    //cargar el ícono "nuevo"
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_n_diets_recipes, menu)

        return true
    }

    //codigo cuando se presiona "nuevo"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemAdd ->{
                val intent = Intent(this, Add_Info::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}