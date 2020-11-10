package com.example.customadapterlistviewexample.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.customadapterlistviewexample.MainActivity
import com.example.customadapterlistviewexample.R
import com.example.customadapterlistviewexample.model.Item

class ItemListAdapter(private val context: MainActivity, private val items: ArrayList<Item>): BaseAdapter() {

    class ViewHolder{
        lateinit var campo1: TextView
        lateinit var campo2: TextView
        lateinit var bandera: ImageView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var rowView = convertView
        var holder = ViewHolder()

        if (rowView == null){
            var inflater = context.layoutInflater
            rowView = inflater.inflate(R.layout.custom_item_list, null, true)

            holder.campo1 = rowView.findViewById<TextView>(R.id.campo1)
            holder.campo2 = rowView.findViewById<TextView>(R.id.campo2)
            holder.bandera = rowView.findViewById<ImageView>(R.id.bandera)

            rowView.setTag(holder)
        }
        else{
            holder = rowView.tag as ViewHolder
        }

        holder.campo1.text = items.get(position).campo1
        holder.campo2.text = items.get(position).campo2

        if (items.get(position).bandera.equals("uk")){
            holder.bandera.setImageResource(R.drawable.uk_flag)
        }
        else{
            holder.bandera.setImageResource(R.drawable.es)
        }

        return rowView!!
    }

    /*override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_item_list, null, true)

        val bandera = rowView.findViewById(R.id.bandera) as ImageView
        val campo1 = rowView.findViewById<TextView>(R.id.campo1)
        val campo2 = rowView.findViewById(R.id.campo2) as TextView

        campo1.text = items.get(position).campo1
        campo2.text = items.get(position).campo2

        if (items.get(position).bandera.equals("uk")){
            bandera.setImageResource(R.drawable.uk_flag)
        }
        else{
            bandera.setImageResource(R.drawable.es)
        }

        return rowView
    }*/



    override fun getItem(position: Int): Item {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}