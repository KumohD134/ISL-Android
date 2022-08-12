package kr.co.kumoh.d134.isl.data

import com.google.gson.annotations.SerializedName

data class ResponseResult (
    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("action")
    val action: String
)