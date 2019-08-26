package tanayot.sujipinyo.mypokedex.service

import com.github.kittinunf.fuel.Fuel
import tanayot.sujipinyo.mypokedex.ApiConstant
import tanayot.sujipinyo.mypokedex.model.PagingPokemon

class PokemonListService {
    companion object {
        fun getPokemonList(pokemonServiceListener: PokemonServiceListener) {
            Fuel.get(ApiConstant.BASE_URL + "pokemon")
                .responseObject(PagingPokemon.Deserializer()) { _, _, result ->
                    result.fold(success = { body ->
                        pokemonServiceListener.onGetDataSuccess(body)
                    }, failure = { error ->
                        pokemonServiceListener.onGetDataFailure(error)
                    })
                }
        }
    }
}