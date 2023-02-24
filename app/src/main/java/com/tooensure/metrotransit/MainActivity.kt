package com.tooensure.metrotransit

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tooensure.metrotransit.navigation.MetroTransitNavigation
import com.tooensure.metrotransit.ui.theme.MetroTransitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetroTransitTheme {
                MetroTransitApp()
            }
        }
    }
}

@Composable
fun MetroTransitApp()
{
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 46.dp)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            MetroTransitNavigation()
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MetroTransitTheme {
        MetroTransitApp()
    }
}

//val db = Firebase.firestore
//
//// Create a new user with a first and last name
//val user = hashMapOf(
//    "first" to "Ada",
//    "last" to "Lovelace",
//    "born" to 1815
//)
//// Add a new document with a generated ID
//db.collection("users")
//.add(user)
//.addOnSuccessListener { documentReference ->
//    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//}
//.addOnFailureListener { e ->
//    Log.w(TAG, "Error adding document", e)
//}
//// A surface container using the 'background' color from the theme
//Surface(
//modifier = Modifier.fillMaxSize(),
//color = MaterialTheme.colorScheme.background
//) {
//    Greeting("Android")
//}