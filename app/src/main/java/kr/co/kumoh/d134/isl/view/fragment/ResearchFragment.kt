package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    val TSP1 = "TSP 최적화 알고리즘"
    val TSP2 = "TSP 최적화 알고리즘"
    val TSP3 = "TSP 최적화 알고리즘"
    val types: List<String> = arrayListOf(TSP1, TSP2, TSP3)

    Surface() {
        LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)) {   // 위쪽부터 정렬
            item {
                Text(
                    text = stringResource(id = R.string.research),
                    color = colorResource(id = R.color.dark_blue),
                    fontSize = 30.sp,
                    style = Nototypography.h1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 10.dp)
                )
            }
            itemsIndexed(types) { idx, type ->
                Box(modifier = Modifier.padding(top = 30.dp)) {
                    Text(
                        text = type,
                        color = Color.White,
                        fontSize = 15.sp,
                        style = Nototypography.h1,
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.dark_blue)
                            )
                            .padding(all = 5.dp)
                    )
                }
                ListDetail(idx)
            }
        }
    }
}

@Composable
private fun ListDetail(idx: Int){
    val configuration = LocalConfiguration.current
    val screenW = configuration.screenWidthDp.dp
    val imageSize: Dp = ((screenW - 72.dp) / 2.dp).dp
    val imges: List<Int> = arrayListOf(
        R.drawable.cat_she_like_rain,
        R.drawable.cat_they_like_eat,
        R.drawable.cat_they_are_happy
    )

    Surface(){
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(1f)
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = imges[idx]),
                contentDescription = "연구 이미지"
            // TODO: 여기서부터~(8/14)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun ShowMembersPV(){
    ShowScreen()
}