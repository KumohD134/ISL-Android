package kr.co.kumoh.d134.isl.base

import kr.co.kumoh.d134.isl.data.ResponseResult

interface BaseContractView {
    fun subscribeUi()
    fun getLayoutRes(): Int
    fun loadResultCode(resResult: ResponseResult?)
    fun loadErrorMessage(e: Throwable)
}