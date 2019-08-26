package tanayot.sujipinyo.mypokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import tanayot.sujipinyo.mypokedex.R
import tanayot.sujipinyo.mypokedex.databinding.PokemonNameItemBinding
import tanayot.sujipinyo.mypokedex.model.PokemonUrl
import tanayot.sujipinyo.mypokedex.ui.main.PokemonListListener

class PokemonListAdapter(private val listener: PokemonListListener):
    PagedListAdapter<PokemonUrl, PokemonListAdapter.ViewHolder>(PokemonUrl.CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val pokemonNameItemBinding = DataBindingUtil.inflate<PokemonNameItemBinding>(LayoutInflater.from(parent.context),
            R.layout.pokemon_name_item, parent, false)
        return ViewHolder(pokemonNameItemBinding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val pokemonNameItemBinding:PokemonNameItemBinding,
                     private val listener: PokemonListListener):RecyclerView.ViewHolder(pokemonNameItemBinding.root){
        fun bind(pokemonUrl: PokemonUrl?){
            pokemonNameItemBinding.pokemon = pokemonUrl
            itemView.setOnClickListener {
                listener.onItemPokemonClick(pokemonUrl)
            }
        }
    }
}