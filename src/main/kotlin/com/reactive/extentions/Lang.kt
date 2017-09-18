package com.reactive.extentions

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

/**
 * [Documentation]
 *
 * @author Andi Pangeran
 */
fun logger(clz: KClass<*>): Logger {
    return LoggerFactory.getLogger(clz.qualifiedName)
}