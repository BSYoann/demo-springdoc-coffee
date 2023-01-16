package io.liksi.blog.demospringdoccoffee.config

import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.annotation.Secured

@Configuration
class SpringDocConfig {

    @Bean
    fun customizeOperation(): OperationCustomizer {
        return OperationCustomizer { operation, handlerMethod ->
            val classSecuredAnnotation = handlerMethod.beanType.annotations.find { it is Secured } as Secured?
            val methodSecuredAnnotation = handlerMethod.method.annotations.find { it is Secured } as Secured?

            val roles = (methodSecuredAnnotation ?: classSecuredAnnotation)?.value
            roles?.let {
                val joinedRoles = it.joinToString(separator = "\n- ", prefix = "\n- ") { role -> role.removePrefix("ROLE_").lowercase() }
                var description = operation.description ?: ""
                operation.description = """
                    |$description
                    |
                    |ROLES : 
                    |$joinedRoles
                """.trimMargin()
            }

            operation
        }
    }

}