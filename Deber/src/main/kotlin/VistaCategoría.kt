import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.event.ActionListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

class VistaCategoría : JFrame("Menú Categoría") {
    val contenedor1 = JPanel()
    val contenedor2 = JPanel()
    val contenedor3 = JPanel()
    init{
        val d = Dimension(580,780)
        this.size = d
        defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE

        contenedor1.background = Color.darkGray
        this.contentPane.add(contenedor1)
        contenedor1.layout = null

        contenedor2.background = Color.darkGray
        this.contentPane.add(contenedor2)
        contenedor2.layout = null

        contenedor3.background = Color.DARK_GRAY
        this.contentPane.add(contenedor3)
        contenedor3.layout = null

        this.contentPane.layout = BoxLayout(this.contentPane, BoxLayout.Y_AXIS)
        this.setLocationRelativeTo(null)

        mostrarAnadirCategoria()
        mostrarActualizarCategoria()
        mostrarEliminarCategoria()
    }

    fun mostrarAnadirCategoria(){
        val letraB = Font(Font.MONOSPACED, Font.BOLD,18)
        val letraI = Font(Font.DIALOG, Font.CENTER_BASELINE,18)
        val colorL = Color.WHITE

        val titulo = JLabel("Crear Categoría")
        titulo.foreground = colorL
        titulo.font = letraB
        titulo.setBounds(5,5,200,19)
        contenedor1.add(titulo)

        var disX = 20
        val lblCodigo = JLabel("Código")
        lblCodigo.setBounds(5,25,200,19)
        lblCodigo.foreground = colorL
        contenedor1.add(lblCodigo)
        val jtfCodigo = JTextField()
        jtfCodigo.font = letraI
        jtfCodigo.setBounds(5,43,200,25)
        contenedor1.add(jtfCodigo)

        disX = 40
        val lblNombre = JLabel("Nombre")
        lblNombre.setBounds(5,25+disX,200,19)
        lblNombre.foreground = colorL
        contenedor1.add(lblNombre)
        val jtfNombre = JTextField()
        jtfNombre.font = letraI
        jtfNombre.setBounds(5,43+disX,200,25)
        contenedor1.add(jtfNombre)

        disX = 80
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

        disX = 120
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
            ControladorCategoria().crearCategoria(
                jtfCodigo.getText(),
                jtfNombre.getText(),
                jtfDescripcion.getText()
            )
            jtfNombre.text = ""
            jtfCodigo.text =""
            jtfDescripcion.text = ""
            jtfCUltimaActualizacion.text = LocalDateTime.now()
                .format(DateTimeFormatter.ISO_DATE)
                .replace('-','/')
        }
        btnCrear.addActionListener(accion)
    }

    fun mostrarActualizarCategoria(){
        val letraB = Font(Font.MONOSPACED, Font.BOLD,18)
        val letraI = Font(Font.DIALOG, Font.CENTER_BASELINE,18)
        val colorL = Color.WHITE
        var listaNombre = arrayOf<String>()
        var listaCategorias: ArrayList<Categoria> = ControladorCategoria().listar()

        listaCategorias
            .forEach{
                listaNombre = append(listaNombre,it.nombre)
            }
        val titulo = JLabel("Actualizar Categoria")
        titulo.foreground = colorL
        titulo.font = letraB
        titulo.setBounds(5,0,700,19)
        contenedor2.add(titulo)

        var listaDesplegable = JComboBox(listaNombre)
        listaDesplegable.setBounds(5,20,400,19)
        contenedor2.add(listaDesplegable)
        listaDesplegable.selectedIndex = -1

        val btnRefrescar = JButton("Refrescar")
        btnRefrescar.background = Color.gray
        btnRefrescar.foreground = colorL
        btnRefrescar.font = letraB
        btnRefrescar.setBounds(410,17,150,25)
        contenedor2.add(btnRefrescar)

        var disX = 12
        val lblCodigo = JLabel("Código")
        lblCodigo.setBounds(5,25+disX,200,19)
        lblCodigo.foreground = colorL
        contenedor2.add(lblCodigo)
        val jtfCodigo = JTextField()
        jtfCodigo.font = letraI
        jtfCodigo.setBounds(5,43+disX,200,25)
        contenedor2.add(jtfCodigo)

        disX = 52
        val lblNombre = JLabel("Nombre")
        lblNombre.setBounds(5,25+disX,200,19)
        lblNombre.foreground = colorL
        contenedor2.add(lblNombre)
        val jtfNombre = JTextField()
        jtfNombre.font = letraI
        jtfNombre.setBounds(5,43+disX,200,25)
        contenedor2.add(jtfNombre)

        disX = 92
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

        disX = 132
        val lblDescripcion = JLabel("Descripción")
        lblDescripcion.setBounds(5,25+disX,400,19)
        lblDescripcion.foreground = colorL
        contenedor2.add(lblDescripcion)
        val jtfDescripcion = JTextField()
        jtfDescripcion.font = letraI
        jtfDescripcion.setBounds(5,43+disX,400,25)
        contenedor2.add(jtfDescripcion)

        val accion1 = ActionListener {
            var indice = listaDesplegable.selectedIndex
            if (indice != -1){
                jtfNombre.text = listaCategorias[indice].nombre
                jtfCodigo.text = listaCategorias[indice].codigo
                jtfDescripcion.text = listaCategorias[indice].descripcion
                jtfCUltimaActualizacion.text = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_DATE)
                    .replace('-','/')
            }
        }
        listaDesplegable.addActionListener(accion1)


        val btnActualizar = JButton("Actualizar")
        btnActualizar.background = Color.gray
        btnActualizar.foreground = colorL
        btnActualizar.font = letraB
        btnActualizar.setBounds(410,43+disX,150,25)
        contenedor2.add(btnActualizar)

        val accion2 = ActionListener{
            ControladorCategoria().actualizarCategoria(
                listaCategorias[listaDesplegable.selectedIndex].nombre,
                jtfCodigo.getText(),
                jtfNombre.getText(),
                jtfDescripcion.getText()
            )
            listaNombre = arrayOf<String>()
            listaCategorias = ControladorCategoria().listar()
            listaCategorias
                .forEach{
                    listaNombre = append(listaNombre,it.nombre)
                }
            listaDesplegable.removeAllItems()
            listaNombre.forEach {
                listaDesplegable.addItem(it)
            }
            listaDesplegable.selectedIndex = -1
            jtfNombre.text = ""
            jtfCodigo.text =""
            jtfDescripcion.text = ""
            jtfCUltimaActualizacion.text = LocalDateTime.now()
                .format(DateTimeFormatter.ISO_DATE)
                .replace('-','/')
        }
        btnActualizar.addActionListener(accion2)
        val accion3 = ActionListener {
            listaNombre = arrayOf<String>()
            listaCategorias = ControladorCategoria().listar()
            listaCategorias
                .forEach{
                    listaNombre = append(listaNombre,it.nombre)
                }
            listaDesplegable.removeAllItems()
            listaNombre.forEach {
                listaDesplegable.addItem(it)
            }
            listaDesplegable.selectedIndex = -1
            jtfNombre.text = ""
            jtfCodigo.text =""
            jtfDescripcion.text = ""
            jtfCUltimaActualizacion.text = LocalDateTime.now()
                .format(DateTimeFormatter.ISO_DATE)
                .replace('-','/')
        }
        btnRefrescar.addActionListener(accion3)
    }

    fun mostrarEliminarCategoria(){
        val letraB = Font(Font.MONOSPACED, Font.BOLD,18)
        val colorL = Color.WHITE
        var listaNombre = arrayOf<String>()
        var listaCategorias: ArrayList<Categoria> = ControladorCategoria().listar()

        listaCategorias
            .forEach{
                listaNombre = append(listaNombre,it.nombre)
            }
        val titulo = JLabel("Eliminar Categoria")
        titulo.foreground = colorL
        titulo.font = letraB
        titulo.setBounds(5,20,700,19)
        contenedor3.add(titulo)

        var listaDesplegable = JComboBox(listaNombre)
        listaDesplegable.setBounds(5,40,400,19)
        contenedor3.add(listaDesplegable)
        listaDesplegable.selectedIndex = -1

        val btnEliminar = JButton("Eliminar")
        btnEliminar.background = Color.gray
        btnEliminar.foreground = colorL
        btnEliminar.font = letraB
        btnEliminar.setBounds(410,37,150,25)
        contenedor3.add(btnEliminar)

        val accion = ActionListener {
            if(listaDesplegable.selectedIndex != -1){
                ControladorCategoria()
                    .borrarCategoria(
                        listaCategorias[listaDesplegable.selectedIndex].nombre,
                        listaCategorias[listaDesplegable.selectedIndex].codigo
                    )
                listaNombre = arrayOf<String>()
                listaCategorias = ControladorCategoria().listar()
                listaCategorias
                    .forEach{
                        listaNombre = append(listaNombre,it.nombre)
                    }
                listaDesplegable.removeAllItems()
                listaNombre.forEach {
                    listaDesplegable.addItem(it)
                }
                listaDesplegable.selectedIndex = -1
            }
        }

        btnEliminar.addActionListener(accion)
    }

    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }

}