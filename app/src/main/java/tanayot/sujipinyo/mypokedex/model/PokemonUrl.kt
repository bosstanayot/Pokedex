package tanayot.sujipinyo.mypokedex.model

import androidx.recyclerview.widget.DiffUtil
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class PokemonUrl(@SerializedName("name")val PokemonName: String,
                      @SerializedName("url")val  PokemonUrl: String){
    companion object{
        val CALLBACK = object :DiffUtil.ItemCallback<PokemonUrl>(){
            override fun areItemsTheSame(oldItem: PokemonUrl, newItem: PokemonUrl): Boolean = (oldItem.PokemonUrl == newItem.PokemonUrl)
            override fun areContentsTheSame(oldItem: PokemonUrl, newItem: PokemonUrl): Boolean = (oldItem == newItem)
        }
    }
}