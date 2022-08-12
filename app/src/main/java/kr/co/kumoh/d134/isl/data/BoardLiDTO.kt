package kr.co.kumoh.d134.isl.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import java.util.*
import kotlin.collections.ArrayList

/*
이름의 변경이 없는 경우에도 @SerializedName 어노테이션을 붙이는 것이 좋다.
그 이유는 애플리케이션을 Release 할 때 소스 코드가 난독화 되는 과정에서 Java 필드가 변환되고,
이로 인해 Gson 매핑에 오작동이 일어날 수 있기 때문.
*/
@Serializable
data class BoardLiDTO(
    @SerializedName("dtoList")
    val dtoList: ArrayList<post>,
    @SerializedName("end")
    val end: Int,
    @SerializedName("next")
    val next: Boolean,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pageList")
    val pageList: ArrayList<Int>,
    @SerializedName("prev")
    val prev: Boolean,
    @SerializedName("size")
    val size: Int,
    @SerializedName("start")
    val start: Int,
    ){
    @Serializable
    data class post(
        @SerializedName("commentCount")
        val commentCount: Int,
        @SerializedName("createBy")
        val createBy: String,
        @SerializedName("fileCount")
        val fileCount: Int,
        @SerializedName("hit")
        val hit: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("registerDate")
        val registerDate: Date,
        @SerializedName("title")
        val title: String
    )
}