package kr.co.kumoh.d134.isl.network

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("login.php")
    fun loginCheck(@Query("uid") email: String): Call<String>
}