package cloud.oneio.task.fizzbuzz.configuration

import cloud.oneio.task.fizzbuzz.caching.LargestRoundHolder
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration


@Configuration
class MetricsConfiguration {

  @Autowired
  fun registerMetrics(meterRegistry: MeterRegistry, largestRoundHolder: LargestRoundHolder) {
    Gauge
      .builder("fizzbuzz.rounds.largest") { largestRoundHolder.round.size }
      .register(meterRegistry)
  }
}
