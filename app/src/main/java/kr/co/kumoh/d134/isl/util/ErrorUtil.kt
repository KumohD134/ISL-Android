package kr.co.kumoh.d134.isl.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import kr.co.kumoh.d134.isl.R

/**
 * Created by KimBH on 2022/07/12.
 */
class ErrorUtil {

    companion object {
        fun showErrorMessage(context: Context, message: String?, function: () -> Unit) {
            AlertDialog.Builder(context)
                .setMessage(message ?: context.getString(R.string.service_error))
                .setCancelable(false)
                .setPositiveButton(R.string.confirm) { dialog, _ ->
                    function()
                    dialog.cancel() }
                .show()
                .setCanceledOnTouchOutside(false)
        }
    }
}