@file:Suppress("NAME_SHADOWING")

package com.example.myapplication

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.blueColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNovel()
                }
            }
        }
    }
}

@Composable
fun MyNovel() {
    var userName by remember { mutableStateOf("") }
    var counter by remember { mutableIntStateOf(1) } // Use mutableIntStateOf for counter as well

    when (counter) {
        1 -> MyNovelContent(
            backGround = R.drawable.android1,
            title = stringResource(R.string.my_visual_novel),
            buttonInfo4 = ButtonInfo({ counter = 2 },R.string.start) ,
            )

        2 -> MyNovelContent(
            backGround = R.drawable.android1,
            overlay = R.drawable.mrcat,
            text = stringResource(R.string.hello_my_name_is_jack_and_you),
            buttonInfo4 = ButtonInfo({ counter = 3 },R.string.accept),
            textForField = R.string.name,
            onValueChange = { userName = it }
        )

        3 -> MyNovelContent(
            backGround = R.drawable.android1,
            overlay=R.drawable.mrcat,
            text = stringResource(R.string.great_what_we_are_going_to_do, userName),
            buttonInfo1 = ButtonInfo({ counter = 4 },R.string.walking),
            buttonInfo2 =ButtonInfo({ counter = 5 },R.string.hiking) ,
            buttonInfo3 = ButtonInfo({ counter = 6 },R.string.go_to_field)
            )

        4 -> MyNovelContent(
            backGround = R.drawable.walkingcats,
            text =stringResource( R.string.maybe_go_home),
            buttonInfo1 = ButtonInfo({ counter = 7 },R.string.yes_film),
            buttonInfo2 = ButtonInfo({ counter = 8 },R.string.yes_halloween)
        )

        5 -> MyNovelContent(
            backGround = R.drawable.sittingcats,
            text = stringResource(R.string.getting_dark),
            buttonInfo1 = ButtonInfo({ counter = 7 },R.string.watch_the_film) ,
            buttonInfo2 = ButtonInfo({ counter = 8 },R.string.celebrate_the_halloween)
        )

        6 -> MyNovelContent(
            backGround = R.drawable.coldcat,
            text = stringResource(R.string.go_home),
            buttonInfo1 = ButtonInfo({ counter = 7 },R.string.celebrate_halloween) ,
            buttonInfo2 = ButtonInfo({ counter = 8 },R.string.watch_film)
        )

        7 -> MyNovelContent(
            backGround = R.drawable.catswatch,
            text = stringResource(R.string.like_film),
            buttonInfo1 = ButtonInfo({ counter = 9 },R.string.Like) ,
            buttonInfo2 = ButtonInfo({ counter = 10},R.string.no)
        )

        8 -> MyNovelContent(
            backGround = R.drawable.catswithholloween,
            text = stringResource(R.string.beautiful),
            buttonInfo1 = ButtonInfo({ counter = 7 },R.string.let_s_watch_the_film) ,
            buttonInfo2 = ButtonInfo({ counter = 11},R.string.create_costume)

        )

        9 -> MyNovelContent(
            backGround = R.drawable.catswatch,
            text = stringResource(R.string.time_to_sleep),
            buttonInfo1 = ButtonInfo({ counter = 14 },R.string.too_late),
        )

        10 -> MyNovelContent(
            backGround = R.drawable.catswatch,
            text = stringResource(R.string.maybe_go_home),
            buttonInfo1 = ButtonInfo({ counter = 14 },R.string.yes_it_s_too_late),
        )

        11 -> MyNovelContent(
            backGround = R.drawable.catswithcostume,
            text = stringResource(R.string.like_your_costume ),
            buttonInfo1 = ButtonInfo({ counter = 7 },R.string.your_costume_is_beautiful_too) ,
            buttonInfo2 = ButtonInfo({ counter = 11},R.string.didn_t_like_yours)
        )

        12 -> MyNovelContent(
            backGround = R.drawable.catswithcostume,
            text = stringResource(R.string.go_to_sleep),
            buttonInfo1 = ButtonInfo({ counter = 14 },R.string.its_too_late),
        )

        13 -> MyNovelContent(
            backGround = R.drawable.catswithcostume,
            text = stringResource(R.string.not_taking_offence ),
            buttonInfo1 = ButtonInfo({ counter = 14 },R.string.yes_its_too_late),
        )

        14 -> MyNovelContent(
            backGround = R.drawable.android1,
            title = stringResource(R.string.thank_you_for_playing, userName),
            buttonInfo4 = ButtonInfo({ counter = 1 },R.string.Repeat),
        )

    }
}

data class  ButtonInfo(val onclick:()->Unit,val textResourceId: Int)
@Composable
fun MyNovelContent(
    backGround: Int?,
    overlay: Int?=null,
    title: String?=null,
    text: String?=null,
    buttonInfo1: ButtonInfo?=null,
    buttonInfo2: ButtonInfo?=null,
    buttonInfo3: ButtonInfo?=null,
    buttonInfo4: ButtonInfo?=null,
    textForField: Int?=null,
    onValueChange: (String) -> Unit = {},
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        backGround?.let {
            Image(
                painter = painterResource(backGround),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        overlay?.let {
            Image(
                painter = painterResource(overlay),
                contentDescription = null,
                modifier = Modifier
                    .offset(0.dp, 150.dp)
                    .height(718.dp)
                    .padding(start = 0.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        title?.let {
            Row(
                modifier = Modifier
                    .offset(0.dp, 220.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(blueColor),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        title,
                        fontSize = 30.sp,
                        style = TextStyle(color = Color.White),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }

        text?.let {
            Row(
                modifier = Modifier
                    .offset(0.dp, 350.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 15.dp)
                    .background(Purple40),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text,
                        fontSize = 15.sp,
                        style = TextStyle(color = Color.White),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(1500.dp)
                    )
                }
            }
        }

        textForField?.let {
            var text by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                        onValueChange.invoke(newText)
                    },
                    label = {
                        Text(text = stringResource(R.string.name))
                    },
                    modifier = Modifier
                        .offset(0.dp, 150.dp)
                        .width(500.dp),
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = stringResource(R.string.register_icon)
                            )
                        }
                    }
                )
            }
        }

        buttonInfo1?.let {
            Button(
                onClick = it.onclick,
                colors = ButtonDefaults.buttonColors(blueColor),
                shape = RoundedCornerShape(5),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .offset(0.dp, 130.dp)
            ) {
                Text(stringResource(it.textResourceId))
            }
        }
        buttonInfo2?.let {
            Button(
                onClick = it.onclick,
                colors = ButtonDefaults.buttonColors(blueColor),
                shape = RoundedCornerShape(5),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .offset(0.dp, 210.dp)
            ) {
                Text(stringResource(it.textResourceId))
            }
        }
        buttonInfo3?.let {
            Button(
                onClick = it.onclick,
                colors = ButtonDefaults.buttonColors(blueColor),
                shape = RoundedCornerShape(5),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .offset(0.dp, 300.dp)
            ) {
                Text(stringResource(it.textResourceId))
            }
        }

        buttonInfo4?.let {
            Button(
                onClick = it.onclick,
                colors = ButtonDefaults.buttonColors(Purple40),
                shape = RoundedCornerShape(5),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .offset(0.dp, 270.dp)
            ) {
                Text(stringResource(it.textResourceId))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyNovelPreview() {
    MyApplicationTheme {
        MyNovel()
    }
}