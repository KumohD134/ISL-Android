package kr.co.kumoh.d134.isl.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by KimBH on 2021/10/18.
 */
class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {    // 공통된 헤더값 등을 넣을 수 있음
        val original = chain.request()
        val request = original.newBuilder()
            .build()

        return chain.proceed(request)   // 서버로부터 온 요청값 반환
    }
}