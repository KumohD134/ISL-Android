package kr.co.kumoh.d134.isl.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.kumoh.d134.isl.base.BaseViewModel
import kr.co.kumoh.d134.isl.data.MemberDTO
import kr.co.kumoh.d134.isl.repository.BoardRepository

class MemberViewModel(private val repository: BoardRepository) : BaseViewModel(){
    private val _membersResponse = MutableLiveData<ArrayList<MemberDTO>>()
    val memberResponse: LiveData<ArrayList<MemberDTO>> = _membersResponse

    fun getMembers(){
        viewModelScope.launch {
            val response = repository.getMembers()

            if (response.isSuccessful)
                _membersResponse.postValue(response.body())
            else
                observeErrorMessage(Exception(response.message()))
        }
    }

}