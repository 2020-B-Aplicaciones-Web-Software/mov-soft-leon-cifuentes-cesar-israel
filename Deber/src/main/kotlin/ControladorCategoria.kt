import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File

class ControladorCategoria {

    fun abrirVista(){
        val menu = VistaCategoría()
        menu.isResizable = false
        menu.isVisible = true
    }

    fun borrarCategoria(nombre:String,codigo:String){
        var categorias = listar()
        val respuestaFilter: List<Categoria> = categorias
            .filter { valorActual: Categoria ->
                val diferentes: Boolean = valorActual.nombre !=nombre &&  valorActual.codigo != codigo//expresión Condición
                return@filter diferentes
            }
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString = gson.toJson(respuestaFilter)
        var file = File("categoria.json")
        file.writeText(jsonString)
    }
    fun crearCategoria(codigo:String,nombre:String,descipcion:String){
        var categorias = listar()
        categorias.add(Categoria(codigo,nombre,descipcion))
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString = gson.toJson(categorias)
        var file = File("categoria.json")
        file.writeText(jsonString)

    }

    fun actualizarCategoria(nombreAnterior:String,codigo:String,nombre:String,descipcion:String){
        var categorias = listar()
        categorias
            .forEach {
                if(it.nombre == nombreAnterior){
                    it.nombre = nombre
                    it.codigo = codigo
                    it.descripcion = descipcion
                }
            }
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString = gson.toJson(categorias)
        var file = File("categoria.json")
        file.writeText(jsonString)
    }

    fun listar():ArrayList<Categoria>{
        val listType = object : TypeToken<List<Categoria>>() { }.type
        var file = File("categoria.json")
        val gson = GsonBuilder().setPrettyPrinting().create()
        val list :ArrayList<Categoria> = gson.fromJson(file.readText(), listType)
        return list
    }
}