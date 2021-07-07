import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Producto {
    var nombre: String
    var precio: Double
    var cantidad: Int
    var descripcion : String
    var fecha : Date
    constructor(
        nombrep: String,
        preciop: Double,
        cantidadp: Int,
        descripcionp: String = "Sin descripción"

    ){
        nombre = nombrep
        precio = preciop
        cantidad = cantidadp
        descripcion = descripcionp
        fecha = SimpleDateFormat("dd/mm/yyyy")
            .parse(
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
                    .replace('-','/'))
    }
}