package co.touchlab.kmmbridgekickstart

import co.touchlab.kmmbridgekickstart.db.Breed
import co.touchlab.kmmbridgekickstart.repository.BreedRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class LaClasseDeJery {
    fun essaiPrint() {
        println("Ca marche !!!")
    }
}
fun essaiPrint2() {
    println("Ca marche !!!")
}
class CallbackBreedRepository(private val breedRepository: BreedRepository) {
    private val mainScope = MainScope()
    fun essaiPrint3() {
        println("Ca marche !!!")
    }
    fun getBreeds(callback: (List<Breed>) -> Unit): Cancellable {
        val job = mainScope.launch {
            breedRepository.getBreeds().collect {
                callback(it)
            }
        }

        return object : Cancellable {
            override fun cancel() {
                job.cancel()
            }
        }
    }


    fun refreshBreeds() {
        mainScope.launch { breedRepository.refreshBreeds() }
    }

    fun updateBreedFavorite(breed: Breed) {
        mainScope.launch { breedRepository.updateBreedFavorite(breed) }
    }

    fun refreshBreedsIfStale() {
        mainScope.launch { breedRepository.refreshBreedsIfStale() }
    }

    fun makeHello(): HelloKotlin = HelloKotlin()
}

interface Cancellable {
    fun cancel()
}