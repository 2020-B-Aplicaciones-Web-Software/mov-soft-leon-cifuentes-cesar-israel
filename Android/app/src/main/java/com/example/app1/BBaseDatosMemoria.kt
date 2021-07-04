package com.example.app1

class BBaseDatosMemoria {
    companion object{
        //Propiedades
        //Metodos
        //Estaticos(Singleton)
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador("Adrian","a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Cesar","a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Luis","a@a.com")
                )
        }
    }

}