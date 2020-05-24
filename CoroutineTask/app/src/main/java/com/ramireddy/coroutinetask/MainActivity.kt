package com.ramireddy.coroutinetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    var country : MutableList<String> = mutableListOf()
    var countryFlag : MutableList<String> = mutableListOf()
    val url : String = "https://corona.lmao.ninja/v2/countries"

    lateinit var rc : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rc = findViewById(R.id.recycler)
        rc.layoutManager=LinearLayoutManager(this)
        getData()
    }
    fun getData()
    {
        CoroutineScope(Dispatchers.IO).launch {
            getApiData(url)
        }
    }

    suspend fun getApiData(url: String)
    {
        val api = URL(url)
        val http : HttpURLConnection = api.openConnection() as HttpURLConnection
        val inp : InputStream = http.inputStream
        val data = inp.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){

            val rootArray = JSONArray(data)
            for (index in 0..rootArray.length()-1)
            {
                val po = rootArray.getJSONObject(index)
                val contryName = po.getString("country")
                val objFlag = po.getJSONObject("countryInfo")
                val flag = objFlag.getString("flag")
                country.add(contryName)
                countryFlag.add(flag)
            }
            // now send data to recyclerview adapter class

            val myAdapter  = MyAdapter(this@MainActivity,country,countryFlag)
            rc.adapter=myAdapter
        }


    }
}
