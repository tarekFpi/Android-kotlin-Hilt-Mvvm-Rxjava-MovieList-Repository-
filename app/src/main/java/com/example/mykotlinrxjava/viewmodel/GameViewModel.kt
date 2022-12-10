package com.example.mykotlinrxjava.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlinrxjava.repository.GameRepository
import com.example.treding_games.model.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject
  constructor(private val gameRepository: GameRepository) :ViewModel(){

      var gameList = MutableLiveData<List<GameItem>>()

  /*  val  itemlist : LiveData<List<GameItem>>
        get() = gameList*/


    fun getUsers(): LiveData<List<GameItem>> {
        return gameList
    }

    val errorMessage = MutableLiveData<String>()

    private val compositeDisposable = CompositeDisposable()

    init {
        fetchAllGame()
    }

    fun fetchAllGame() {

        val response = gameRepository.getAllGameList()
        compositeDisposable.add(
            response
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ GameList ->
                    gameList.postValue(GameList)
                }, {
                    errorMessage.postValue(it.message)
                })

        )
    }



    override fun onCleared() {
        super.onCleared()
      //  compositeDisposable.dispose()
    }
}








