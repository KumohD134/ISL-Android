package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.view.compose.Nototypography

class ResearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ShowScreen()
            }
        }
    }
}

@Composable
private fun ShowScreen(){
    Surface {
        Screen()
    }
}

@Composable
private fun Screen(){
    Surface() {
        LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)) {   // 위쪽부터 정렬
            item {
                Text(
                    text = "Members",
                    color = colorResource(id = R.color.dark_blue),
                    fontSize = 30.sp,
                    style = Nototypography.h1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun ShowMembersPV(){
    ShowScreen()
}