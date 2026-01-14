package es.fpsumma.dam2.api.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import es.fpsumma.dam2.api.ui.screen.tareas.DetalleTareaRoomRoute
import es.fpsumma.dam2.api.ui.screen.tareas.ListadoTareasRemoteRoute
import es.fpsumma.dam2.api.ui.screen.tareas.ListadoTareasRoomRoute
import es.fpsumma.dam2.api.ui.screen.tareas.NuevaTareaRoomRoute
import es.fpsumma.dam2.api.viewmodel.TareasRemoteViewModel
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    tareasViewModel: TareasViewModel,
    remoteViewModel: TareasRemoteViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.TAREA_LISTADO_API //lo cambio para probar
    ) {

        composable(Routes.TAREA_LISTADO) {
            ListadoTareasRoomRoute(navController, tareasViewModel)
        }

        //nueva ruta
        composable(Routes.TAREA_LISTADO_API) {
            ListadoTareasRemoteRoute(navController, remoteViewModel)
        }

        // Resto de composables (ADD, VIEW)...
        composable(Routes.TAREA_ADD) {
            NuevaTareaRoomRoute(navController, tareasViewModel)
        }

        composable(
            route = Routes.TAREA_VIEW,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetalleTareaRoomRoute(id, navController, tareasViewModel)
        }
    }
}