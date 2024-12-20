package com.example.absenkuy.ui.absensi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.absenkuy.R

@Composable
fun AbsenScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Formulir Absensi",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Drag and Drop / Browse Files
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(186.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .background(Color(0xFFF8F8F8)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_absensi),
                    contentDescription = "Upload Icon",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { /* Browse file logic */ }) {
                    Text(text = "Take Photo")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Cancel logic */ },
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ) {
                Text(text = "Batal", color = Color.White)
            }
            Button(onClick = { /* Submit logic */ }) {
                Text(text = "Kirim")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AbsensiScreenPreview() {
    AbsenScreen()
}
