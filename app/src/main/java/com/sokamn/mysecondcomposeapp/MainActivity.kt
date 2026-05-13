package com.sokamn.mysecondcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.sokamn.mysecondcomposeapp.components.MyCustomDialog
import com.sokamn.mysecondcomposeapp.components.animation.MyInfiniteTransition
import com.sokamn.mysecondcomposeapp.components.model.PokemonCombat
import com.sokamn.mysecondcomposeapp.ui.theme.MySecondComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySecondComposeAppTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                val pokemonCombat = PokemonCombat("Totodile", "Charmander")
                var showDialog by remember { mutableStateOf(false) }

                MyCustomDialog(
                    pokemonCombat = pokemonCombat,
                    showDialog = showDialog,
                    onStartCombat = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Inició el combate",
                                actionLabel = "Cancelar combate"
                            )
                        }
                        showDialog = false
                    }
                ) { showDialog = false }

                MyInfiniteTransition()

                //NavigationWrapper()

                /*MyModalDrawer(drawerState, onCloseNav = { scope.launch { drawerState.close() } }) {

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        floatingActionButton = { MyFAB { showDialog = true } },
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = { MyNavigationBar() }
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(Color.LightGray),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {*/

                            /*Text("Esta es mi Screen", modifier = Modifier.clickable{
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Ejemplo",
                                        actionLabel = "Deshacer"
                                    )

                                    if(result == SnackbarResult.ActionPerformed){
                                        // PULSÓ DESHACER
                                    }else{
                                        // NO HIZO NADA
                                    }
                                }
                            })*/

                            //MyInteractionSource(Modifier.padding(innerPadding))
                            //MyLaunchEffect { Log.i("CRONO", "HA FINALIZADO") }
                            //MyDerivedStateOf(Modifier.padding(innerPadding))

                            /*MyBasicList() { name ->
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = name,
                                        actionLabel = "Okay",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }*/

                            //MyGridList()
                        //}

                    //}
                //}
            }
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

@Preview(
    widthDp = 125,
    heightDp = 20,
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    MySecondComposeAppTheme {
        Greeting("Android")
    }
}