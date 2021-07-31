package com.example.practice

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat


class CustomAdapter : RecyclerView.Adapter<Holder>(){
    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
    //원래는 뷰하나당 한개씩 해야지만  LayoutInflater으로 특정 xml파일을 개발작 직접 클래스로 변환 LayoutInflater은 화면 요소여서 컨텍스트가 필요 inflate로 레이아웃으로 지정
        return Holder(view)
        //==return Holder(LayoutInflater.form(parent.context).inflate(R.layout.item_recycler,parent,false)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setMemo(memo:Memo){
        itemView.textNo.text="$${memo.no}"//gradle에서 id 'kotlin-android-extensions'추가해야함 삭제한거 보니 쓰면안될거 같긴한데 추후 생각해보자
        itemView.textTitle.text=memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestame)
        itemView.textDate.text = formattedDate
    }


}