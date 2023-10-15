# Spring Boot with Java/Kotlin, GraalVM 21 and Loom Virtual Threads
Example projects to configure Spring Boot 3 to use GraalVM 21 and Virtual Threads

## Features
- Test Service implemented in Kotlin
  * Simple project preparing data and an endpoint to retrieve "large" response data
  * Gradle configuration for Kotlin and GraalVM written in Gradle Kotlin DSL
  * Application configuration for Loom Virtual Threads
- Test Service implemented in Java
  * Simple project preparing data and an endpoint to retrieve "large" response data
  * Gradle configuration for Java and GraalVM written in Gradle Groovy DSL
  * Application configuration for Loom Virtual Threads

  
## Compilation
### Bytecode Jar Binary
    gradlew bootJar
### Native Binary
    gradlew nativeCompile
