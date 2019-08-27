package tanayot.sujipinyo.mypokedex.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.core.FuelError
import tanayot.sujipinyo.mypokedex.model.Pokemon
import tanayot.sujipinyo.mypokedex.repository.PokemonDetailRepository

class PokemonDetailViewModel(private val pokemonDetailRepository: PokemonDetailRepository) : ViewModel(),
    PokemonDetailListener {

    val pokemonDetail: MutableLiveData<Pokemon>  = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val networkError: MutableLiveData<FuelError> = MutableLiveData()

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

    override fun onGetPokemonDetailFailure(error: FuelError) {
        networkError.value = error
    }

}
