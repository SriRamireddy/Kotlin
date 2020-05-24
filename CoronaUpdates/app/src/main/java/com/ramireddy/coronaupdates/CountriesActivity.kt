package com.ramireddy.coronaupdates

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class CountriesActivity : AppCompatActivity() {

    val countryNameList : MutableList<String> = mutableListOf()
    var countryTotalCases : MutableList<String> = mutableListOf()
    val countryActivecases : MutableList<String> = mutableListOf()
    var countryTotalDeaths : MutableList<String> = mutableListOf()
    val countryTodayCases : MutableList<String> = mutableListOf()
    var countryTodayDeaths : MutableList<String> = mutableListOf()
    var countryRecovered : MutableList<String> = mutableListOf()
    var countryFlag : MutableList<String> = mutableListOf()

    lateinit var recyclerview : RecyclerView

    val url : String = "https://corona.lmao.ninja/v2/countries"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        setTitle("Country Wise")
        recyclerview = findViewById(R.id.dataSet)
        recyclerview.layoutManager = LinearLayoutManager(this)
        callCoroutines()
    }

    fun callCoroutines(){
        CoroutineScope(Dispatchers.IO).launch {
            getCountryWiseData()
        }
    }

    suspend fun getCountryWiseData() {
        val url = URL(url)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            val root  = JSONArray(text)

            for( i in 0..root.length()-1){
                val po = root.getJSONObject(i)
                val countryName = po.getString("country").toString()
                val forFlag = po.getJSONObject("countryInfo")
                val flagUrl = forFlag.getString("flag").toString()
                val totalcases = po.getString("cases").toString()
                val totaldeaths = po.getString("deaths").toString()
                val totalRecover = po.getString("recovered").toString()
                val active = po.getString("active").toString()
                val todaycases = po.getString("todayCases").toString()
                val todaydeaths = po.getString("todayDeaths").toString()

                countryNameList.add(countryName)
                countryFlag.add(flagUrl)
                countryTotalCases.add(totalcases)
                countryTotalDeaths.add(totaldeaths)
                countryRecovered.add(totalRecover)
                countryActivecases.add(active)
                countryTodayDeaths.add(todaydeaths)
                countryTodayCases.add(todaycases)

        }
            val adapterclass = CountriesAdapter(applicationContext,countryNameList,countryFlag,countryTotalCases,
                countryTotalDeaths,countryRecovered,countryActivecases,countryTodayCases,countryTodayDeaths)
            recyclerview.adapter = adapterclass
        }
    }



    class CountriesAdapter(
        val context: Context,
        countryNameList: MutableList<String>,
        countryFlag: MutableList<String>,
        countryTotalCases: MutableList<String>,
        countryTotalDeaths: MutableList<String>,
        countryRecovered: MutableList<String>,
        countryActivecases: MutableList<String>,
        countryTodayCases: MutableList<String>,
        countryTodayDeaths: MutableList<String>
    ) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>()
    {

        val countryName : MutableList<String> = countryNameList
        var totalCases : MutableList<String> = countryTotalCases
        val activecases : MutableList<String> = countryActivecases
        var totalDeaths : MutableList<String> = countryTotalDeaths
        val todayCases : MutableList<String> = countryTodayCases
        var todayDeaths : MutableList<String> = countryTodayDeaths
        var recovered : MutableList<String> =  countryRecovered
        var cflag : MutableList<String> = countryFlag


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesAdapter.ViewHolder {
            val v : View = LayoutInflater.from(context).inflate(R.layout.countrydesign,parent,false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: CountriesAdapter.ViewHolder, position: Int) {
           holder.contryname.text = countryName.get(position)
           holder.totalcase.text = "Total:"+totalCases.get(position)
           holder.activecases.text ="Active:" +activecases.get(position)
           holder.totldeaths.text = "Deaths:"+totalDeaths.get(position)
           holder.recovered.text = "Recovered:"+recovered.get(position)
           holder.todaycases.text = "Today Cases:"+todayCases.get(position)
           holder.todaydeaths.text = "Today Deaths:"+todayDeaths.get(position)
            Picasso.get().load(cflag.get(position)).into(holder.flag)
        }
        override fun getItemCount(): Int {
            return countryName.size
        }
        class ViewHolder(item : View) : RecyclerView.ViewHolder(item)
        {
            val contryname : TextView = itemView.findViewById(R.id.country_name)
            val totalcase : TextView = itemView.findViewById(R.id.country_total_case)
            val activecases : TextView = itemView.findViewById(R.id.country_total_active)
            val totldeaths : TextView = itemView.findViewById(R.id.country_total_deaths)
            val recovered : TextView = itemView.findViewById(R.id.country_total_recovered)
            val todaycases : TextView = itemView.findViewById(R.id.country_today_cases)
            val todaydeaths : TextView = itemView.findViewById(R.id.country_today_deaths)
            val flag : ImageView = itemView.findViewById(R.id.country_flag)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val ii : Int = item.itemId
        when(ii){
            R.id.symptoms -> {
                startActivity(Intent(this,CovidSymptoms::class.java))
                return true
            }
            R.id.precautions -> {
                startActivity(Intent(this,CovidSymptoms::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
