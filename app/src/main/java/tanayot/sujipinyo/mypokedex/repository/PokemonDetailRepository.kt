package tanayot.sujipinyo.mypokedex.repository

import androidx.lifecycle.MutableLiveData
import com.github.kittinunf.fuel.Fuel
import tanayot.sujipinyo.mypokedex.model.Pokemon
import tanayot.sujipinyo.mypokedex.ui.detail.PokemonDetailListener

class PokemonDetailRepository(private val fuel: Fuel) {
    fun  getPokemonDetail(url: String, listener: PokemonDetailListener){
        val response: MutableLiveData<Pokemon>  = MutableLiveData()
        fuel.get(url)
            .responseObject(Pokemon.Deserializer()) { _, _, result ->
                result.fold(success = { body ->
                    response.value = body
                    listener.onGetPokemonDetailSuccess(response)
                }, failure = { error ->
                    listener.onGetPokemonDetailFailure(error)
                })
            }
    }
}