package com.example.croatiansensation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MainMenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_menu, container, false)

        val goToCabinetFragmentButton = view.findViewById<Button>(R.id.cabinetButton)
        val goToTriviaFragmentButton = view.findViewById<Button>(R.id.triviaButton)
        val goToRecipesFragmentButton = view.findViewById<Button>(R.id.recipesButton)

        goToCabinetFragmentButton.setOnClickListener {
            val cabinetFragment = CabinetFragment()
            val fragmentTransaction : FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.leadFragment, cabinetFragment)
            fragmentTransaction?.commit()
        }

        goToTriviaFragmentButton.setOnClickListener {
            val triviaFragment = TriviaFragment()
            val fragmentTransaction : FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.leadFragment, triviaFragment)
            fragmentTransaction?.commit()
        }

        goToRecipesFragmentButton.setOnClickListener {
            val recipeFragment = RecipesFragment()
            val fragmentTransaction : FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.leadFragment, recipeFragment)
            fragmentTransaction?.commit()
        }

        return view
    }


}