package tanayot.sujipinyo.mypokedex.service

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import tanayot.sujipinyo.mypokedex.ApiConstant
import tanayot.sujipinyo.mypokedex.model.PagingPokemon
import tanayot.sujipinyo.mypokedex.model.PokemonUrl

class PokemonListDataSource(private val fuel: Fuel, private val dataPath: String) : PageKeyedDataSource<String, PokemonUrl>(){
    val isInitLoading = MutableLiveData<Boolean>()
    val networkError = MutableLiveData<FuelError>()
    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, PokemonUrl>) {
        isInitLoading.postValue(true)
        fuel.get(ApiConstant.BASE_URL + dataPath)
            .responseObject(PagingPokemon.Deserializer()) { _, _, result ->
                result.fold(success = { body ->
                    isInitLoading.postValue(false)
                    callback.onResult(body.results, 0, body.count, body.previous, body.next)
                }, failure = { error ->
                    networkError.postValue(error)
                })
            }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, PokemonUrl>) {
        fuel.get(params.key)
            .responseObject(PagingPokemon.Deserializer()) { _, _, result ->
                result.fold(success = { body ->
                    callback.onResult(body.results, body.next)
                }, failure = { error ->
                    networkError.postValue(error)
                })
            }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, PokemonUrl>) {}
}