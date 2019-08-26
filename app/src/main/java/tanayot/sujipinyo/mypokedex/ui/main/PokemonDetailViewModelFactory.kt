package tanayot.sujipinyo.mypokedex.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.kittinunf.fuel.Fuel
import tanayot.sujipinyo.mypokedex.service.PokemonDetailRepository

class PokemonDetailViewModelFactory(private val pokemonDetailRepository: PokemonDetailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return PokemonDetailViewModel(pokemonDetailRepository) as T
    }
}