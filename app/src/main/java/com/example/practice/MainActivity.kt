package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data:MutableList<Memo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData= data
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        var input = HashMap<String, String>()
        input["college"] = "TEST"
        RetrofitBuilder.api.post(input).enqueue(object: Callback<RoomsData> {
            override fun onResponse(call: Call<RoomsData>, response: Response<RoomsData>) {
                if(response.isSuccessful) {
                    Log.d("test", "연결성공")
                    var a: RoomsData = response.body()!!
                    Log.d("test", a.rooms[0].seat[0][0].toString())
                }
            }

            override fun onFailure(call: Call<RoomsData>, t: Throwable) {
               Log.d("test", "연결실패")
            }

        })
    }
    fun loadData():MutableList<Memo>{
        val data:MutableList<Memo> = mutableListOf()
        for(no in 1..100)
        {
            val title = "이것이 코틀린 안드로이다 ${no+1}"
            val date = System.currentTimeMillis()
            var memo = Memo(no,title,date)
            data.add(memo)
        }
        return data
    }
}
