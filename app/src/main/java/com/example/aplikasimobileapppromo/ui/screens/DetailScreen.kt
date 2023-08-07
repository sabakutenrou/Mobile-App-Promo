package com.example.aplikasimobileapppromo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.aplikasimobileapppromo.ui.viewmodel.PromoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(id: String, promoViewModel: PromoViewModel, navController: NavController) {

    val promos = promoViewModel.promos.observeAsState().value
    val index = promos?.indexOfFirst {
        it.id == id.toInt()
    }
    val promo = index?.let { promos[it] }

    LazyColumn {
        item {
            Column {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(text = promo?.nama ?: "", fontWeight = FontWeight.Bold)
                    }
                )

                Image(
                    painter = rememberImagePainter(promo?.img?.url),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(200.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = promo?.lokasi ?: "", modifier = Modifier.padding(10.dp))

                    Text(text = promo?.updated_at ?: "", modifier = Modifier.padding(10.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = promo?.desc ?: "", modifier = Modifier.padding(10.dp))

            }
        }
    }

}