import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.event.ActionListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

class VistaProducto: JFrame("Menú Prodcutos") {
    val contenedor1 = JPanel()
    val contenedor2 = JPanel()
    val contenedor3 = JPanel()
    init{
        val d = Dimension(580,900)
        this.size = d
        defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE

        contenedor1.background = Color.darkGray
        contenedor1.layout = null
        this.contentPane.add(contenedor1)

        contenedor2.background = Color.darkGray
        contenedor2.layout = null
        this.contentPane.add(contenedor2)

        contenedor3.background = Color.DARK_GRAY
        contenedor3.layout = null
        this.contentPane.add(contenedor3)
        this.contentPane.layout = BoxLayout(this.contentPane, BoxLayout.Y_AXIS)
        this.setLocationRelativeTo(null)

        mostrarCrearProducto()
        mostrarActualizarProducto()
        mostrarEliminarProducto()
    }

    fun mostrarCrearProducto(){
        val letraB = Font(Font.MONOSPACED, Font.BOLD,18)
        val letraI = Font(Font.DIALOG, Font.CENTER_BASELINE,18)
        val colorL = Color.WHITE

        val titulo = JLabel("Crear Producto")
        titulo.foreground = colorL
        titulo.font = letraB
        titulo.setBounds(5,0,200,19)
        contenedor1.add(titulo)

        var listaNombre = arrayOf<String>()
        var listaCategorias: ArrayList<Categoria> = ControladorCategoria().listar()

        listaCategorias
            .forEach{
                listaNombre = append(listaNombre,it.nombre)
            }
        var listaDesplegable = JComboBox(listaNombre)
        listaDesplegable.setBounds(5,20,400,19)
        contenedor1.add(listaDesplegable)
        listaDesplegable.selectedIndex = -1

        var disX = 15
        val lblNombre = JLabel("Nombre")
        lblNombre.setBounds(5,25+disX,200,19)
        lblNombre.foreground = colorL
        contenedor1.add(lblNombre)
        val jtfNombre = JTextField()
        jtfNombre.font = letraI
        jtfNombre.setBounds(5,43+disX,200,25)
        contenedor1.add(jtfNombre)

        disX = 55
        val lblPrecio = JLabel("Precio")
        lblPrecio.setBounds(5,25+disX,200,19)
        lblPrecio.foreground = colorL
        contenedor1.add(lblPrecio)
        val jtfPrecio = JTextField()
        jtfPrecio.font = letraI
        jtfPrecio.setBounds(5,43+disX,200,25)
        contenedor1.add(jtfPrecio)

        disX = 95
        val lblUltimaActualizacion = JLabel("Última Actualización")
        lblUltimaActualizacion.setBounds(5,25+disX,200,19)
        lblUltimaActualizacion.foreground = colorL
        contenedor1.add(lblUltimaActualizacion)
        val jtfCUltimaActualizacion = JTextField()
        jtfCUltimaActualizacion.text = LocalDateTime.now()
            .format(DateTimeFormatter.ISO_DATE)
            .replace('-','/')
        jtfCUltimaActualizacion.isEditable = false
        jtfCUltimaActualizacion.font = letraI
        jtfCUltimaActualizacion.setBounds(5,43+disX,200,25)
        contenedor1.add(jtfCUltimaActualizacion)

        disX = 135
        val lblCantidad = JLabel("Cantidad")
        lblCantidad.setBounds(5,25+disX,400,19)
        lblCantidad.foreground = colorL
        contenedor1.add(lblCantidad)
        val jtfCantidad = JTextField()
        jtfCantidad.font = letraI
        jtfCantidad.setBounds(5,43+disX,400,25)
        contenedor1.add(jtfCantidad)

        disX = 175
        val lblDescripcion = JLabel("Descripción")
        lblDescripcion.setBounds(5,25+disX,400,19)
        lblDescripcion.foreground = colorL
        contenedor1.add(lblDescripcion)
        val jtfDescripcion = JTextField()
        jtfDescripcion.font = letraI
        jtfDescripcion.setBounds(5,43+disX,400,25)
        contenedor1.add(jtfDescripcion)

        val btnCrear = JButton("Crear")
        btnCrear.background = Color.gray
        btnCrear.foreground = colorL
        btnCrear.font = letraB
        btnCrear.setBounds(410,43+disX,150,25)
        contenedor1.add(btnCrear)

        val accion = ActionListener{
            if (listaDesplegable.selectedIndex != -1) {
                ControladorProducto().crearProducto(
                    listaCategorias[listaDesplegable.selectedIndex].nombre,
                    jtfNombre.getText(),
                    jtfPrecio.getText(),
                    jtfCantidad.getText(),
                    jtfDescripcion.getText()
                )
                listaDesplegable.selectedIndex = -1
                jtfNombre.text = ""
                jtfPrecio.text = ""
                jtfCantidad.text = ""
                jtfDescripcion.text = ""
                jtfCUltimaActualizacion.text = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_DATE)
                    .replace('-', '/')
            }
        }
        btnCrear.addActionListener(accion)
    }

    fun mostrarActualizarProducto(){
        val letraB = Font(Font.MONOSPACED, Font.BOLD,18)
        val letraI = Font(Font.DIALOG, Font.CENTER_BASELINE,18)
        val colorL = Color.WHITE

        val titulo = JLabel("Actualizar Producto")
        titulo.foreground = colorL
        titulo.font = letraB
        titulo.setBounds(5,0,400,19)
        contenedor2.add(titulo)

        var listaNombre = arrayOf<String>()
        var listaCategorias: ArrayList<Categoria> = ControladorCategoria().listar()

        listaCategorias
            .forEach{
                listaNombre = append(listaNombre,it.nombre)
            }
        var listaDesplegable = JComboBox(listaNombre)
        listaDesplegable.setBounds(5,20,400,19)
        contenedor2.add(listaDesplegable)
        listaDesplegable.selectedIndex = -1

        var listaNombreP = arrayOf<String>()
        var listaProductos: ArrayList<Producto> = arrayListOf()

        var listaDesplegableP = JComboBox(listaNombreP)
        listaDesplegableP.setBounds(5,40,400,19)
        contenedor2.add(listaDesplegableP)
        listaDesplegableP.selectedIndex = -1
        val accion = ActionListener {
            if(listaDesplegable.selectedIndex != -1){
                listaNombreP = arrayOf<String>()
                listaProductos =  ControladorProducto().listar(listaCategorias[listaDesplegable.selectedIndex].nombre)
                listaProductos
                    .forEach{
                        listaNombreP = append(listaNombreP,it.nombre)
                    }
                listaDesplegableP.removeAllItems()
                listaNombreP.forEach {
                    listaDesplegableP.addItem(it)
                }
            }
        }
        listaDesplegable.addActionListener(accion)

        val btnRefrescar = JButton("Refrescar")
        btnRefrescar.background = Color.gray
        btnRefrescar.foreground = colorL
        btnRefrescar.font = letraB
        btnRefrescar.setBounds(410,40,150,25)
        contenedor2.add(btnRefrescar)

        var disX = 35
        val lblNombre = JLabel("Nombre")
        lblNombre.setBounds(5,25+disX,200,19)
        lblNombre.foreground = colorL
        contenedor2.add(lblNombre)
        val jtfNombre = JTextField()
        jtfNombre.font = letraI
        jtfNombre.setBounds(5,43+disX,200,25)
        contenedor2.add(jtfNombre)

        disX = 75
        val lblPrecio = JLabel("Precio")
        lblPrecio.setBounds(5,25+disX,200,19)
        lblPrecio.foreground = colorL
        contenedor2.add(lblPrecio)
        val jtfPrecio = JTextField()
        jtfPrecio.font = letraI
        jtfPrecio.setBounds(5,43+disX,200,25)
        contenedor2.add(jtfPrecio)

        disX = 115
        val lblUltimaActualizacion = JLabel("Última Actualización")
        lblUltimaActualizacion.setBounds(5,25+disX,200,19)
        lblUltimaActualizacion.foreground = colorL
        contenedor2.add(lblUltimaActualizacion)
        val jtfCUltimaActualizacion = JTextField()
        jtfCUltimaActualizacion.text = LocalDateTime.now()
            .format(DateTimeFormatter.ISO_DATE)
            .replace('-','/')
        jtfCUltimaActualizacion.isEditable = false
        jtfCUltimaActualizacion.font = letraI
        jtfCUltimaActualizacion.setBounds(5,43+disX,200,25)
        contenedor2.add(jtfCUltimaActualizacion)

        disX = 155
        val lblCantidad = JLabel("Cantidad")
        lblCantidad.setBounds(5,25+disX,400,19)
        lblCantidad.foreground = colorL
        contenedor2.add(lblCantidad)
        val jtfCantidad = JTextField()
        jtfCantidad.font = letraI
        jtfCantidad.setBounds(5,43+disX,400,25)
        contenedor2.add(jtfCantidad)

        disX = 195
        val lblDescripcion = JLabel("Descripción")
        lblDescripcion.setBounds(5,25+disX,400,19)
        lblDescripcion.foreground = colorL
        contenedor2.add(lblDescripcion)
        val jtfDescripcion = JTextField()
        jtfDescripcion.font = letraI
        jtfDescripcion.setBounds(5,43+disX,400,25)
        contenedor2.add(jtfDescripcion)

        val accion2 = ActionListener {
            if(listaDesplegableP.selectedIndex != -1 ){
                jtfNombre.text = listaProductos[listaDesplegableP.selectedIndex].nombre
                jtfPrecio.text = listaProductos[listaDesplegableP.selectedIndex].precio.toString()
                jtfCUltimaActualizacion.text = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_DATE)
                    .replace('-','/')
                jtfCantidad.text = listaProductos[listaDesplegableP.selectedIndex].cantidad.toString()
                jtfDescripcion.text = listaProductos[listaDesplegableP.selectedIndex].descripcion

            }
        }
        listaDesplegableP.addActionListener(accion2)

        val btnCrear = JButton("Actualizar")
        btnCrear.background = Color.gray
        btnCrear.foreground = colorL
        btnCrear.font = letraB
        btnCrear.setBounds(410,43+disX,150,25)
        contenedor2.add(btnCrear)

        val accion3 = ActionListener{
            if (listaDesplegable.selectedIndex != -1 && listaDesplegableP.selectedIndex != -1) {
                ControladorProducto().actualizarProducto(
                    listaCategorias[listaDesplegable.selectedIndex].nombre,
                    listaProductos[listaDesplegableP.selectedIndex].nombre,
                    jtfNombre.getText(),
                    jtfPrecio.getText(),
                    jtfCantidad.getText(),
                    jtfDescripcion.getText()
                )
                listaDesplegable.selectedIndex = -1
                jtfNombre.text = ""
                jtfPrecio.text = ""
                jtfCantidad.text = ""
                jtfDescripcion.text = ""
                jtfCUltimaActualizacion.text = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_DATE)
                    .replace('-', '/')
                listaDesplegableP.removeAllItems()
            }
        }
        btnCrear.addActionListener(accion3)

        val accion4 = ActionListener {
            if (listaDesplegable.selectedIndex != -1) {
                listaDesplegableP.removeAllItems()
                listaDesplegable.selectedIndex = -1
                jtfNombre.text = ""
                jtfPrecio.text = ""
                jtfCantidad.text = ""
                jtfDescripcion.text = ""
                jtfCUltimaActualizacion.text = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_DATE)
                    .replace('-', '/')
            }
        }
        btnRefrescar.addActionListener(accion4)
    }

    fun mostrarEliminarProducto(){
        val letraB = Font(Font.MONOSPACED, Font.BOLD,18)
        val colorL = Color.WHITE

        val titulo = JLabel("Eliminar Producto")
        titulo.foreground = colorL
        titulo.font = letraB
        titulo.setBounds(5,20,200,19)
        contenedor3.add(titulo)

        var listaNombre = arrayOf<String>()
        var listaCategorias: ArrayList<Categoria> = ControladorCategoria().listar()

        listaCategorias
            .forEach{
                listaNombre = append(listaNombre,it.nombre)
            }
        var listaDesplegable = JComboBox(listaNombre)
        listaDesplegable.setBounds(5,40,400,19)
        contenedor3.add(listaDesplegable)
        listaDesplegable.selectedIndex = -1

        var listaNombreP = arrayOf<String>()
        var listaProductos: ArrayList<Producto> = arrayListOf()

        var listaDesplegableP = JComboBox(listaNombreP)
        listaDesplegableP.setBounds(5,65,400,19)
        contenedor3.add(listaDesplegableP)
        listaDesplegableP.selectedIndex = -1
        val accion = ActionListener {
            if(listaDesplegable.selectedIndex != -1){
                listaNombreP = arrayOf<String>()
                listaProductos =  ControladorProducto().listar(listaCategorias[listaDesplegable.selectedIndex].nombre)
                listaProductos
                    .forEach{
                        listaNombreP = append(listaNombreP,it.nombre)
                    }
                listaDesplegableP.removeAllItems()
                listaNombreP.forEach {
                    listaDesplegableP.addItem(it)
                }
            }
        }
        listaDesplegable.addActionListener(accion)
        val btnEliminar = JButton("Eliminar")
        btnEliminar.background = Color.gray
        btnEliminar.foreground = colorL
        btnEliminar.font = letraB
        btnEliminar.setBounds(140,90,150,25)
        contenedor3.add(btnEliminar)

        val accion2 = ActionListener {
            if(listaDesplegable.selectedIndex != -1 && listaDesplegableP.selectedIndex != -1){
                ControladorProducto()
                    .borrarProducto(
                        listaCategorias[listaDesplegable.selectedIndex].nombre,
                        listaProductos[listaDesplegableP.selectedIndex].nombre
                    )
                listaNombreP = arrayOf<String>()
                listaProductos = ControladorProducto().listar(listaCategorias[listaDesplegable.selectedIndex ].nombre)
                listaProductos
                    .forEach{
                        listaNombreP = append(listaNombreP,it.nombre)
                    }
                listaDesplegableP.removeAllItems()
                listaNombreP.forEach {
                    listaDesplegableP.addItem(it)
                }
                listaDesplegableP.selectedIndex = -1
            }
        }
        btnEliminar.addActionListener(accion2)

    }

    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }
}