package engine

/**
 * @author J. Pichardo
 */
interface Renderer{
    fun render(jarName: String, className: String): Any
}