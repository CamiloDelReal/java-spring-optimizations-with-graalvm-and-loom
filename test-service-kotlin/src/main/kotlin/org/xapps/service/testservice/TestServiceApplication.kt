package org.xapps.service.testservice

import org.apache.coyote.ProtocolHandler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer
import org.springframework.context.annotation.Bean
import java.util.concurrent.Executors


@SpringBootApplication
class TestServiceApplication

fun main(args: Array<String>) {
	runApplication<TestServiceApplication>(*args)
}
