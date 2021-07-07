import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class Menu(titulo:String?) : JFrame(titulo){
    var contenedor1 = JPanel()

    init {
        val d = Dimension(400,400)
        this.size = d
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        this.contentPane.add(contenedor1)
        contenedor1.background = Color.DARK_GRAY
        contenedor1.layout = null
        this.setLocationRelativeTo(null)
        menuBotones()
    }
    fun menuBotones(){
        val letra = Font(Font.MONOSPACED, Font.BOLD,18)
        val colorB = Color.gray
        val colorL = Color.WHITE
        var btnCategoria = JButton("Categorías")
        btnCategoria.font = letra
        btnCategoria.background = colorB
        btnCategoria.foreground = colorL
        btnCategoria.setBounds(100,50,200,100)
        var btnProducto =  JButton("Productos")
        btnProducto.font = letra
        btnProducto.background = colorB
        btnProducto.foreground = colorL
        btnProducto.setBounds(100,200,200,100)
        contenedor1.add(btnCategoria)
        contenedor1.add(btnProducto)

        val accion1 = ActionListener{
            ControladorCategoria().abrirVista()
        }
        btnCategoria.addActionListener(accion1)

        val accion2 = ActionListener{
            val menuCategoría = VistaCategoría()
            ControladorProducto().abrirVista()
        }
        btnProducto.addActionListener(accion2)
    }

}