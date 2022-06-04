package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(var recipes: ArrayList<Recipe>): RecyclerView.Adapter<RecipePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipePrototype {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.prototype_diets_recipes, parent, false)

            return RecipePrototype(view)
    }

    override fun onBindViewHolder(holder: RecipePrototype, position: Int) {
        holder.bind(recipes.get(position))
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun DeleteItem(){
        recipes.removeAt(1)
    }


}

class RecipePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //vinculamos los controles del prototype con variables
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitleDiet)
    val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    val tvN_Calories = itemView.findViewById<TextView>(R.id.tvNumbCalories)
    val tvN_Ingredients = itemView.findViewById<TextView>(R.id.tvN_Ingre)
    val tvT_Prepra = itemView.findViewById<TextView>(R.id.tvN_TPre)

    //vinculamos las variables con la clase
    fun bind(recipe: Recipe){
        tvTitle.text = recipe.title
        tvDescription.text = recipe.description
        tvN_Calories.text = recipe.N_Calories
        tvN_Ingredients.text = recipe.N_Ingredients
        tvT_Prepra.text = recipe.T_Preparation
    }
}
