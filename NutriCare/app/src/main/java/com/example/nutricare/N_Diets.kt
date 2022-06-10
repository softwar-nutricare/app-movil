package com.example.nutricare

import android.content.Intent//
import androidx.appcompat.app.AppCompatActivity//
import android.os.Bundle//
import android.view.Menu//
import android.view.MenuInflater//
import android.view.MenuItem//

import androidx.recyclerview.widget.LinearLayoutManager//
import com.google.gson.Gson//
import kotlinx.android.synthetic.main.activity_add_diets_recipes.*//
import kotlinx.android.synthetic.main.activity_ndiets.*

class N_Diets : AppCompatActivity(), OnItemClickListener {

    override fun OnItemClicked(recipe: Recipe) {
        //CON ESTE CODIGO paso los valores al adddietrecipesActivity
        val intent = Intent(this, Add_Diets_Recipes::class.java)
        val gson = Gson()
        intent.putExtra("recipe", gson.toJson(recipe))
        startActivity(intent)
    }

    lateinit var recipes: List<Recipe>

    //utilizo el adaptador del RV
    lateinit var recipeAdapter: RecipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ndiets)
    }

    //este metodo se carga en c/cambio
    override fun onResume() {
        super.onResume()
        loadRecipes()

        recipeAdapter = RecipeAdapter(recipes, this)
        rvNDiets.adapter = recipeAdapter
        rvNDiets.layoutManager = LinearLayoutManager(this)
    }

    private fun loadRecipes() {
        recipes = AppDatabaseRecipe.getInstance(this).getDao().getAll()
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
                val intent = Intent(this, Add_Diets_Recipes::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}