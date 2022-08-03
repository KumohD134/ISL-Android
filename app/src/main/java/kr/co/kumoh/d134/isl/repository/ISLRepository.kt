package kr.co.kumoh.d134.isl.repository

import javax.inject.Inject

class ISLRepository @Inject constructor(
) : ISLInterface {
    override fun test(): String {
        return "test"
    }
}