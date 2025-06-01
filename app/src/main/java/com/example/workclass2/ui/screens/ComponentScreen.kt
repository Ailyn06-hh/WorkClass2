package com.example.workclass2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclass2.R
import com.example.workclass2.data.model.MenuModel
import com.example.workclass2.data.model.PostCardModel
import com.example.workclass2.ui.components.PostCardCompactComponent
import com.example.workclass2.ui.components.PostCardComponent
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar

@Composable
fun ComponentScreen(navController: NavHostController){
    Adaptive()
    val menuOptions = arrayOf(
        MenuModel(1, "Buttons", "buttons", Icons.Filled.AddCircle),
        MenuModel(2, "Floating Buttons", "fbuttons", Icons.Filled.AccountCircle),
        MenuModel(3, "Progress", "prog", Icons.Filled.Refresh),
        MenuModel(4, "Chips", "chips", Icons.Filled.AccountBox),
        MenuModel(5, "Sliders", "slide", Icons.Filled.PlayArrow),
        MenuModel(6, "Switches", "switch", Icons.Filled.Check),
        MenuModel(7, "Badges", "badges", Icons.Filled.ShoppingCart),
        MenuModel(8, "Snack Bars", "snack", Icons.Filled.Lock),
        MenuModel(9, "Alert Dialogs", "alert", Icons.Filled.Warning),
        MenuModel(10, "Top app bar", "bar", Icons.Filled.Search),
        MenuModel(11, "Input Fields", "input", Icons.Filled.Check),
        MenuModel(12, "Date Pickers", "date", Icons.Filled.DateRange),
        MenuModel(13, "Pull to Refresh", "refresh", Icons.Filled.Refresh),
        MenuModel (14, "Bottom Sheet", "bsheet", Icons.Filled.Create ),
        MenuModel(15, "Segmented Buttons", "sbuttons", Icons.Filled.ThumbUp)
    )

    var option by rememberSaveable { mutableStateOf("buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet{
            Text("Menu", modifier = Modifier.padding(16.dp))
            HorizontalDivider()
            LazyColumn {
                items(menuOptions) { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.icon, contentDescription = "") },
                        label = { Text(item.title) },
                        selected = false,
                        onClick = {
                            option = item.option
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                }
            }
        }
        }
    ) {
        when(option){
            "buttons" -> { Buttons() }
            "fbuttons" -> { FloatingButtons() }
            "prog" -> { Progress() }
            "chips" -> { Chips() }
            "slide" -> { Sliders() }
            "switch" -> { Switches() }
            "badges" -> { Badges() }
            "snack" -> { SnackBars() }
            "alert" -> { AlertDialogs() }
            "bar" -> { Bars() }
            "input" -> {Inputfields()}
            "date" -> {Datepicker()}
            "refresh" -> { PulltoRefresh() }
            "bsheet"-> {BottomSheet()}
            "sbuttons" -> {SegmentedButtons()}
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun Buttons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        //Button styles
        Button(onClick = {}) {
            Text("Filled")
        }

        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }

        OutlinedButton(onClick = {}) {
            Text("Outline")
        }

        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }

        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        //Extended floating action button can display a text
        ExtendedFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
            Text("Button")
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun Progress(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Chips() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label = { Text("AssistChip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )
        //mutableStateOf is used to keep an element in a particular state
        //even if there's changes or updates in the interface
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            //selected defines if the button is pressed or not
            selected = selected,
            //This will switch the current state
            // of FilterChip to the opposite
            onClick = {selected = !selected},
            label = {Text("Filter Chip")},
            leadingIcon = if(selected){
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            }else {
                null
            }
        )
        InputChipExample("Dismiss", {})

    }
}

@Composable
fun InputChipExample(
    text:String,
    onDismiss: () -> Unit
){
    var enabled by remember{ mutableStateOf(true) }
    if(!enabled) return
    InputChip(
        label = {Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "User Icon",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Cross Icon",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}
//@Preview
@Composable
fun Sliders(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            //updates the slider state according to the users interaction with it
            onValueChange = {SliderPosition = it},
            steps = 10,
            valueRange = 0f .. 100f,
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            text = SliderPosition.toString()
        )
    }
}

//@Preview
@Composable
fun Switches() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {checked = it},
        )
        var checked2 by remember{ mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {checked2 = it},
            //adding an icon that will show only when the switch is active
            thumbContent = if (checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Check Switch",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}
//@Preview
@Composable
fun Badges() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                    {
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart icon"
            )
        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }
}
//@Preview
@Composable
fun SnackBars() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        //val = static
        //var = non static
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }
        //invoking the previous function in a shorter way
        Button(::launchSnackBar){
            Text("Send Message")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
// @Preview
@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        //without "== true" statement, the conditional is checking for the var to be true
        if(showAlertDialog){
            AlertDialog(
                icon = {Icon(Icons.Filled.Info, contentDescription = "Info Icon")},
                title = { Text("Confirm Deletion") },
                text = { Text("Do you really want to delete this file?") },
                //to close the dialog when clicking any part of the screen that is not the Alert Dialog
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = {showAlertDialog = true}) {
            Text("Delete File")
        }
        Text(selectedOption)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //can use MediumTopAppBar and other similar components to change the top bar size.
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            ),
            title = { Text("Screen Title") },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Button")
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings Button"
                    )
                }
            }
        )
        /*
        val arrayPosts = arrayOf(
            PostCardModel(1, "Title 1", "Text 1", R.drawable.geto),
            PostCardModel(2, "Title 2", "Text 2", R.drawable.geto),
            PostCardModel(3, "Title 3", "Text 3", R.drawable.geto),
            PostCardModel(4, "Title 4", "Text 4", R.drawable.geto),
            PostCardModel(5, "Title 5", "Text 5", R.drawable.geto),
            PostCardModel(6, "Title 6", "Text 6", R.drawable.geto),
            PostCardModel(7, "Title 7", "Text 7", R.drawable.geto),
            PostCardModel(8, "Title 8", "Text 8", R.drawable.geto),
            PostCardModel(9, "Title 9", "Text 9", R.drawable.geto)
        )
        //can use Lazy Row to do the same but in a horizontal layout
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            modifier = Modifier
                .fillMaxSize()
                //the 1f value in the .weight modifier is used to spread the components evenly
                .weight(1f)
        ) {
            items(arrayPosts) { item ->
                PostCardComponent(item.id, item.title, item.text, item.image)
            }
        }*/
        Column(
            modifier=Modifier
                .weight(1f)
                .fillMaxSize()
        ){
            Adaptive()
        }
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.secondary
        ){
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "")
            }
        }
    }
}
@Composable
fun Adaptive() {
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    var size = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
}//Compact width <600 dp Phone Portrait
    //Medium width >=600 dp < 840 Tablet Portrait
    // Expanded width >=840 dp Tablet Landscape

    /*//Compact Height < 480 dp Phone Landscape
    //Medium Height >=480 dp < 900 dp Tablet Landscape or Phone Portrait
    //Expanded height >=900 dp Tablet Portrait
   // val arrayPosts = arrayOf(
     //   PostCardModel(1, "Title 1", "Text 1", R.drawable.geto),
   // )
    if (width == WindowWidthSizeClass.COMPACT) {
        //can use Lazy Row to do the same but in a horizontal layout
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(arrayPosts) { item ->
                PostCardComponent(item.id, item.title, item.text, item.iamge)
            }
        }
    } else if (height == WindowHeightSizeClass.COMPACT) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(arrayPosts) { item ->
                PostCardComponent(item.id, item.title, item.text, item.iamge)
            }
        }
    }
}*/
//@Preview(showBackground = true)
@Composable
fun Inputfields (){
    var inputText by rememberSaveable { mutableStateOf ("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            value = inputText,
            onValueChange =
                { inputText = it },
            label =
                { Text("Ingresa texto") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Text(text = "Texto que ingresaste: $inputText", fontSize = 18.sp, color=Color.Magenta)
    }
}
//@Preview(showBackground = true)
@Composable
fun Datepicker () {
    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    var selectedDate by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        },
        year, month, day
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showDatePicker = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text("Select a date", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if (selectedDate.isNotEmpty()) "Date you selected: $selectedDate" else "You have not selected a date",
            fontSize = 18.sp
        )

        if (showDatePicker) {
            datePickerDialog.show()
            showDatePicker = false
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PulltoRefresh() {
    var refreshing by remember { mutableStateOf(false) }
    var items by remember { mutableStateOf(List(10) { "Item ${it + 1}" }) }
    val refreshState = rememberSwipeRefreshState(refreshing)
    LaunchedEffect(refreshing) {
        if (refreshing) {
            delay(2000)
            items = List(10) { "New Item ${it + 1}" }
            refreshing = false
        }
    }
    SwipeRefresh(
        state = refreshState,
        onRefresh = { refreshing = true }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    var showSheet by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showSheet = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text("Show BottomSheet Function", color = Color.White)
        }

    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFc750b9))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello! ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { showSheet = false }) {
                    Text("Close")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SegmentedButtons() {
    var selectedOption by rememberSaveable { mutableStateOf("Option 1") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select an option:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
        ) {
            options.forEach { option ->
                Button(
                    onClick = { selectedOption = option },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedOption == option) Color.Magenta else Color.LightGray,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(option)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Selected: $selectedOption", fontSize = 16.sp)
    }
}






