package com.example.aplikasimobileapppromo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.aplikasimobileapppromo.domain.items.PromoItem
import com.example.aplikasimobileapppromo.ui.nav.Screens
import com.example.aplikasimobileapppromo.ui.viewmodel.PromoViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(promoViewModel: PromoViewModel, navController: NavController) {

    val promos = promoViewModel.promos.observeAsState(listOf()).value

    Scaffold {
        if (promos.isEmpty()) {
            Text(
                text = "loading",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Promo",
                    style = MaterialTheme.typography.titleLarge
                )
                LazyColumn {
                    items(promos) {promo ->
                        PromoCard(promo = promo, navController = navController)
                    }
                }
            }

        }
        


    }

}

@Composable
fun PromoCard(promo: PromoItem, navController: NavController) {
    Card(
//        elevation = 7.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${promo.id}")
            }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Image(painter = rememberImagePainter(promo.img.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(text = promo.nama, style = MaterialTheme.typography.titleMedium)
                Text(text = promo.desc, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }

        }
    }
}