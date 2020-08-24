package com.example.KotlinExample

const val TIME_TO_COOK_IN_MINUTES: Int = 3;
const val TIME_TO_EAT_IN_MINUTES: Int = 2;

/**
 * Ejecuta la tarea de cocinar y comer en forma síncrona
 */
fun main(){
    Thread(Runnable {
        doTask(4, "COMIENDO")
    }).start()

    Thread(Runnable {
        doTask(2, "USANDO EL CELULAR")
    }).start()

    Thread(Runnable {
        doTask(6, "LAVANDO ROPA")
    }).start()
}

/**
 * Ejecuta la tarea y muestra en pantalla el tiempo transcurrido (en minutos)
 */
fun doTask(taskDuration: Int, task: String){

    // Estamos haciendo la tarea durante el tiempo entregado como parámetro con taskDuration
    for(minutes in 0..taskDuration) {
        var segundosTranscurridos = minutes * 60
        println("$segundosTranscurridos segundos $task" )
        threadRealTime()
    }
}



/**
 * Simula el tiempo real haciendo dormir el thread durante un tiempo
 * El método sleep() levanta una InterruptedException
 * si se despierta antes que se cumple el tiempo
 */
fun threadRealTime(){
    try{
        Thread.sleep(60 * 10)//60 segundos equivalentes a 1 minuto
    }catch (ie: InterruptedException){
        ie.printStackTrace()
    }
}

