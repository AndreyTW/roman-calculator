package ru.andreyTw.romanCalculator.telegram


/**
 * val a = 1
 * val a = "s"
 * val a = f(x1,,,,xn) -> interface A { apply(x1:T1,...,xn,Tn): R }
 * val a  = SmsNotifier::notify
 *
 * lambda = единственный метод анонимного класса
 */


fun main() {
    val subscribers = listOf<Subscriber>(Subscriber("1"), Subscriber("2"))

    // protocol            action: (T) -> Unit
    // implementation:     val action =  {it: Any -> notifySubscribers1(subscribers, it)}
    /* val action =  {it: Any -> notifySubscribers1(subscribers, it)}
     listOf<(id: String, message: String) -> Void>(SmsNotifier::notify).forEach (action)*/

    val smsNotifier = SmsNotifier("id")
    notifySubscribers1(subscribers, smsNotifier::notify)

    notifySubscribers1(subscribers) { id: String, message: String -> println("$id - $message") }
    notifySubscribers1(subscribers, { id: String, message: String -> println("$id - $message") })

}

data class Subscriber(val id: String) {

}

interface Notifier {

    fun notify(id: String, message: String)

}

class SmsNotifier(idProvider: String) : Notifier {

    override fun notify(id: String, message: String) {
        println("$id - $message")
        //******
        return
    }

}

fun notifySubscribers1(subscribers: List<Subscriber>, notify: (id: String, message: String) -> Unit) {
    val action: (Subscriber) -> Unit = { notify(it.id, "Hello") }
    subscribers.forEach(action)
}

