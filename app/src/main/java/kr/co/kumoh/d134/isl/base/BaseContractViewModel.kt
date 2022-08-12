package kr.co.kumoh.d134.isl.base

import kr.co.kumoh.d134.isl.data.ResponseResult

interface BaseContractViewModel {
    fun observeResultCode(resResult: ResponseResult?)
    fun observeErrorMessage(e: Throwable)
}