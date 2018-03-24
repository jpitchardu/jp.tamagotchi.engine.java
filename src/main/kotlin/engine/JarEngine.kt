package engine

import mu.KLogger
import mu.KotlinLogging
import java.io.File
import java.net.URLClassLoader

/**
 * @author J. Pichardo
 */
class JarEngine : Renderer {

    private val logger: KLogger

    constructor(loggerFactory: KotlinLogging) {
        this.logger = loggerFactory.logger { }
    }

    override fun render(jarName: String, className: String): Any {

        val file = File(jarName)

        if (!file.exists())
            return Object() //TODO: Change this to handle errors

        val classLoader = URLClassLoader(arrayOf(file.toURI().toURL()), this::class.java.classLoader)

        val clazz = classLoader.loadClass(className)
        val constructor = clazz.getConstructor()
        return constructor.newInstance()

    }
}