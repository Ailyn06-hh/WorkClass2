package com.example.workclass2.ui.screens

// Importaciones (sin cambios)
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.workclass2.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun InterfaceLiverpool(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CustomTopBar()
        LocationSection()
        Box(modifier = Modifier.fillMaxWidth()) {
            PromotionalBanner()
            HelpChatButton()
        }
        FeaturedProductsSection()
        DiscountedProductsSection()
        CustomBottomNavigationBar()
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFEC2A89)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            SearchField()
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = Color.Gray)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favoritos", tint = Color.White)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito", tint = Color.White)
            }
        }
    }
}

@Composable
fun SearchField() {
    var searchText = remember { TextFieldValue("") }

    BasicTextField(
        value = searchText,
        onValueChange = { searchText = it },
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White)
            .padding(horizontal = 16.dp),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun LocationSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.LocationOn, contentDescription = "Ubicación", tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Selecciona tu tienda", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromotionalBanner() {
    val image = painterResource(id = R.drawable.tenis)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "Imagen destacada",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.align(Alignment.TopCenter).padding(16.dp)) {
            Text("TENIS CASUALES", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(2.dp))
            Text("Comodidad y estilo en cada paso", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeaturedProductsSection() {
    val images = listOf(R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5)

    Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lo mejor en carriolas para bebés", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) {
                Text("Ver más", color = Color(0xFFEC2A89), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(count = images.size) { index ->
                ProductItem(imageRes = images[index], title = "Carriola Modelo ${index + 1}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiscountedProductsSection() {
    val images = listOf(R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t4, R.drawable.t5)

    Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Oferta en Tecnología", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) {
                Text("Ver más", color = Color(0xFFEC2A89), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(count = images.size) { index ->
                ProductItem(imageRes = images[index], title = "Computadora Modelo ${index + 1}")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ProductItem(imageRes: Int, title: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(4.dp)
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomBottomNavigationBar() {
    val items = listOf(
        Triple("Inicio", Icons.Filled.Home, Color(0xFFEC2A89)),
        Triple("Categorías", Icons.Filled.Search, Color.Gray),
        Triple("Crédito y Ahorro", Icons.Filled.MoreVert, Color.Gray),
        Triple("Servicios", Icons.Filled.Build, Color.Gray),
        Triple("Mi cuenta", Icons.Filled.AccountCircle, Color.Gray)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { (label, icon, color) ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { }
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(imageVector = icon, contentDescription = label, tint = color, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(label, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = color, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelpChatButton() {
    Box(Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {},
            containerColor = Color(0xFFEC2A89),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Filled.Call, contentDescription = "Chat de ayuda", tint = Color.White)
        }
    }
}
