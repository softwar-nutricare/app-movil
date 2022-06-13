package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_add_info.*

class Add_Info : AppCompatActivity() {

    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)

        val actionBar = supportActionBar
        actionBar!!.title = "Agregar Info"
        actionBar.setDisplayHomeAsUpEnabled(true)

        loadInfo()
    }

    private fun loadInfo() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("info")

        info = gson.fromJson(stringObj, Info::class.java) ?: Info(null, "", "")

        if (info.id != null){
            etInfo_Add_Title.setText(info.title)
            etInfo_Add_Descrip.setText(info.description)
        }
    }

    ////codigo cuando se presiona grabar o borrar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.itemSave -> {
                saveInfo()
                true
            }
            R.id.itemDelete ->{
                deleteInfo()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteInfo() {
        AppDatabaseInfo.getInstance(this).getDao().deleteInfo(info)
        finish()
    }

    fun saveInfo(){
        //modifico el metodo grabar
        info.title = etInfo_Add_Title.text.toString()
        info.description = etInfo_Add_Descrip.text.toString()

        //es un contacto nuevo o ya existe?
        if (info.id != null){
            AppDatabaseInfo.getInstance(this).getDao().updateInfo(info)
        }
        else{
            AppDatabaseInfo.getInstance(this).getDao().insertInfo(info)
        }
        finish()
    }

    //cargar el ícono "grabar y borrar"
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_add_diet_recipe, menu)
        return true
    }
}