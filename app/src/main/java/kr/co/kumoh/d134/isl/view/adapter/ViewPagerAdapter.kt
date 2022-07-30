package kr.co.kumoh.d134.isl.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kr.co.kumoh.d134.isl.R

class ViewPagerAdapter( // ViewModel에서 데이터 넣기
    private val sliderItems: MutableList<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>(){

    inner class PagerViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.do_list_item , parent, false)
    ) {
        val doImageView = itemView.findViewById<ImageView>(R.id.image_do)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder = PagerViewHolder(parent)

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.doImageView.setImageResource(sliderItems[position])
    }

    override fun getItemCount(): Int = sliderItems.size
}