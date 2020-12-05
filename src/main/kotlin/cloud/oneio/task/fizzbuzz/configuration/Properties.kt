package cloud.oneio.task.fizzbuzz.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("round-holder")
data class RoundHolderProperties(var initialRoundGoal: Int? = null, var maxCacheableRoundGoal: Int? = null)
