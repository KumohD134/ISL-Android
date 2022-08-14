package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import kr.co.kumoh.d134.isl.view.activity.MainActivity
import kr.co.kumoh.d134.isl.view.compose.Nototypography

class GalleryFragment : Fragment() {
    private lateinit var mActivity: MainActivity
    private lateinit var btnSearch: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mActivity = activity as MainActivity
        btnSearch = mActivity.findViewById<Button>(R.id.btn_search_bar)
        btnSearch.visibility = View.VISIBLE
        return ComposeView(requireContext()).apply {
            setContent {
                ShowScreen()
            }
        }
    }

    override fun onDestroyView() {
        btnSearch.visibility = View.GONE
        super.onDestroyView()
    }
}

@Composable
private fun ShowScreen(){   // TODO: 화면 이동 시, 화면 선택 코드
    Surface {
        Screen()
    }
}

@Composable
private fun Screen(){   // TODO: remember 쓰기
    val title = "갤러리 제목"
    val date = "2022-08-07"
    Surface(){
        LazyColumn(){   // 위쪽부터 정렬
            item { Text(
                text = stringResource(id = R.string.gallery),
                color = colorResource(id = R.color.dark_blue),
                fontSize = 30.sp,
                style = Nototypography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(vertical = 10.dp)
            ) }
            item {  // TODO: items 쓰기(for문 삭제)
                for (i in 1..5) {
                ListGallery(title, date)
                }
            }
        }
    }
}

@Composable
private fun ListGallery(title : String, date : String){
    val configuration = LocalConfiguration.current
    val screenW = configuration.screenWidthDp.dp    // 현재 기기의 가로 dp 받아 옴
    val imageSize: Dp = ((screenW - 34.dp) / 2.dp).dp

    Surface(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)){
        Row(modifier = Modifier.fillMaxWidth(1f)) {
            for (j in 1..2) {
                Column(modifier = Modifier
                    .width(imageSize)
                    .padding(horizontal = 8.dp, vertical = 8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.home_gallery2),
                        contentScale = ContentScale.Crop,
                        contentDescription = title,
                        modifier = Modifier
                            .width(imageSize)
                            .height(imageSize)

                    )
                    Text(
                        text = title,
                        color = Color.Black,
                        fontSize = 10.sp,
                        style = Nototypography.body1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(1f)
                    )
                    Text(
                        text = date,
                        color = Color.Black,
                        fontSize = 8.sp,
                        style = Nototypography.body2,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(1f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun ShowScreenPV(){
    ShowScreen()
}