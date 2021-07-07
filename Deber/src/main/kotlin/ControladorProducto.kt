import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class ControladorProducto {
    fun abrirVista(){
        val menu = VistaProducto()
        menu.isResizable = false
        menu.isVisible = true
    }

    fun borrarProducto(nombreC:String,nombreP: String){
        var categorias = ControladorCategoria().listar()
        var indiceE = 0
        categorias
            .forEach {
                if(it.nombre ==nombreC){
                    it.arregloProducto
                        .forEachIndexed { indice: Int, pActual:Producto ->
                            if(pActual.nombre == nombreP){
                                indiceE = indice
                        }
                    }
                    it.arregloProducto.removeAt(indiceE)
                }
            }
        val gson = Gson()
        val jsonString = gson.toJson(categorias)
        var file = File("categoria.json")
        file.writeText(jsonString)



    }
    fun crearProducto(nombreCategoria: String, nombre:String,precio:String,cantidad:String,descripcion:String){
        var categorias:ArrayList<Categoria> =ControladorCategoria().listar()
        categorias
            .forEach {
                if(it.nombre ==nombreCategoria){
                    it.arregloProducto.add(Producto(nombre, precio.toDouble(),cantidad.toInt(),descripcion))
                }
            }
        val gson = Gson()
        val jsonString = gson.toJson(categorias)
        var file = File("categoria.json")
        file.writeText(jsonString)
    }

    fun actualizarProducto(nombreCategoria: String,nombreA : String, nombre:String,precio:String,cantidad:String,descripcion:String){
        var categorias:ArrayList<Categoria> =ControladorCategoria().listar()
        categorias
            .forEach {
                if(it.nombre == nombreCategoria){
                    it.arregloProducto.forEach(){
                        if(it.nombre == nombreA){
                            it.nombre = nombre
                            it.cantidad = cantidad.toInt()
                            it.precio = precio.toDouble()
                            it.descripcion = descripcion
                        }
                    }
                }
            }
        val gson = Gson()
        val jsonString = gson.toJson(categorias)
        var file = File("categoria.json")
        file.writeText(jsonString)
    }
    fun listar(nombreCategoria:String):ArrayList<Producto>{
        val listType = object : TypeToken<List<Categoria>>() { }.type
        var file = File("categoria.json")
        val gson = Gson()
        val list :ArrayList<Categoria> = gson.fromJson(file.readText(), listType)

        var productos:List<Categoria> = arrayListOf()
        productos =list
            .filter {
                val categoria = it.nombre == nombreCategoria
                return@filter categoria
            }
        return productos[0].arregloProducto
    }
}