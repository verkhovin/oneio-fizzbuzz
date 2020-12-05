package cloud.oneio.task.fizzbuzz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
class FizzbuzzApplication

fun main(args: Array<String>) {
  runApplication<FizzbuzzApplication>(*args)
}
