package com.example.nutricare

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_info.*
import kotlinx.android.synthetic.main.prototype_diets_recipes.*
import java.io.InputStream
import java.net.URL


class Add_Info : AppCompatActivity() {

    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)

        val actionBar = supportActionBar
        actionBar!!.title = "Agregar Info"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val btNInfo_Save = findViewById<Button>(R.id.btNInfo_Save)
        val btNInfo_Delete = findViewById<Button>(R.id.btNInfo_Delete)


        loadInfo()

        btNInfo_Save.setOnClickListener {
            saveInfo()
        }

        btNInfo_Delete.setOnClickListener {
            deleteInfo()
        }
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
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
    }*/

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
    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_add_diet_recipe, menu)
        return true
    }*/
}
