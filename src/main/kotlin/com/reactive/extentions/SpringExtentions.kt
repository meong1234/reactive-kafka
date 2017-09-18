package com.reactive.extentions

import org.springframework.boot.SpringApplication
import kotlin.reflect.KClass

/**
 * [Documentation]
 *
 * @author Andi Pangeran
 */
fun run(type: KClass<*>, vararg args: String) = SpringApplication.run(type.java, *args)