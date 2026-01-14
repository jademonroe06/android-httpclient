package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel
) {
    NuevaTareaContent(
        onBack = { navController.popBackStack() },
        onSave = { titulo, descripcion ->
            vm.addTarea(titulo, descripcion)
            navController.navigate(Routes.TAREA_LISTADO) {
                //"popUpTo" se usa para limpiar la pila para que no se pueda volver atrás a "crear"
                popUpTo(Routes.TAREA_LISTADO) { inclusive = true }
            }
        }
    )
}