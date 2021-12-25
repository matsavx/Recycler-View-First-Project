package com.example.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var connecting: ActivityMainBinding
    private val adapter = Adapter()
    private val imgList = listOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6)
    private var index = 1
    private var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connecting = ActivityMainBinding.inflate(layoutInflater)
        setContentView(connecting.root)
        setUp()
    }

    private fun setUp() {
        connecting.RVId.layoutManager = LinearLayoutManager(this)
        connecting.RVId.adapter = adapter
        connecting.addButtonId.setOnClickListener {
            if (index > 6)
                index = 1
            price = (2000..10000).random()
            val sneakers = Sneakers(imgList[index-1], "Sneakers no.$index", "price $price rub.")
            adapter.addItem(sneakers)
            index++
        }
    }
}