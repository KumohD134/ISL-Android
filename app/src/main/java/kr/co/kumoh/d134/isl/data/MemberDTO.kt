package kr.co.kumoh.d134.isl.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class MemberDTO(
    @SerializedName("degree")
    val degree: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("englishName")
    val englishName: String?,
    @SerializedName("fieldOfInterest")
    val fieldOfInterest: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imagePath")
    val imagePath: String?,
    @SerializedName("koreanName")
    val koreanName: String?,
    @SerializedName("yearOfEntry")
    val yearOfEntry: String?,
    @SerializedName("yearOfRetirement")
    val yearOfRetirement: String?
)