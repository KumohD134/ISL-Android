package kr.co.kumoh.d134.isl.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseActivity
import kr.co.kumoh.d134.isl.databinding.ActivityAuthBinding
import kr.co.kumoh.d134.isl.view.viewmodel.AuthViewModel

class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>() {
    override val mViewModel: AuthViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_auth

    override fun subscribeUi() {
        with(mViewModel){}
        with(mDataBinding){}
    }
}