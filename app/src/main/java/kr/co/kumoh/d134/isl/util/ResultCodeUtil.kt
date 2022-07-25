package kr.co.kumoh.d134.isl.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.ResponseResult
import kr.co.kumoh.d134.isl.util.ResultCodeUtil

/**
 * Created by KimBH on 2022/07/12.
 */
class ResultCodeUtil {

    companion object {
        // RESULT_CODE..


        fun setResult(context: Context, result: ResponseResult?) {
            result?.apply {
                when(code) {

                }
            }
        }

        private fun showAlert(context: Context, message: String, function: () -> Unit) {
            AlertDialog.Builder(context)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.confirm) { dialog, _ ->
                    function()
                    dialog.cancel()
                }
                .show()
                .setCanceledOnTouchOutside(false)
        }
    }
}