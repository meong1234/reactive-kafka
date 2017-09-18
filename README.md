# reactive-kafka
sample spring boot 2 with reactive kafka (KOTLIN)

## Software design
 - Reactive and non-blocking
 - More functional style and less annotation based than typical Spring applications
 - Leverage Kotlin features like [Kotlin extensions](https://kotlinlang.org/docs/reference/extensions.html) and [reified type parameters](https://kotlinlang.org/docs/reference/inline-functions.html#reified-type-parameters) for cleaner code
 - Reactive Kafka
 
### Technologies used

 - Language: [Kotlin](https://kotlin.link/) 
 - Framework: [Spring Boot 2.0](https://projects.spring.io/spring-boot/) with [Spring 5 Kotlin support](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/kotlin.html) and [Spring WebFlux functional](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/reactive-web.html)
 - Engine: [Netty](http://netty.io/) used for client and server
 - Reactive API: [Reactor](http://projectreactor.io/)
 - Reactor Kafka: [Reactor-Kafka](https://github.com/reactor/reactor-kafka)
 - Build: [Gradle Script Kotlin](https://github.com/gradle/gradle-script-kotlin)
 - Testing: [Junit 5](http://junit.org/)
  
### Run the app in dev mod using command line
 - Run `./gradlew bootRun` in another terminal