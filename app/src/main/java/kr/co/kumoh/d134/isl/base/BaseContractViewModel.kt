package kr.co.kumoh.d134.isl.base

interface BaseContractViewModel {
    fun observeResultCode(resResult: ResponseResult?)
    fun observeErrorMessage(e: Throwable)
}