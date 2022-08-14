package kr.co.kumoh.d134.isl.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.view.compose.Nototypography
import kr.co.kumoh.d134.isl.view.viewmodel.MemberViewModel

class MembersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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
    val PROFESSOR = "Professor"
    val MASTER = "Graduate: Master"
    val STUDENT = "Undergraduate\n" + "Student"
    //TODO: muatableState 추가 => 관련 코드 클론 코딩 후
//    val vm: MemberViewModel = viewModel()
//    vm.getMembers()
    val types: List<String> = arrayListOf(PROFESSOR, MASTER, STUDENT)
    val names: List<String> = arrayListOf("이예은", "김민수", "이종렬", "홍건우", "설진영")

    Surface(){
        LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)){   // 위쪽부터 정렬
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
            ) }
            items(types) { type ->
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
                if (type != STUDENT)
                    ListProfessor()
                else{
                    for (i in 1..2) {
                        Row(modifier = Modifier
                            .fillMaxWidth(1f)) {
                            Box(modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.CenterStart) {
                                ListUnderStudent()
                            }
                            Box(modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.CenterEnd) {
                                ListUnderStudent()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ListProfessor(){
    val configuration = LocalConfiguration.current
    val screenW = configuration.screenWidthDp.dp
    val imageSize: Dp = ((screenW - 72.dp) / 2.dp).dp
    
    Surface(modifier = Modifier
        .padding(vertical = 8.dp)
        .shadow(3.dp, shape = RoundedCornerShape(5.dp))
        .fillMaxWidth(1f)
        .height(imageSize)){
        Row {
            Image(
                painter = painterResource(id = R.drawable.member_professor),
                contentDescription = "황준하 교수님",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(imageSize)
                    .height(imageSize)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
            )

            Column() {
                Text(
                    text = "Junha Hwang(황준하)",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = Nototypography.body1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = "부산대학교 컴퓨터공학과 박사 학위\n\n" +
                                "금오공과대학교 컴퓨터공학과 교수 2002~\n\n" +
                                "객체지향 프로그래망과 지능형시스템 분야 강의",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp,
                        style = Nototypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ListUnderStudent(){   // TODO: Member 클래스 인자로 받기
    val configuration = LocalConfiguration.current
    val screenW = configuration.screenWidthDp.dp
    val imageSize: Dp = ((screenW - 72.dp) / 2.dp).dp

    Surface(modifier = Modifier
        .padding(vertical = 8.dp)
        .shadow(3.dp, shape = RoundedCornerShape(5.dp))
        .width(imageSize)
        .height(imageSize * 2)) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.member_professor),
                contentDescription = "황준하 교수님",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(imageSize)
                    .height(imageSize)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
            )
            Text(
                text = "Junha Hwang(황준하)",
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 10.sp,
                style = Nototypography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "부산대학교 컴퓨터공학과 박사 학위\n\n" +
                            "금오공과대학교 컴퓨터공학과 교수 2002~\n\n" +
                            "객체지향 프로그래망과 지능형시스템 분야 강의",
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontSize = 7.sp,
                    style = Nototypography.body2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
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