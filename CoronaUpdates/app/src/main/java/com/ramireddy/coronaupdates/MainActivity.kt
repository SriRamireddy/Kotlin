package com.ramireddy.coronaupdates

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var totalCase : TextView
    lateinit var totalRecovery : TextView
    lateinit var totalActiveCase : TextView
    lateinit var totalCriticalCases : TextView
    lateinit var totalDeaths : TextView
    lateinit var todayDeaths : TextView
    lateinit var todayCases : TextView
    lateinit var totalEffectedCountries : TextView
    val url : String = "https://corona.lmao.ninja/v2/all"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        totalCase = findViewById(R.id.total_cases)
        totalRecovery = findViewById(R.id.total_recovered)
        totalActiveCase = findViewById(R.id.total_active_cases)
        totalCriticalCases = findViewById(R.id.total_critical_cases)
        totalDeaths = findViewById(R.id.total_deaths)
        todayDeaths = findViewById(R.id.today_deaths)
        todayCases = findViewById(R.id.today_cases)
        totalEffectedCountries = findViewById(R.id.total_effected_countries)
        callCoroutines()

    }

    fun gotoCounties(view: View) {
        startActivity(Intent(this,CountriesActivity::class.java))
    }

    fun callCoroutines(){
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
            totalCase.text ="Total Cases \n" + root.getString("cases")
            totalRecovery.text ="Total Recover \n"+ root.getString("recovered")
            totalActiveCase.text = "Active Cases \n"+root.getString("active")
            totalCriticalCases.text = "Critical Cases \n"+root.getString("critical")
            totalDeaths.text = "Total Deaths \n"+root.getString("deaths")
            todayDeaths.text = "Today Deaths \n"+root.getString("todayDeaths")
            todayCases.text = "Today Cases \n"+root.getString("todayCases")
            totalEffectedCountries.text = "Effected Countries \n"+root.getString("affectedCountries")

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.forrefresh,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val ii : Int = item.itemId
       when(ii){
           R.id.refresh -> {
               callCoroutines()
               return true
           }
        }
        return super.onOptionsItemSelected(item)
    }
}
