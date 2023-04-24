package com.example.composetest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest.ui.theme.ComposeTestTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {






        }
    }
}



@Composable
fun Greeting() {
    var permission= buildAnnotatedString {
        append("勾选即代表同意")
        pushStringAnnotation("user","http://baidu.com")
        withStyle(style = SpanStyle(color = Color.Green, textDecoration = TextDecoration.Underline)){
            append("用户协议")
        }
        pop()
        append("和")
        pushStringAnnotation("yinSi","http://baidu.com2")
        withStyle(style = SpanStyle(color = Color.Green, textDecoration = TextDecoration.Underline)){
            append("隐私政策")
        }
        pop()


    }

    ClickableText(text =permission , onClick ={
        num->
        permission.getStringAnnotations("user", start = num, end = num).firstOrNull()
            ?.let {
                it->

                    Log.e("======","${it.item}")


            }
        permission.getStringAnnotations("yinSi",num,num).firstOrNull()
            ?.let { it->
                run {

                    Log.e("======", "${it.item}")
                }

            }


    })

}

@Preview(showBackground = true, showSystemUi = true,)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        Greeting()
    }
}