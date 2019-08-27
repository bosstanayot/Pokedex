package tanayot.sujipinyo.mypokedex.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import tanayot.sujipinyo.mypokedex.ApiConstant.BASE_IMAGE_URL

data class Pokemon(@SerializedName("id")val pokemonId: Int,
                   @SerializedName("name")val pokemonName: String,
                   @SerializedName("height")val pokemonHeight: Int,
                   @SerializedName("weight")val pokemonWeight: Int,
                   @SerializedName("base_experience")val pokemonExp: Int){

    val imagePokemonUrl: String
        get() = "$BASE_IMAGE_URL$pokemonId.png"

    val heightInCentimeter: Int
        get() = pokemonHeight*10

    val weightInKilogram: Float
        get() = pokemonHeight.toFloat()/10

    class Deserializer: ResponseDeserializable<Pokemon> {
        override fun deserialize(content: String): Pokemon? {
            return Gson().fromJson(content, Pokemon::class.java)
        }
    }
}
