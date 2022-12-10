package com.example.mykotlinrxjava.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinrxjava.R
import com.example.mykotlinrxjava.adapter.GameAdapter
import com.example.mykotlinrxjava.viewmodel.GameViewModel
import com.example.treding_games.model.GameItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Game_Activity : AppCompatActivity() {

    lateinit var gameViewModel: GameViewModel

    lateinit var recycler_game: RecyclerView

    lateinit var gameAdapter: GameAdapter;

    private var gameList =ArrayList<GameItem>();

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        recycler_game= findViewById(R.id.recyclerview_gameList)

        gameAdapter = GameAdapter(this@Game_Activity,gameList)

        recycler_game.apply {
            setHasFixedSize(true)
            layoutManager= GridLayoutManager(this@Game_Activity,2)

            adapter = gameAdapter
        }

        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        gameViewModel.getUsers().observe(this, Observer {

            if (it != null) {

                gameAdapter.setData(it)
            } else {
                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        })

        gameViewModel.errorMessage.observe(this, Observer {

            Toast.makeText(this, "Error $it", Toast.LENGTH_SHORT).show()
        })
    }

   /* private fun renderList(users: List<GameItem>) {
        gameAdapter.apply {
            gameAdapter.setData(users, this@Game_Activity)
            gameAdapter.notifyDataSetChanged()
        }
    }*/
}