package module

import engine.JarEngine
import engine.Renderer
import mu.KotlinLogging
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import server.Server
import services.JarExecutionService
import services.RenderingService

/**
 * @author J. Pichardo
 */
val tamagotchiEngineModule: Module = applicationContext {

    bean { KotlinLogging }

    bean { JarEngine(get()) as Renderer }
    bean { JarExecutionService(get()) as RenderingService }

    factory { Server(get(), get()) }

}