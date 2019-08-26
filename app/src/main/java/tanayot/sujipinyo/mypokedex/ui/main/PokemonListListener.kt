package tanayot.sujipinyo.mypokedex.ui.main

import tanayot.sujipinyo.mypokedex.model.PokemonUrl

interface PokemonListListener {
    fun onItemPokemonClick(pokemonUrl: PokemonUrl?)
}