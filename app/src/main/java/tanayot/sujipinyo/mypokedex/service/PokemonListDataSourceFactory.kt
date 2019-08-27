package tanayot.sujipinyo.mypokedex.service

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import tanayot.sujipinyo.mypokedex.model.PokemonUrl


class PokemonListDataSourceFactory(fuel: Fuel, dataPath: String): DataSource.Factory<String, PokemonUrl>() {
    private val pokemonDataSource  = PokemonListDataSource(fuel, dataPath)
    val isInitLoading: LiveData<Boolean>  = pokemonDataSource.isInitLoading
    val networkError:  LiveData<FuelError> = pokemonDataSource.networkError
    override fun create(): DataSource<String, PokemonUrl> = pokemonDataSource
}