package com.nikola.recyclerview_linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikola.recyclerview_linearlayout.adapters.ItemAdapter
import java.util.ArrayList


class MainActivity : AppCompatActivity(),ItemAdapter.OnItemClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ItemAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)



        val generatedList = generateList(30)

        adapter = ItemAdapter(generatedList,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        var itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)



    }



    override fun onItemClick(position: Int)
    {
        Toast.makeText(this, "Position is ${position+1}", Toast.LENGTH_SHORT).show()
    }

    fun generateList (size: Int): List<Item>
    {

        val list = mutableListOf<Item>()



        val listaNaslova = arrayOf("Kotlin","Java","Swift","C++","C#")

        val listaOpisa = arrayOf(
            "In the past, Android was using ListView.",
            "ListViews and GridViews are comparatively.",
            "How is it better than ListViews and GridViews?",
            "This is it why it’s called a RecyclerView!",
            "There are three types of Layout Managers.")

        val imageList = arrayOf(R.drawable.background,R.drawable.download,R.drawable.flag_of_canada,R.drawable.flagofus)

        for (i in 0 until size)
        {

            val randomNaslov = listaNaslova.random()
            val randomOpis = listaOpisa.random()
            val randomSlika = imageList.random()

            val item = Item(randomSlika,randomNaslov,randomOpis)
            list += item

        }

        return list

    }

    fun closeApp(view: android.view.View) {
        finish()

    }


}