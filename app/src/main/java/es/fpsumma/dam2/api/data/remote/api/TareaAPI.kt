package es.fpsumma.dam2.api.data.remote.api

import es.fpsumma.dam2.api.data.remote.dto.TareaDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TareaAPI {

    @GET("api/tareas")
    suspend fun listar(): Response<List<TareaDTO>>

    //nuevo endpoint para borrar
    @DELETE("api/tareas/{id}")
    suspend fun borrar(@Path("id") id: Int): Response<Unit>

    //endpoint para obtener el detalle de tarea (GET)
    //uso @Path para reemplazar el {id} en la URL
    @GET("api/tareas/{id}")
    suspend fun obtenerDetalle(@Path("id") id: Int): Response<TareaDTO>

    //endpoint para crear una nueva tarea (POST)
    //uso @Body para enviar el objeto TareaDTO en el cuerpo de la petición
    @POST("api/tareas")
    suspend fun crear(@Body tarea: TareaDTO): Response<TareaDTO>

    //endpoint para actualizar tarea existente (PUT)
    //combino @Path para identificar la tarea y @Body para los nuevos datos
    @PUT("api/tareas/{id}")
    suspend fun actualizar(
        @Path("id") id: Int,
        @Body tarea: TareaDTO
    ): Response<TareaDTO>
}