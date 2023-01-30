package com.example.croatiansensation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class CabinetFragment : Fragment() {


    private lateinit var dbref : DatabaseReference
    private lateinit var cocktailsRecyclerView : RecyclerView
    private lateinit var cocktailsList : ArrayList<Cocktails>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_cabinet, container, false)
        val goToMainMenuFromCabinetButton = view.findViewById<Button>(R.id.goToMainFromCabinetButton)

        cocktailsRecyclerView = view.findViewById(R.id.favoriteCocktails)
        cocktailsRecyclerView.layoutManager = LinearLayoutManager(context)
        cocktailsRecyclerView.setHasFixedSize(true)

        cocktailsList = arrayListOf<Cocktails>()
        getCocktailsData()



        goToMainMenuFromCabinetButton.setOnClickListener {
            val mainMenuFragment = MainMenuFragment()
            val fragmentTransaction : FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.leadFragment, mainMenuFragment)
            fragmentTransaction?.commit()
        }

        return view
    }

    private fun getCocktailsData() {
        dbref = FirebaseDatabase.getInstance("https://croatian-sensation-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Cocktails")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(cocktailSnapshot in p0.children){

                        val cocktail = cocktailSnapshot.getValue(Cocktails::class.java)
                        cocktailsList.add(cocktail!!)
                    }
                    cocktailsRecyclerView.adapter = CocktailAdapter(cocktailsList)
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("FAIL", p0.message.toString())
            }

        })


    }


}