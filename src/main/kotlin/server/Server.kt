package server

import io.grpc.Server
import io.grpc.ServerBuilder
import mu.KLogger
import mu.KotlinLogging
import services.RenderingService

/**
 * @author J. Pichardo
 */
class Server {

    private var server: Server
    private val logger: KLogger

    constructor(jarExecutionService: RenderingService, loggerFactory: KotlinLogging) {
        this.logger = loggerFactory.logger { }
        this.server = ServerBuilder.forPort(9293).build()
    }

    fun start() {
        this.logger.info { "Starting Server" }
        this.server.start()
    }

    fun shutdown() {
        this.logger.info { "Shutting Server Down" }
        this.server.shutdown()
    }

    fun awaitTermination() {
        server.awaitTermination()
    }
}