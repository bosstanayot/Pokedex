package tanayot.sujipinyo.mypokedex.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import tanayot.sujipinyo.mypokedex.databinding.PokemonDetailFragmentBinding

class PokemonDetailFragment : Fragment() {
    
    private val viewModel: PokemonDetailViewModel by viewModel()
    private lateinit var binding: PokemonDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = PokemonDetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel.apply {
            arguments?.let { assignArgument(
                PokemonDetailFragmentArgs.fromBundle(
                    it
                )
            ) }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.networkError.observe(this, Observer {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }


}
