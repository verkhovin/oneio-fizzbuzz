package cloud.oneio.task.fizzbuzz.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerUiConfiguration {
  @Bean
  fun api() = Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
    .select()
    .apis(RequestHandlerSelectors.any())
    .paths(PathSelectors.regex("/rounds/*"))
    .build()
}
