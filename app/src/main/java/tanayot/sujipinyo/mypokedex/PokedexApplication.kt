package tanayot.sujipinyo.mypokedex

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import tanayot.sujipinyo.mypokedex.di.pokemonModule

class PokedexApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokedexApplication)
            modules(pokemonModule)
        }
    }
}