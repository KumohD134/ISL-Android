package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.view.activity.MainActivity

class GalleryFragment : Fragment() {
    lateinit var mActivity: MainActivity
    lateinit var btnSearch: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mActivity = activity as MainActivity
        btnSearch = mActivity.findViewById<Button>(R.id.btn_search_bar)
        btnSearch.visibility = View.VISIBLE
        return ComposeView(requireContext()).apply {
            setContent {
                showScreen()
            }
        }
    }

    override fun onDestroyView() {
        btnSearch.visibility = View.GONE
        super.onDestroyView()
    }
}

@Composable
fun showScreen(){

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun showScreenPV(){
    showScreen()
}