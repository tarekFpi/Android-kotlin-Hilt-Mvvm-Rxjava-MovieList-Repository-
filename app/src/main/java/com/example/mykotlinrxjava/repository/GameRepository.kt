package com.example.mykotlinrxjava.repository
import com.example.mykotlinrxjava.retrofit.GameApi
import com.example.treding_games.model.GameItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameApi: GameApi){

  //  fun getAllGameList() = gameApi.getGame()


    fun getAllGameList(): Observable<List<GameItem>> {
        return gameApi.getGame()
    }
    }
