package com.ramireddy.testonkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView

    val typeList : MutableList<String> = mutableListOf()
    var rateList : MutableList<String> = mutableListOf()

    val url : String = "https://cat-fact.herokuapp.com/facts"

    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.recycler)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = linearLayoutManager
    }

    fun getData(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            getJsonData()
        }
    }

    suspend fun getJsonData() {

        val url = URL(url)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            val root  = JSONObject(text)
            val arrayAll : JSONArray = root.getJSONArray("all")
           // for(i in 0..arrayAll.length()-1) {
            for(i in 0..50) {
                val poObj: JSONObject = arrayAll.getJSONObject(i)
                val datatype : String = poObj.getString("type")
                val datarate : String = poObj.getString("upvotes")
                typeList.add(datatype)
                rateList.add(datarate)
            }
            val toast: Toast = Toast.makeText(this@MainActivity, typeList.size.toString(), Toast.LENGTH_SHORT)
            toast.show()
            val adapter1 = MyRecyclerAdapter(this@MainActivity,typeList,rateList)
            recyclerview.adapter = adapter1
        }
    }



    class MyRecyclerAdapter ( val context : Context,data:MutableList<String>,rate: MutableList<String>):
        RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

        val rMutableList : MutableList<String> =data
        val rMutableRateList : MutableList<String> =rate
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val v : View = LayoutInflater.from(context).inflate(R.layout.design,parent,false)
            return MyViewHolder(v)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            holder.dType.text = rMutableList.get(position).toString()
            //holder.dType.text = "sample "+position
            holder.dRate.text = rMutableRateList.get(position).toString()

        }

        override fun getItemCount(): Int {

            return rMutableList.size
        }

        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
        {
            val dType : TextView = itemView.findViewById(R.id.type)
            val dRate : TextView = itemView.findViewById(R.id.rate)

        }

    }
}
