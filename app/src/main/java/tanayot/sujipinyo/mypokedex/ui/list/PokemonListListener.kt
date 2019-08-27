package tanayot.sujipinyo.mypokedex.ui.list

import tanayot.sujipinyo.mypokedex.model.PokemonUrl

interface PokemonListListener {
    fun onItemPokemonClick(pokemonUrl: PokemonUrl?)
}