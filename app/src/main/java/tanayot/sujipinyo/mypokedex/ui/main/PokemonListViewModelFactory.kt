package tanayot.sujipinyo.mypokedex.ui.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.kittinunf.fuel.Fuel
import tanayot.sujipinyo.mypokedex.model.PokemonListRepository
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class PokemonListViewModelFactory(private val pokemonListRepository: PokemonListRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonListViewModel(pokemonListRepository) as T
    }
}