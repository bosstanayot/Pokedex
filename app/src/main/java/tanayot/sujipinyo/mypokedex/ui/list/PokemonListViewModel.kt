package tanayot.sujipinyo.mypokedex.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.github.kittinunf.fuel.core.FuelError
import tanayot.sujipinyo.mypokedex.model.DataResult
import tanayot.sujipinyo.mypokedex.repository.PokemonListRepository
import tanayot.sujipinyo.mypokedex.model.PokemonUrl

class PokemonListViewModel(private val pokemonListRepository: PokemonListRepository) : ViewModel() {
    private val dataResult:  MutableLiveData<DataResult> = MutableLiveData()
    var pokemonPagedList:LiveData<PagedList<PokemonUrl>> = Transformations.switchMap(dataResult){it.result}
    var isInitLoading: LiveData<Boolean> = Transformations.switchMap(dataResult){it.isInitLoading}
    var networkError: LiveData<FuelError>  = Transformations.switchMap(dataResult){it.networkError}

    init {
        getPokemonList()
    }

    private fun getPokemonList(){
        dataResult.value = pokemonListRepository.getPageList("pokemon")
    }
}
