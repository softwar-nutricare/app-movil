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

class Diets_Recipes : AppCompatActivity(), OnItemClickListenerRecipe {

    override fun OnItemClicked(recipe: Recipe) {
    }

    lateinit var recipes: List<Recipe>

    //utilizo el adaptador del RV
    lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diets_recipes)

        val actionBar = supportActionBar

        actionBar!!.title = "Dietas/Recetas"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    //este metodo se carga en c/cambio
    override fun onResume() {
        super.onResume()
        loadRecipes()

        recipeAdapter = RecipeAdapter(recipes, this)
        rvDietRecep.adapter = recipeAdapter
        rvDietRecep.layoutManager = LinearLayoutManager(this)
    }

    private fun loadRecipes() {
        recipes = AppDatabaseRecipe.getInstance(this).getDao().getAll()
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_diets_recipes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            // User chose the "Settings" item, show the app settings UI...
            true
        }

        R.id.action_favorite -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            Log.i("My tag", "My message")
            //loadRecipesfav()
            initView()
            Toast.makeText(this@Diets_Recipes,"Tus Favoritos",
                Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    private fun initView() {
        //vinculo el adapter al rV
        val rvRecipe = findViewById<RecyclerView>(R.id.rvDietRecep)
        //rvRecipe.adapter = recipeAdapter
        rvRecipe.layoutManager = LinearLayoutManager(this)
    }*/

    /*private fun loadRecipes() {
        recipes.add(Recipe("Ensalada Fresca", "Esta ensalada esta comprendida por bla bla bla bla bla", "50", "4", "3:00 min"))
        recipes.add(Recipe("Ensalada Rusa", "Esta ensalada esta comprendida por veterraga, leghuga y bla bla bla bla bla", "40", "3", "4:00 min"))
        recipes.add(Recipe("Ensalada de Frutas", "Esta ensalada esta tiene diversas frutas como bla bla bla bla bla", "70", "5", "6:00 min"))
        recipes.add(Recipe("Ensalada Mixta", "Esta ensalada esta hecha de bla bla bla bla bla", "50", "4", "3:00 min"))
        recipes.add(Recipe("Ensalada Caprese", "Esta ensalada se caracteriza por bla bla bla bla bla", "50", "4", "3:00 min"))


    }*/

    /*private fun loadRecipesfav(){
        recipes.removeLast()
        recipes.removeLast()
        //recipes.add(Recipe("Ensalada Leche", "Esta ensalada esta comprendida por bla bla bla bla bla", "50", "4", "3:00 min"))


    }*/


}