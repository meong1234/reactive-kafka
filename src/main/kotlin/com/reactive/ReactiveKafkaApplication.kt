package com.reactive

import com.reactive.core.config.kafka.KafkaProperties
import com.reactive.extentions.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

/**
 * [Documentation]
 *
 * @author Andi Pangeran
 */
@SpringBootApplication
@EnableConfigurationProperties(value = *arrayOf(KafkaProperties::class))
class ReactiveKafkaApplication {
}

fun main(args: Array<String>) {
    run(ReactiveKafkaApplication::class, *args)
}