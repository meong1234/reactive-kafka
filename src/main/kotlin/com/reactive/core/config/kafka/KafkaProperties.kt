package com.reactive.core.config.kafka

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * [Documentation]
 *
 * @author Andi Pangeran
 */
@ConfigurationProperties(prefix = "kafka")
data class KafkaProperties(
    var brokerList: String = "",
    var groupName: String = "",
    var clientName: String = "",
    var topicList: String = "",
    var metadataAge: Long = 0,
    var timeOut: Int = 0
)