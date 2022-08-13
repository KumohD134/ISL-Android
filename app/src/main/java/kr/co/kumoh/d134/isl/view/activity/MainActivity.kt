package kr.co.kumoh.d134.isl.view.activity

import android.util.Log
import android.view.Gravity
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseActivity
import kr.co.kumoh.d134.isl.data.ResponseResult
import kr.co.kumoh.d134.isl.databinding.ActivityMainBinding
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel

@AndroidEntryPoint  // 해당 클래스에 dependency를 제공해줄 수 있는 component 생성
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    lateinit var navController : NavController

    override val mViewModel: MainViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun subscribeUi() {
        with(mViewModel) {

        }
        with(mDataBinding) {
            vm = mViewModel
            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)
            val actionBar = supportActionBar
            actionBar?.apply {
                setDisplayShowCustomEnabled(true)
                setDisplayShowTitleEnabled(false)
                setDisplayHomeAsUpEnabled(true)
            }

            navView.itemIconTintList = null

            val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHost.findNavController()
            navView.setupWithNavController(navController)

            toolbar.setNavigationOnClickListener {
                changeDrawer()
            }
        }
    }

    override fun onBackPressed() {
        if (mDataBinding.drawerLayout.isDrawerOpen(Gravity.LEFT))
            mDataBinding.drawerLayout.closeDrawer(Gravity.LEFT)
        else    // TODO: 초 시간 정의
            super.onBackPressed()
    }

    fun changeDrawer(){
        if(!mDataBinding.drawerLayout.isDrawerOpen(Gravity.LEFT)){
            mDataBinding.drawerLayout.openDrawer(Gravity.LEFT)

        }else {
            mDataBinding.drawerLayout.closeDrawer(Gravity.LEFT)
        }
    }

    override fun loadResultCode(resResult: ResponseResult?) {
    }

    override fun loadErrorMessage(e: Throwable) {
    }

}