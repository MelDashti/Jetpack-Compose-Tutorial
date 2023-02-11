import android.content.res.Configuration
import android.os.Bundle
import android.provider.Telephony.Sms.Conversations
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.jetpackcomposestartertutorial2.R
import com.example.jetpackcomposestartertutorial2.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme() {
//                Surface() {
//                    val conversationSample = listOf(
//                        Message(
//                            "Colleague",
//                            "Test...Test...Test..."
//                        ),
//                        Message(
//                            "Colleague",
//                            "List of Android versions:\n" +
//                                    "Android KitKat (API 19)\n" +
//                                    "Android Lollipop (API 21)\n" +
//                                    "Android Marshmallow (API 23)\n" +
//                                    "Android Nougat (API 24)\n" +
//                                    "Android Oreo (API 26)\n" +
//                                    "Android Pie (API 28)\n" +
//                                    "Android 10 (API 29)\n" +
//                                    "Android 11 (API 30)\n" +
//                                    "Android 12 (API 31)\n"
//                        ),
//                        Message(
//                            "Colleague",
//                            "I think Kotlin is my favorite programming language.\n" +
//                                    "It's so much fun!"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Searching for alternatives to XML layouts..."
//                        ),
//                        Message(
//                            "Colleague",
//                            "Hey, take a look at Jetpack Compose, it's great!\n" +
//                                    "It's the Android's modern toolkit for building native UI." +
//                                    "It simplifies and accelerates UI development on Android." +
//                                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
//                        ),
//                        Message(
//                            "Colleague",
//                            "It's available from API 21+ :)"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Android Studio next version's name is Arctic Fox"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
//                        ),
//                        Message(
//                            "Colleague",
//                            "I didn't know you can now run the emulator directly from Android Studio"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Compose Previews are great to check quickly how a composable layout looks like"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Previews are also interactive after enabling the experimental setting"
//                        ),
//                        Message(
//                            "Colleague",
//                            "Have you tried writing build.gradle with KTS?"
//                        )
//                    )
//                    Conversation(messages = conversationSample)
//                    MessageCard(Message("Android", "JetpackCompose"))
//                }
            }
        }
    }
}

@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "" +
                    "Contact Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // isExpanded is used to keep track of expanded state.
        var isExpanded by remember { mutableStateOf(false) }

        // we toggle isExpanded when user clicks on column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style =
                MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, tonalElevation = 1.dp) {
                Text(
                    text = msg.body, modifier = Modifier.padding(all = 4.dp),
                    //if the is message is expanded, all the content is displayed.
                    // otherwise only the first line is displayed.
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


//you cannot preview composable functions with parameters directly so we create a new function
@Preview
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun previewComposableFunc() {
    JetpackComposeBasicsTheme() {
        Surface() {
            val conversationSample = listOf(
                Message(
                    "Colleague",
                    "Test...Test...Test..."
                ),
                Message(
                    "Colleague",
                    "List of Android versions:\n" +
                            "Android KitKat (API 19)\n" +
                            "Android Lollipop (API 21)\n" +
                            "Android Marshmallow (API 23)\n" +
                            "Android Nougat (API 24)\n" +
                            "Android Oreo (API 26)\n" +
                            "Android Pie (API 28)\n" +
                            "Android 10 (API 29)\n" +
                            "Android 11 (API 30)\n" +
                            "Android 12 (API 31)\n"
                ),
                Message(
                    "Colleague",
                    "I think Kotlin is my favorite programming language.\n" +
                            "It's so much fun!"
                ),
                Message(
                    "Colleague",
                    "Searching for alternatives to XML layouts..."
                ),
                Message(
                    "Colleague",
                    "Hey, take a look at Jetpack Compose, it's great!\n" +
                            "It's the Android's modern toolkit for building native UI." +
                            "It simplifies and accelerates UI development on Android." +
                            "Less code, powerful tools, and intuitive Kotlin APIs :)"
                ),
                Message(
                    "Colleague",
                    "It's available from API 21+ :)"
                ),
                Message(
                    "Colleague",
                    "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
                ),
                Message(
                    "Colleague",
                    "Android Studio next version's name is Arctic Fox"
                ),
                Message(
                    "Colleague",
                    "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
                ),
                Message(
                    "Colleague",
                    "I didn't know you can now run the emulator directly from Android Studio"
                ),
                Message(
                    "Colleague",
                    "Compose Previews are great to check quickly how a composable layout looks like"
                ),
                Message(
                    "Colleague",
                    "Previews are also interactive after enabling the experimental setting"
                ),
                Message(
                    "Colleague",
                    "Have you tried writing build.gradle with KTS?"
                )
            )
            Conversation(messages = conversationSample)
        }
    }
}


