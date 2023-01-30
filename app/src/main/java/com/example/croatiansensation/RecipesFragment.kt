package com.example.croatiansensation

import CocktailAPI
import CocktailsInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
//import com.example.croatiansensation.databinding.ActivityMainBinding
import com.example.croatiansensation.databinding.FragmentRecipesBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecipesFragment : Fragment() {

    private lateinit var binding: FragmentRecipesBinding
    private lateinit var database : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRecipesBinding.inflate(layoutInflater)
        //val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        val view = binding.root


        val mainPageButton = view.findViewById<Button>(R.id.goToMainFromRecipesButton)
        val searchRecipesButton = view.findViewById<Button>(R.id.searchRecipesButton)
        val searchBar = view.findViewById<EditText>(R.id.searchRecipesBar)
        val cocktailPhoto = view.findViewById<ImageView>(R.id.cocktailPhoto)

        val strDrinkText = view.findViewById<TextView>(R.id.cocktailName)
        val strCategoryText = view.findViewById<TextView>(R.id.strCategoryText)
        val strGlassText = view.findViewById<TextView>(R.id.strGlassText)
        val strInstructionsText = view.findViewById<TextView>(R.id.strInstructionsText)

        val ingredientsInfo = view.findViewById<TextView>(R.id.ingredientsInfoText)







        mainPageButton.setOnClickListener {
            val mainMenuFragment = MainMenuFragment()
            val fragmentTransaction : FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.leadFragment, mainMenuFragment)
            fragmentTransaction?.commit()
        }

        searchRecipesButton.setOnClickListener {
            UIUtil.hideKeyboard(context, view)
            val request = CocktailsServiceBuilder.buildService(CocktailAPI::class.java)
            val info = searchBar.text.toString()
            val call = request.getCocktailData(info)
            call.enqueue(object : Callback<CocktailsInfo?> {
                override fun onResponse(call: Call<CocktailsInfo?>, response: Response<CocktailsInfo?>) {
                    val responseBody = response.body()
                    if(responseBody?.drinks!=null) {
                        Glide.with(cocktailPhoto.context)
                            .load(responseBody.drinks[0].strDrinkThumb).into(cocktailPhoto)
                        strDrinkText.text = "Name: " + responseBody.drinks[0].strDrink
                        strCategoryText.text = "Type: " + responseBody.drinks[0].strCategory
                        strGlassText.text = "Glass: " + responseBody.drinks[0].strGlass
                        strInstructionsText.text = "Instructions: " + responseBody.drinks[0].strInstructions
                        ingredientsInfo.text = checkNull(responseBody.drinks[0]?.strIngredient1,responseBody.drinks[0]?.strMeasure1)+
                                checkNull(responseBody.drinks[0].strIngredient2,responseBody.drinks[0].strMeasure2)+
                                checkNull(responseBody.drinks[0].strIngredient3,responseBody.drinks[0].strMeasure3)+
                                checkNull(responseBody.drinks[0].strIngredient4,responseBody.drinks[0].strMeasure4)+
                                checkNull(responseBody.drinks[0].strIngredient5,responseBody.drinks[0].strMeasure5)+
                                checkNull(responseBody.drinks[0].strIngredient6,responseBody.drinks[0].strMeasure6)+
                                checkNull(responseBody.drinks[0].strIngredient7,responseBody.drinks[0].strMeasure7)+
                                checkNull(responseBody.drinks[0].strIngredient8,responseBody.drinks[0].strMeasure8)+
                                checkNull(responseBody.drinks[0].strIngredient9,responseBody.drinks[0].strMeasure9)+
                                checkNull(responseBody.drinks[0].strIngredient10,responseBody.drinks[0].strMeasure10)+
                                checkNull(responseBody.drinks[0].strIngredient11,responseBody.drinks[0].strMeasure11)+
                                checkNull(responseBody.drinks[0].strIngredient12,responseBody.drinks[0].strMeasure12)+
                                checkNull(responseBody.drinks[0].strIngredient13,responseBody.drinks[0].strMeasure13)+
                                checkNull(responseBody.drinks[0].strIngredient14,responseBody.drinks[0].strMeasure14)+
                                checkNull(responseBody.drinks[0].strIngredient15,responseBody.drinks[0].strMeasure15)





                    }
                }
                override fun onFailure(call: Call<CocktailsInfo?>, t: Throwable) {
                    Log.d("FAIL", t.message.toString())
                }
            })

        }


        binding.addToFavorites.setOnClickListener {
            val strIngredients= ingredientsInfo.text.toString()
            val strDrink = strDrinkText.text.toString()
            val strGlass = strGlassText.text.toString()
            val strType = strCategoryText.text.toString()
            val strInstructions = strInstructionsText.text.toString()
            database = FirebaseDatabase.getInstance("https://croatian-sensation-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Cocktails")
            val Cocktails = Cocktails(strIngredients,strDrink,strGlass,strType,strInstructions)
            database.child(strDrink).setValue(Cocktails).addOnSuccessListener {
                Toast.makeText(this.context,"Uspjesno",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this.context,"Nespjesno",Toast.LENGTH_SHORT).show()
            }
        }






        return view
    }

    fun checkNull(s1: String?, s2: String?) : String
    {
        if(!(s1.isNullOrEmpty())){
            if(s2.isNullOrEmpty())
                return s1 + "\n"
            else
                return s1 + "\t" + s2 + "\n"
        }
        return ""
    }

}
