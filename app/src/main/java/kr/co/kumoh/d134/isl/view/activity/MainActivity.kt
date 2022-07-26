package kr.co.kumoh.d134.isl.view.activity

import android.util.Log
import android.view.Gravity
import androidx.activity.viewModels
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseActivity
import kr.co.kumoh.d134.isl.base.ResponseResult
import kr.co.kumoh.d134.isl.databinding.ActivityMainBinding
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun subscribeUi() {
        with(mViewModel) {

        }
        with(mDataBinding) {
            vm = mViewModel
            drawerLayout.closeDrawers()
            btnDrawer.setOnClickListener { changeDrawer() }
        }
    }

    fun changeDrawer(){
        Log.d("서랍 엶","작동")
        if(!mDataBinding.drawerLayout.isDrawerOpen(Gravity.LEFT)){
            mDataBinding.drawerLayout.openDrawer(Gravity.LEFT)
        }else
            mDataBinding.drawerLayout.closeDrawer(Gravity.LEFT)
    }

    override fun loadResultCode(resResult: ResponseResult?) {
    }

    override fun loadErrorMessage(e: Throwable) {
    }

}