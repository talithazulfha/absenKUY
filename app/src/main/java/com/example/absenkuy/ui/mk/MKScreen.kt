package com.example.absenkuy.ui.mk


import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MKScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mata Kuliah", fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0),
                    titleContentColor = Color.White
                )
            )
        },
        content = {
            MKList(
                mkList = listOf(
                    "Pemrograman Teknologi Bergerak",
                    "Analisis dan Perancangan Sistem Informasi",
                    "E-Business",
                    "Akuisisi Data",
                    "Manajemen Hubungan Pelanggan",
                    "E-Commerce",
                    "Perancangan Sistem Enterprise"
                ),
                navController = navController // Lanjutkan navController ke MKList
            )
        }
    )
}


@Composable
fun MKList(mkList: List<String>, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        mkList.forEach { mk ->
            MKItem(
                mkName = mk,
                navController = navController,
                onClick = { action ->
                    when (action) {
                        "presensi" -> navController.navigate("presensi")
                        "izin" -> navController.navigate("izin")
                    }
                }
            )
        }
    }
}


@Composable
fun MKItem(mkName: String, navController: NavHostController, onClick: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = mkName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Ambil Presensi",
                        fontSize = 14.sp,
                        color = Color(0xFF1565C0),
                        modifier = Modifier.clickable { onClick("presensi") }
                    )
                    Text(
                        text = "Permohonan Izin",
                        fontSize = 14.sp,
                        color = Color(0xFF1565C0),
                        modifier = Modifier.clickable { onClick("izin") }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun MKScreenPreview() {
    MKScreen(navController = rememberNavController())
}



