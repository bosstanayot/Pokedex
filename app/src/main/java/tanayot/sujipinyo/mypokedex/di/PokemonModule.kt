package tanayot.sujipinyo.mypokedex.di

import com.github.kittinunf.fuel.Fuel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tanayot.sujipinyo.mypokedex.repository.PokemonListRepository
import tanayot.sujipinyo.mypokedex.repository.PokemonDetailRepository
import tanayot.sujipinyo.mypokedex.ui.detail.PokemonDetailViewModel
import tanayot.sujipinyo.mypokedex.ui.list.PokemonListViewModel

val pokemonModule =  module {
    viewModel { PokemonDetailViewModel(get()) }
    viewModel { PokemonListViewModel(get()) }

    single { PokemonListRepository(get()) }
    single { PokemonDetailRepository(get()) }
    single { Fuel }

}