package com.example.croatiansensation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class TriviaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trivia, container, false)
        val funFact1 = view.findViewById<TextView>(R.id.funFact1)
        val funFact2 = view.findViewById<TextView>(R.id.funFact2)
        val funFact3 = view.findViewById<TextView>(R.id.funFact3)
        val funFact4 = view.findViewById<TextView>(R.id.funFact4)

        val list1 = listOf("Red Wines are well attributed to positive health benefits. It lowers your chances of having a strokeessens their chance of developing Type 2 diabetes by 30%",
            "How do you hold a wine glass? There is a right and wrong way. Wine glasses should be held by the stem, so that the hand does not raise the temperature of the wine. The stem is for a reason!",
            "Why do you store wine laying down? If the bottle is standing up, the cork could dry out and dwindle, possibly dropping into the wine.",
            "The oldest known wine cellar is on the Titanic. When divers went down to the wreckage, surprisingly most of the bottles were still in tact.",
            "To get the same amount of antioxidants you find in wine, you would need to drink 20 glasses of apple juice or seven glasses of orange juice.",
        "“Toasting” started in ancient Rome when the Romans sustained the Greek tradition. They would drop a piece of toasted bread into the wine glass to soften unsavory tastes.",
        "“Drinking to one’s health” came from ancient Greece. The host of dinner would take the first sip to assure his guests the wine was not poisoned.",
        "When pairing wine with food, the richer, heavier food go well with the richer, heavier wines. Usually red wine is served with the red meat. The lighter foods are pair with the light wines. White wine is served with chicken and fish. If you are looking to pair a wine with dessert, go for the sweet wine.",
        "Wonder why tasters “swirl” the wine in their glass? They do this to release its powerful aromas. If you notice, most don’t fill the glass more than a third full so when they allow the aromas to collect, they not spill it!",
        "Aroma is the term for the fragrance of young wine, while Mellow is for old wine.")

        val list2 = listOf("The cartoon “Tom and Jerry” is named after a Christmas cocktail invented in the 1820s.",
        "There are nearly 49,000,000 bubbles in every bottle of champagne and each bottle has three times more pressure than a car tire!",
        "Giuseppe Cipriani who invented Saint Bellini thought that the pink drink looked like a saint’s toga in a painting by Giovanni Bellini, hence the name!",
        "There is a weird law in Texas, USA that forbids people from having more than three sips of beer in a row- during the Memorial Day weekend.",
        "The word cocktail became popular in the 18th century. To cock a horse’s tail and make it look more energetic for the show, the horse dealer would give it a ginger concoction. Later adding spices like ginger or black pepper to gin, wine or beer came to be called cocktails!",
        "With wine and beer being less available during the Prohibition in the United States (1920–1933), liquor-based cocktails became more popular due to accessibility.",
        "Ernest Hemingway invented a cocktail named “Absinthe and Champagne” or, “Death in the Afternoon.”",
        "There’s an International Bartenders Association which sanctions an official cocktail list for use in the World Cocktail Competition.",
        "A gin & tonic cocktail can help to fight malaria and Winston Churchill once said, “the gin and tonic have saved more Englishmen’s lives, and minds, than all the doctors in the Empire.”",
        "Toulouse Lautrec invented a cocktail called the “Earthquake”, 3 parts Absinthe to 3 parts Cognac served in a wine glass.")

        val list3 = listOf("The earliest evidence of brewing beer dates back to about 3500-2900 B.C. Ancient evidence, in the form of chemical residues, was found in ancient Iran.",
            "The strongest beer in the world has a strength of 67.5%. It was created in 2017 by the Scottish brewery Brewmeister. The beer is called Snake Venom.",
            "Non-alcoholic beer is made either by eliminating fermentation or by removing the alcohol from the finished beer. Compared to the making of conventional beer, the technology of making non-alcoholic beer is a more complicated procedure. ",
            "The largest beer producer in the world is the Belgian corporation Anheuser-Busch InBev. This company owns about 400 beer brands in 50 countries (Budweiser, Corona, Stella Artois, Beck's, Hoegaarden and Leffe, among others).",
            "Craft beer is beer produced by small private breweries. The share of craft breweries in the Russian market is 0.82%. Multinational companies (72.5%) and large breweries (26.68%) account for the rest of the market.",
            "The oldest brewery in the world today is the Weihenstephan brewery in Freising, Germany. It was founded in 1040.",
            "An important contribution to the development of brewing was made by the Danish botanist Emil Christian Hansen. In 1881 he was the first person to obtain a pure culture of beer yeast, which greatly improved the quality of the product. Beer yeast developed from Hansen's technology is still being produced today.",
            "The most common type of beer is lager. Its share in the world consumption reaches up to 80%.",
            "International Beer Day is celebrated on the first Friday of August. The first Beer Day was held in 2007 in the U.S. By 2012, the holiday was celebrated in 50 countries in more than 200 cities around the world.",
            "Though there are hundreds of styles of beer, they all fall into two basic categories: lagers and ales. They are differentiated according to how yeast ferments during the brewing process.")

        val list4 = listOf("The word brandy is derived from the Dutch word brandewijn, which translates to “burnt wine.” This popular digestif is created by distilling wine.",
            "In 1964, the U.S. Congress recognized bourbon as a distinctive product of the United States. The American whiskey gets its name from Bourbon County, Kentucky. Ironically, despite Kentucky producing 95 percent of the world's bourbon, none of it is currently made in Bourbon County.",
            "The name gin is derived from various languages' names for the juniper berry—where gin gets much of its flavor. In French, it's genièvre, while in Dutch it's jenever, and in Italian it's ginepro.",
            "July 31 is “Black Tot Day” in the U.K., commemorating the 1970 rule that abolished the British Navy's daily ration of rum for sailors. The ration was referred to as a “daily tot” and dwindled from half a pint twice a day when it was originally introduced in 1655 to 70 milliliters once per day at the time it was abolished.",
            "Famous explorers Ferdinand Magellan and Christopher Columbus traveled with a large amount of sherry onboard their ships during their historic journeys. In fact, Magellan reportedly spent more on sherry than he spent on weapons for his 1519 trip around the world.",
            "While most vodka is the product of distilled grains, potato vodka is also a popular alternative—especially for anyone with gluten allergies. Because it's derived from potatoes, this type of vodka is entirely gluten-free.",
            "Vodka is the world's most popular liquor by a huge margin, with more than 4.44 billion liters consumed last year. In Russia alone, 13.9 liters of vodka are consumed each year per person.",
            "The name “whiskey” comes from the English pronunciation of the Gaelic term for distilled alcohol, which translates to “water of life” (or “lively water”).",
            "Every year, 24 people die after being hit with a champagne cork! This is partly because a champagne cork leaves a bottle at over 55mph.",
            "According to the famed American journalist, H.L. Mencken, the ingredients in a well-stocked bar can make 17,864,392,788 different cocktails.")
        var randomElement = list1.random()
        funFact1.text=randomElement
        randomElement=list2.random()
        funFact2.text=randomElement
        randomElement=list3.random()
        funFact3.text=randomElement
        randomElement=list4.random()
        funFact4.text=randomElement



        val mainPageButton = view.findViewById<Button>(R.id.goToMainFromTriviaButton)
        mainPageButton.setOnClickListener {
            val mainMenuFragment = MainMenuFragment()
            val fragmentTransaction : FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.leadFragment, mainMenuFragment)
            fragmentTransaction?.commit()
        }


        return view
    }

}