package tanayot.sujipinyo.mypokedex.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import tanayot.sujipinyo.mypokedex.model.Pokemon
import tanayot.sujipinyo.mypokedex.service.PokemonDetailRepository

class PokemonDetailViewModel(private val pokemonDetailRepository: PokemonDetailRepository) : ViewModel(), PokemonDetailListener {

    val pokemonDetail: MutableLiveData<Pokemon>  = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun assignArgument(args: PokemonDetailFragmentArgs) {
       getPokemonDetail(args.pokemonUrl)
    }

    private fun getPokemonDetail(url: String){
        isLoading.value = true
        pokemonDetailRepository.getPokemonDetail(url, this)
    }

    override fun onGetPokemonDetailSuccess(response: MutableLiveData<Pokemon>) {
        isLoading.value = false
        pokemonDetail.value =  response.value
    }

    override fun onGetPokemonDetailFailure() {
    }

}
