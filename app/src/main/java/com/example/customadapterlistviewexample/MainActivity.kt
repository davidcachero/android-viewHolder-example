package com.example.customadapterlistviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.customadapterlistviewexample.adapters.ItemListAdapter
import com.example.customadapterlistviewexample.model.Item
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview = findViewById<ListView>(R.id.listview)
        var arrayItems = leerLista()

        var adapter = ItemListAdapter(this, arrayItems)

        listview.adapter = adapter

        listview.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                val itemValue = listview.getItemAtPosition(position) as Item
                Toast.makeText(applicationContext,"Posicion :$position\nValor : ${itemValue.campo1 + "-" + itemValue.campo2}", Toast.LENGTH_LONG).show()
            }
        }

    }


    fun leerLista() : ArrayList<Item>{
        var arrayRdo = ArrayList<Item>()

        var bufferedReaderRaw: BufferedReader = BufferedReader(InputStreamReader(resources!!.openRawResource(R.raw.lista)))
        bufferedReaderRaw.forEachLine { linea -> arrayRdo.add(Item(linea)) }
        bufferedReaderRaw.close()

        return arrayRdo
    }
}