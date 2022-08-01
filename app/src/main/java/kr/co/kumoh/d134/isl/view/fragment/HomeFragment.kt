package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseFragment
import kr.co.kumoh.d134.isl.databinding.FragmentHomeBinding
import kr.co.kumoh.d134.isl.view.adapter.ViewPagerAdapter
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>(), OnMapReadyCallback {
    private val latitude: Double = 36.1455306
    private val longitude: Double = 128.3924596

    override val mViewModel by activityViewModels<MainViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun subscribeUi() {
        with(mViewModel) {

        }
        with(mDataBinding) {
            vm = mViewModel
            setDoPageTransformer(pagerDo)
            setDoPageTransformer(pagerGallery)
            pagerDo.adapter = ViewPagerAdapter(getDoList())
            pagerDo.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            pagerGallery.adapter = ViewPagerAdapter(getGalleryLoist())
            pagerGallery.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDataBinding.mapHome.onCreate(savedInstanceState)
        mDataBinding.mapHome.getMapAsync(this@HomeFragment)
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

    private fun getGalleryLoist() : ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.home_gallery1,
            R.drawable.home_gallery2,
            R.drawable.home_gallery3,
            R.drawable.home_gallery4,
            R.drawable.home_gallery5,
        )
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val marker = LatLng(latitude,longitude)
        val gMap = googleMap

        gMap?.uiSettings?.isMapToolbarEnabled = false
        gMap?.addMarker(MarkerOptions().position(marker).title("ISL"))
        gMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,15f))
    }

    // 생명 주기 맞춰주기
    override fun onStart() {
        super.onStart()
        mDataBinding.mapHome.onStart()
    }
    override fun onStop() {
        super.onStop()
        mDataBinding.mapHome.onStop()
    }
    override fun onResume() {
        super.onResume()
        mDataBinding.mapHome.onResume()
    }
    override fun onPause() {
        super.onPause()
        mDataBinding.mapHome.onPause()
    }
    override fun onLowMemory() {
        super.onLowMemory()
        mDataBinding.mapHome.onLowMemory()
    }
}