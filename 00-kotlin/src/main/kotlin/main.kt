import java.util.*

fun main() {
    println("Hola mundo")
    //JAVA Int edad = 12
    var edadProfesor = 31

    //Duck Typing
    //No es necesario definir el tipo pero se lo puede hacer
    //var edadProfesor: Int = 31
    //var costo: Double = 12.1

    // VARIABLES MUTABLES E INMUTABLES
    //Mutables
    var edad: Int = 0
    edad = 1
    edad = 2
    edad = 3

    //INMUTABLES

    val numeroCedula = 1234567890
    //numeroCedula = 12

    //Tipo Any
    var x: Any = 0
    x = "asdasda"
    x = 2.1321

    //Tipos de variables
    //Primitivos: Int Float Double Boolean Char
    val nombre: String = "César"
    val sueldo: Double = 1200.50
    val estado: Char = 'S'
    val casado: Boolean = false
    val fecha: Date = Date()

    if (true) {
        //Verdadero
    } else {
        //false
    }

    //switch
    when (estado) {
        ('S') -> {
            println("Huir")
        }
        ('C') -> {
            println("No Huir")
        }
        ('P') -> {
            println("Huir")
        }
        'Z' -> println("Profesor")

        else -> {
            println("No tiene estado civil")
        }
    }
    //Condicional **
    val sueldoMayor = if (sueldo > 12.2) 500 else 0

    imprmirNombre("cesar")
    //Parámetros nombrados
    calcularSueldo(
        bono = 3.00,
        //tasa = 12.00,
        sueldo = 12000.0

    )
    calcularSueldo(
        bono = 3.00,
        //tasa = 12.00,
        sueldo = 12000.0

    )

    //Arreglos Estáticos
    val arregloEstatico: Array<Int> = arrayOf(1, 2, 3)
    //Arreglos Dinámicos
    val arregloDinamicos: ArrayList<Int> = arrayListOf(1, 2, 3, 5, 6, 1, 2)
    arregloDinamicos.add(12)


    //OPERADORES

    //FOR EACH
    val respuestaForEach: Unit = arregloDinamicos
        .forEach { valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    //Reducción
    arregloDinamicos
        .forEach { it: Int ->
            println("Valor actual: ${it}")
        }
    //Reducción x2
    arregloDinamicos.forEach { print("Valor actual: ${it}") }

    //FOR EACH INDEXADO
    arregloDinamicos.forEachIndexed { indice: Int, valorActual: Int ->
        println("Valor actual: ${valorActual}, Indice actual: ${indice}")
    }

    //OPERADOR MAP -> Muta el arreglo (Cambio el arreglo)
    val respuestaMap: List<Double> = arregloDinamicos
        .map { valorActual: Int ->
            return@map valorActual.toDouble()
        }

    println(respuestaMap)

    val respuestaMap2: List<Double> = arregloDinamicos
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }

    println(respuestaMap2)

    //FILTER

    val respuestaFilter: List<Int> = arregloDinamicos
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5 //expresión Condición
            return@filter mayoresACinco
        }
    println(respuestaFilter)

    //OR AND
    //OR -> ANY (Alguno verdadero)
    //AND -> ALL (Todos deben cumplir)
    val respuestaAny: Boolean = arregloDinamicos
        .any { valorActual: Int ->
            return@any (valorActual > 5)

        }
    println(respuestaAny)
    val respuestaAll: Boolean = arregloDinamicos
        .all { valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll)


    //REDUCE ->Valor acumulado
    // valorIteración1 = valorEmpiezo + valor actual
    //para la primera iteración sería 0 +valor actual = valorActual
    //para la segunda iteración sería valorOperaciónAnterior + valor actual = valorOperacionActual

    val respuestaReduce: Int = arregloDinamicos
        .reduce{
            acumulado: Int, valorActual: Int->

            return@reduce(acumulado + valorActual)
        }
    println(respuestaReduce)

    val arregloDanio = arrayListOf<Int>(12,15,8,10)
    val respuestaReduceFold = arregloDanio
        .fold(
            100,
            {
                acumulado, valorAcualIteracion ->
                return@fold acumulado-valorAcualIteracion
            }
        )
    println(respuestaReduceFold)
    val vidaActual: Double = arregloDinamicos
        .map{ it * 2.3}
        .filter{ it > 20.0}
        .fold(100.0,{acc, i -> acc-i})
        .also{println(it)}
    println("Valor vida actuaal ${vidaActual}")


    //Instanciando clases
    val ejemploUno = Suma(1,2)
    val ejemploDos = Suma(null,2)
    val ejemploTres = Suma(1,null)
    val ejemploCuatro= Suma(null,null)
    ejemploUno.sumar()
    ejemploUno.sumar()
    ejemploUno.sumar()
    ejemploDos.sumar()

}
fun imprmirNombre(nombre: String): Unit{
    println("Nombre: ${nombre}")//template String
}

fun calcularSueldo(
    sueldo: Double, //Requerido
    tasa: Double =12.00,//Opcional
    bono: Double? = null//Variables que pueden ser nulo
     ):Double//Retorno
{
    if (bono != null)
        return sueldo*100/tasa + bono
    else
        return sueldo*100/tasa
}


abstract class NumerosJava{
    protected val numeroUno: Int //Propiedad clase
    private  val numeroDos: Int //Propiedad clase
    constructor(
        uno: Int,
        dos: Int,
    ){
 //       this.numeroUno =uno
 //       this.numeroDos = dos
        numeroUno = uno
        numeroDos = dos
        println("Inicializar")
    }
}

abstract class Numero(
    //Constructor primario
    protected val numeroUno: Int,
    protected val numeroDos: Int
){
    init{ //Bloque de constructor primario
        println("Inicializar")
    }
}

class Suma(
    //Constructor primario
    uno: Int, //parámetro requerido
    dos: Int
):Numero(
    //Super Constructor
    uno, dos
){
    init {
        this.numeroDos
        this.numeroUno
    }
    constructor(
        uno: Int?,
        dos: Int
    ): this(
        if (uno == null) 0 else uno,
        dos
    )
    constructor(
        uno: Int,
        dos: Int?
    ): this(
        if (dos == null) 0 else dos,
        uno
    )
    constructor(
        uno: Int?,
        dos: Int?
    ): this(
        if (uno == null) 0 else uno,
        if (dos == null) 0 else dos
    )

    //public fun sumar(): Int { //no es necesario
    //solo es necesario para protected o private
    fun sumar(): Int{
        val total: Int = numeroUno + numeroDos
        agregarHistorial(total)
        return total
    }
    //Singleton
    companion object{
        val historialSumas = arrayListOf<Int>()

        fun agregarHistorial (valorNuevoSuma:Int){
            historialSumas.add(valorNuevoSuma)
            println(historialSumas)
        }
    }
}