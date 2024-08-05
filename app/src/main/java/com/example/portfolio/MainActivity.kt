package com.example.portfolio

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                // A surface container using the 'background' color from the theme
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Portfolio()
                }

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Portfolio() {


    val isOpen = remember {
        mutableStateOf(false)

    }
    Surface(
        shadowElevation =  8.dp,
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFA1E2EB),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .drawBehind {  }


    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 12.dp)

        ){
            Image(
                painter = painterResource(id = R.drawable.pic1) ,contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider ()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Harshit Mishra", style = androidx.compose.ui.text.TextStyle(
                color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            )
            Text(text ="Android compose Developer",style = MaterialTheme.typography.bodyMedium )
            Spacer(modifier = Modifier.height(12.dp))

            Row() {
                Image(painter = painterResource(id = R.drawable.insta), contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                
                Text(text = "/iharshitmisra", style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp))
            }
            Spacer(modifier = Modifier.height(4.dp))

            Row() {
                Image(painter = painterResource(id = R.drawable.github), contentDescription =null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "/harshitmisra2249", style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)) 
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { isOpen.value = !isOpen.value }) {
                Text(text = "My Projects")
            }
            if(isOpen.value){
                LazyColumn{
                    items(getProjectList()){
                        ProjectItem(it)
                    }
                }

            }


        }

    }

}

@Composable
fun ProjectItem(project:Project) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)){
        Image(painter = painterResource(id = R.drawable.android), contentDescription =null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.bodyMedium)
            Text(text = project.desc,style =MaterialTheme.typography.bodySmall)
            
        }
    }

}
fun getProjectList():List<Project>{
    return listOf(
        Project(name ="Social Media App", desc="Connect with your friends"),
        Project(name ="Media Player App", desc="Listen music endlessly"),
        Project(name ="Gaming Media", desc="God of war Ragnarok lover"),
        Project(name ="Social Media App", desc="Connect with your friends"),
        Project(name ="Media Player App", desc="listen music endlessly"),
        Project(name ="Gaming Media", desc="God of war Ragnarok lover"),
        Project(name ="Social Media App", desc="Connect with your friends"),
        Project(name ="Media Player App", desc="listen music endlessly"),
        Project(name ="Gaming Media", desc="God of war Ragnarok lover"),
        Project(name ="Social Media App", desc="Connect with your friends"),
        Project(name ="Media Player App", desc="listen music endlessly"),  
        
        )
}
data class Project(
    val name:String,val desc:String
)

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        Greeting("Android")
    }
}