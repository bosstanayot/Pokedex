package tanayot.sujipinyo.mypokedex.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.github.kittinunf.fuel.core.FuelError

data class DataResult(
    val result: LiveData<PagedList<PokemonUrl>> = MutableLiveData(),
    val isInitLoading: LiveData<Boolean>  =  MutableLiveData(),
    val networkError: LiveData<FuelError>  = MutableLiveData()
)