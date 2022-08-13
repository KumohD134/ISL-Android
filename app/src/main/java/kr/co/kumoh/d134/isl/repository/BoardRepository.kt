package kr.co.kumoh.d134.isl.repository

import kr.co.kumoh.d134.isl.data.board.api.MemberApi
import kr.co.kumoh.d134.isl.network.ApiClient
import retrofit2.create

class BoardRepository {
    private val memberApi : MemberApi = ApiClient
        .getClient()
        .create(MemberApi::class.java)

    suspend fun getMembers () = memberApi.loadMembers()
}