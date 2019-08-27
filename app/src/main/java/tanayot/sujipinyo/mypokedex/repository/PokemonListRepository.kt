package tanayot.sujipinyo.mypokedex.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.kittinunf.fuel.Fuel
import tanayot.sujipinyo.mypokedex.PagingConfig
import tanayot.sujipinyo.mypokedex.model.DataResult
import tanayot.sujipinyo.mypokedex.model.PokemonUrl
import tanayot.sujipinyo.mypokedex.service.PokemonListDataSourceFactory
import java.util.concurrent.Executors

class PokemonListRepository(private val fuel: Fuel) {
    var result: LiveData<PagedList<PokemonUrl>> = MutableLiveData()
    fun getPageList(dataPath:  String): DataResult {
        val pokemonDataSourceFactory = PokemonListDataSourceFactory(fuel, dataPath)
        result = LivePagedListBuilder(pokemonDataSourceFactory, PagingConfig.config)
            .setFetchExecutor(Executors.newFixedThreadPool(5))
            .build()

        return DataResult(
            result,
            pokemonDataSourceFactory.isInitLoading,
            pokemonDataSourceFactory.networkError
        )

    }
}