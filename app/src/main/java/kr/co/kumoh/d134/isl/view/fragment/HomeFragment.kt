package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.versionedparcelable.ParcelField
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseFragment
import kr.co.kumoh.d134.isl.data.MemberDTO
import kr.co.kumoh.d134.isl.data.board.api.MemberApi
import kr.co.kumoh.d134.isl.databinding.FragmentHomeBinding
import kr.co.kumoh.d134.isl.network.ApiClient
import kr.co.kumoh.d134.isl.network.ApiService
import kr.co.kumoh.d134.isl.view.adapter.ViewPagerAdapter
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel
import okhttp3.FormBody
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

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
            //setDoPageTransformer(pagerDo)
            setDoPageTransformer(pagerGallery)
//            pagerDo.adapter = ViewPagerAdapter(getDoList())
//            pagerDo.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            pagerGallery.adapter = ViewPagerAdapter(getGalleryLoist())
            pagerGallery.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            btnTest.setOnClickListener {
                testAPIGet()
            }

        }
    }

    suspend fun testAPI(){
        val baseURL: String = "http://117.20.209.64:8080/"
        val email: String = "leeyeah8245@gmail.com"
        //var result: HoloUser? = null
        val dto:TestDTO = TestDTO()
        val client = OkHttpClient()
        val url = baseURL + "test/"
        val body: RequestBody = FormBody.Builder().add("title",dto.title).add("content",dto.content).add("createdBy", dto.createdBy).build() as RequestBody
        val request = Request.Builder().url(url).post(body).build()
//        val FBstorage = FirebaseStorage.getInstance()
//        val FBstorageRef = FBstorage.reference

//        CoroutineScope(Dispatchers.IO).async {
//            Log.d("삭제할 프로필 파일", "profile_img/profile_${email.replace(".","")}.jpg")
////            FBstorageRef.child("profile_img/profile_${email.replace(".","")}.jpg")
////                .delete().await()
//            SettingInApp.mAuth.currentUser!!.delete().await()
//        }.await()

        CoroutineScope(Dispatchers.IO).async {  // TODO: 문제 확인
            try {
                Log.d("탈퇴 이메일 확인", email.toString())
                val response = client.newCall(request).execute()   // 동기로 실행
                val str_response = response.body!!.string()   // string()은 딱 한 번만 호출 가능
                Log.d("탈퇴 데이터 정보", "성공: ${str_response}")
                //result = str_response.toBoolean()
            }catch (e:IOException){
                Log.d("탈퇴 통신 정보", "통신 실패(인터넷 끊김 등): ${e}")
            }
        }.await()

    }

    fun testAPIGet(){
        val retrofit: Retrofit = ApiClient.getClient()
        val api = retrofit.create(MemberApi::class.java)
        val callLoadMembers = api.loadMembers()
        callLoadMembers.enqueue(object : Callback<ArrayList<MemberDTO>>{
            override fun onResponse(
                call: Call<ArrayList<MemberDTO>>,
                response: Response<ArrayList<MemberDTO>>
            ) {
                if (response.isSuccessful){
                    Log.d("레트로핏 결과", response.body().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<MemberDTO>>, t: Throwable) {
                Log.d("레트로핏 결과", call.toString()+"t: ${t.toString()}")
            }

        })
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

@Parcelize
data class TestDTO(var title: String = "제목입니다", var content: String ="내용", var createdBy: String ="내가 만듦"): Parcelable