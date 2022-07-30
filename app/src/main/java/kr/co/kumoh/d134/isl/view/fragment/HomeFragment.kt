package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseFragment
import kr.co.kumoh.d134.isl.databinding.FragmentHomeBinding
import kr.co.kumoh.d134.isl.view.adapter.ViewPagerAdapter
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>() {
    override val mViewModel by activityViewModels<MainViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun subscribeUi() {
        with(mViewModel) {

        }
        with(mDataBinding) {
            vm = mViewModel
            setDoPageTransformer(pagerDo)
            pagerDo.adapter = ViewPagerAdapter(getDoList())
            pagerDo.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    private fun setDoPageTransformer(pagerDo: ViewPager2){
        // 이동 여백과 튀어나온 정도?
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pager_margin)  // 이미지 사이에 줄 여백
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pager_width) // 이미지 너비
        val screenWidth = resources.displayMetrics.widthPixels // 폰 너비
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        pagerDo.setPageTransformer { page, position ->
            page.translationX = position * (-offsetPx)
        }
        pagerDo.offscreenPageLimit = 1  // 미리 로드되는 개수
    }

    private fun getDoList() : ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.cat_they_like_eat,
            R.drawable.cat_they_are_happy,
            R.drawable.cat_she_like_rain
        )
    }
}