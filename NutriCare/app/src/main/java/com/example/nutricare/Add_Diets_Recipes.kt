package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_diets_recipes.*

class Add_Diets_Recipes : AppCompatActivity() {

    lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_diets_recipes)
        val actionBar = supportActionBar
        actionBar!!.title = "Agregar Dieta"
        actionBar.setDisplayHomeAsUpEnabled(true)

        loadRecipe()
    }

    private fun loadRecipe() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("recipe")

        recipe = gson.fromJson(stringObj, Recipe::class.java) ?: Recipe(null, "", "", "", "", "")

        if (recipe.id != null){
            etDietTitle.setText(recipe.title)
            etDietDescription.setText(recipe.description)
            etDietN_Calories.setText(recipe.N_Calories)
            etDietN_Ingredients.setText(recipe.N_Ingredients)
            etDietT_Preparation.setText(recipe.T_Preparation)
        }
    }

    ////codigo cuando se presiona grabar o borrar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.itemSave -> {
                saveRecipe()
                true
            }
            R.id.itemDelete ->{
                deleteRecipe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteRecipe() {
        AppDatabaseRecipe.getInstance(this).getDao().deleteRecipe(recipe)
        finish()
    }

    fun saveRecipe(){
        //modifico el metodo grabar
        recipe.title = etDietTitle.text.toString()
        recipe.description = etDietDescription.text.toString()
        recipe.N_Calories = etDietN_Calories.text.toString()
        recipe.N_Ingredients = etDietN_Ingredients.text.toString()
        recipe.T_Preparation = etDietT_Preparation.text.toString()

        //contact = Contact(null, name, telephone)

        //es un contacto nuevo o ya existe?
        if (recipe.id != null){
            AppDatabaseRecipe.getInstance(this).getDao().updateRecipe(recipe)
        }
        else{
            AppDatabaseRecipe.getInstance(this).getDao().insertRecipe(recipe)
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