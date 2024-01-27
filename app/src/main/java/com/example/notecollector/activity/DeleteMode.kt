package com.example.notecollector.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup


@Composable
fun DeleteConfirmation(popShow :(Boolean)->Unit, confirmation:(Boolean)->Unit ){

    Popup() {

        Surface(modifier = Modifier.fillMaxSize(), color = Color.Black.copy(alpha = 0.5f)) {

            Column (modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){

                Card(modifier = Modifier
                    .fillMaxWidth().padding(8.dp)) {

                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = "Sure about this? Confirm deletion??",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {

                            Button(onClick = { popShow(false)
                                             confirmation(true)},
                                modifier = Modifier.width(150.dp)) {

                                Text(text = "Yes, delete it", style = MaterialTheme.typography.titleMedium)
                                
                            }
                            Button(onClick = { popShow(false)
                                             confirmation(false)},
                                modifier = Modifier.width(150.dp)) {

                                Text(text = "No, keep it", style = MaterialTheme.typography.titleMedium)
                                
                            }

                        }
                    }





                }


            }



        }
    }
}