package tanayot.sujipinyo.mypokedex.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class PagingPokemon(val next: String?,
                    val results: ArrayList<PokemonUrl>,
                    val count: Int,
                    val previous:String?){
    class Deserializer: ResponseDeserializable<PagingPokemon> {
        override fun deserialize(content: String): PagingPokemon? {
            return Gson().fromJson(content, PagingPokemon::class.java)
        }
    }
}