package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_diets_recipes.view.*


class RecipeAdapter(var recipes: List<Recipe>, val itemClickListener: OnItemClickListenerRecipe):
    RecyclerView.Adapter<RecipePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipePrototype {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.prototype_diets_recipes, parent, false)

            return RecipePrototype(view)
    }

    override fun onBindViewHolder(recipePrototype: RecipePrototype, position: Int) {
        recipePrototype.bind(recipes[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //vinculamos los controles del prototype con variables
    val tvTitle = itemView.tvTitleDiet
    val tvDescription = itemView.tvDescription
    val tvN_Calories = itemView.tvNumbCalories
    val tvN_Ingredients = itemView.tvN_Ingre
    val tvT_Prepra = itemView.tvN_TPre
    val cvRecipe = itemView.cvRecipe

    //vinculamos las variables con la clase
    fun bind(recipe: Recipe, itemClickListener: OnItemClickListenerRecipe){
        tvTitle.text = recipe.title
        tvDescription.text = recipe.description
        tvN_Calories.text = recipe.N_Calories
        tvN_Ingredients.text = recipe.N_Ingredients
        tvT_Prepra.text = recipe.T_Preparation

        cvRecipe.setOnClickListener {
            itemClickListener.OnItemClicked(recipe)
        }
    }
}

//creo la interfaz
interface OnItemClickListenerRecipe {
    fun OnItemClicked(recipe: Recipe)

}
