package com.reactive.core.config.kafka

import mu.KLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.kafka.receiver.KafkaReceiver
import reactor.kafka.receiver.ReceiverOptions
import java.util.*
import java.util.regex.Pattern
import kotlin.streams.toList


/**
 * [Documentation]
 *
 * @author Andi Pangeran
 */
@Configuration
class KafkaReceiverConfiguration {

    companion object : KLogging()

    @Autowired
    lateinit var kafkaProperties: KafkaProperties

    @Bean
    fun kafkaDataReceiver(): KafkaReceiver<String, String> {

        logger.info { "initate kafkaDataReceiver" }

        val consumerProps = HashMap<String, Any>()
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.brokerList)
        consumerProps.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, kafkaProperties.metadataAge)
        consumerProps.put(ConsumerConfig.CLIENT_ID_CONFIG, kafkaProperties.clientName)
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.groupName)
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        //this make it reset from start
        //consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
        consumerProps.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, kafkaProperties.timeOut)
        consumerProps.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, kafkaProperties.timeOut + 1000)

        logger.info { "kafkaDataReceiver ${consumerProps}" }

        val receiverOptions = ReceiverOptions
            .create<String, String>(consumerProps)
            .subscription(Pattern.compile(",").splitAsStream(kafkaProperties.topicList).toList())
            .addAssignListener { logger.trace("kafka onPartitionsAssigned {}", it) }
            .addRevokeListener { logger.trace("kafka onPartitionsRevoked {}", it) }

        return KafkaReceiver.create(receiverOptions)
    }
}