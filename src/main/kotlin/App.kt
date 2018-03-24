import module.tamagotchiEngineModule
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import server.Server

/**
 * @author J. Pichardo
 */
class App : KoinComponent {
    val server: Server by inject()
}

fun main(args: Array<String>) {
    startKoin(listOf(tamagotchiEngineModule))

    val app = App()

    app.server.start()

    Runtime.getRuntime().addShutdownHook(Thread {
        app.server.shutdown()
    })

    app.server.awaitTermination()

}