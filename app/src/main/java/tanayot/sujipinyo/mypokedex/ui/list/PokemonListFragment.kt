package tanayot.sujipinyo.mypokedex.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import org.koin.androidx.viewmodel.ext.android.viewModel
import tanayot.sujipinyo.mypokedex.adapter.PokemonListAdapter
import tanayot.sujipinyo.mypokedex.databinding.PokemonListFragmentBinding
import tanayot.sujipinyo.mypokedex.model.PokemonUrl

class PokemonListFragment : Fragment(), PokemonListListener {

    private lateinit var binding: PokemonListFragmentBinding
    private val viewModel: PokemonListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.adapter = PokemonListAdapter(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.pokemonPagedList.observe(this, Observer<PagedList<PokemonUrl>> {
            binding.adapter?.submitList(it)
        })

       viewModel.isInitLoading.observe(this, Observer {
            binding.progressBar.isVisible  = it
        })

        viewModel.networkError.observe(this, Observer {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun onItemPokemonClick(pokemonUrl: PokemonUrl?) {
        val action = PokemonListFragmentDirections.actionMainFragmentToPokemonDetailFragment(pokemonUrl!!.PokemonUrl)
        findNavController().navigate(action)
    }
}
