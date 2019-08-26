package tanayot.sujipinyo.mypokedex.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList

data class DataResult(
    val result: LiveData<PagedList<PokemonUrl>> = MutableLiveData(),
    val isInitLoading: LiveData<Boolean>  =  MutableLiveData()
)