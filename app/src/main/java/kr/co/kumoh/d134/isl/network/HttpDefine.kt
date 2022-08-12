package kr.co.kumoh.d134.isl.network

class HttpDefine {

    companion object {
        // Server define
        private const val SERVICE = 0       // 서비스 서버
        private const val DEV = 1           // 테스트 서버

        // Current
        private var CURRENT_SERVER: Int = DEV

        fun getHost(): String = when (CURRENT_SERVER) {
            SERVICE -> SERVICE_SERVER_HOST
            DEV -> DEV_SERVER_HOST
            else -> SERVICE_SERVER_HOST
        }

        // Ticket Server url
        private var SERVICE_SERVER_HOST = "https://api.test.co.kr"
        private var DEV_SERVER_HOST = "http://117.20.209.64:8080/"  // 이종렬 선배 서버

        // Api url
        const val INIT = "/init"
    }
}