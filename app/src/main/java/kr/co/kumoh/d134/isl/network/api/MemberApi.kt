package kr.co.kumoh.d134.isl.data.board.api

import kr.co.kumoh.d134.isl.data.MemberDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MemberApi {
    @GET("members")
    fun loadMembers(): Response<ArrayList<MemberDTO>>

    @GET("login.php")
    fun loginCheck(@Query("uid") email: String): Call<String>
}