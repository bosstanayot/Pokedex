package tanayot.sujipinyo.mypokedex.ui.detail

import androidx.lifecycle.MutableLiveData
import com.github.kittinunf.fuel.core.FuelError
import tanayot.sujipinyo.mypokedex.model.Pokemon

interface PokemonDetailListener {
    fun onGetPokemonDetailSuccess(response: MutableLiveData<Pokemon>)
    fun onGetPokemonDetailFailure(error: FuelError)
}