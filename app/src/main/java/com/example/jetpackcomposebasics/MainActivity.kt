import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.R
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme() {
                Surface() {
                    MessageCard(Message("Android", "JetpackCompose"))
                }
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
        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style =
                MaterialTheme.typography.bodyLarge
            )
            Surface(shape = MaterialTheme.shapes.medium, tonalElevation = 1.dp) {
                Text(text = msg.body)
            }
        }
    }
}

data class Message(val author: String, val body: String)

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
            MessageCard(msg = Message("Psychology", "The study of human nature"))
        }
    }
}


