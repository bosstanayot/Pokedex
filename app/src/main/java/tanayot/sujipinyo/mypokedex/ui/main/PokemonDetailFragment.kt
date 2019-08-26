package tanayot.sujipinyo.mypokedex.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.github.kittinunf.fuel.Fuel

import tanayot.sujipinyo.mypokedex.R
import tanayot.sujipinyo.mypokedex.databinding.PokemonDetailFragmentBinding
import tanayot.sujipinyo.mypokedex.service.PokemonDetailRepository

class PokemonDetailFragment : Fragment() {
    
    private lateinit var viewModel: PokemonDetailViewModel
    private lateinit var binding: PokemonDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = PokemonDetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, PokemonDetailViewModelFactory(PokemonDetailRepository(Fuel))).get(PokemonDetailViewModel::class.java)
        binding.viewmodel = viewModel.apply {
            arguments?.let { assignArgument(PokemonDetailFragmentArgs.fromBundle(it)) }
        }

        viewModel.isLoading.observe(this, Observer {
            binding.progressBarDetail.isVisible = it
        })
    }


}
