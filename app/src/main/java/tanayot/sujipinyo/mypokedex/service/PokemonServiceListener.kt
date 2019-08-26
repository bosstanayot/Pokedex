package tanayot.sujipinyo.mypokedex.service

import com.github.kittinunf.fuel.core.FuelError
import tanayot.sujipinyo.mypokedex.model.PagingPokemon
import tanayot.sujipinyo.mypokedex.model.PokemonUrl

interface PokemonServiceListener {
    fun onGetDataSuccess(pagingPokemon: PagingPokemon)
    fun onGetDataFailure(exception: FuelError)
}