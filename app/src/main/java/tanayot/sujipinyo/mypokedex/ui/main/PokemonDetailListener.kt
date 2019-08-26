package tanayot.sujipinyo.mypokedex.ui.main

import androidx.lifecycle.MutableLiveData
import tanayot.sujipinyo.mypokedex.model.Pokemon

interface PokemonDetailListener {
    fun onGetPokemonDetailSuccess(response: MutableLiveData<Pokemon>)
    fun onGetPokemonDetailFailure()
}