package kr.co.kumoh.d134.isl.base

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.co.kumoh.d134.isl.data.ResponseResult
import kr.co.kumoh.d134.isl.loading.LoadingDialog
import kr.co.kumoh.d134.isl.util.ErrorUtil
import kr.co.kumoh.d134.isl.util.ResultCodeUtil

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(), BaseContractView {
    protected lateinit var mDataBinding: DB
    abstract val mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        // LiveData 관찰을 위한 세팅.

        mDataBinding.lifecycleOwner = this

        mViewModel.apply {
            isLoading.observe(this@BaseActivity) {
                if (it) {
                    LoadingDialog.shared().showLoading(this@BaseActivity)
                } else {
                    LoadingDialog.shared().hideLoading()
                }
            }

            resReuslt.observe(this@BaseActivity) {
                loadResultCode(it)
            }

            error.observe(this@BaseActivity) {
                loadErrorMessage(it)
            }
        }

        subscribeUi()
    }

    override fun loadResultCode(resResult: ResponseResult?) {
        ResultCodeUtil.setResult(this@BaseActivity, resResult)
    }

    override fun loadErrorMessage(e: Throwable) {
        ErrorUtil.showErrorMessage(this@BaseActivity, null) {}
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // overridePendingTransition etc..
    }
}
