package com.example.mykotlinrxjava.retrofit

import com.example.treding_games.model.GameItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface GameApi {

    @GET("api/games")
      fun getGame() : Observable<List<GameItem>>
}