import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class Categoria {
    var codigo : String
    var arregloProducto : ArrayList<Producto>
    var nombre: String
    var ultimaActualizacion : Date
    var descripcion : String
    constructor(
        codigos : String,
        nombres : String,
        descripcions : String
    ){
        codigo = codigos
        nombre = nombres
        arregloProducto = arrayListOf()
        ultimaActualizacion =  SimpleDateFormat("dd/mm/yyyy")
            .parse(
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
                    .replace('-','/'))
        descripcion = descripcions
    }
}