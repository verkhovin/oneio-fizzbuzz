package cloud.oneio.task.fizzbuzz.configuration

import cloud.oneio.task.fizzbuzz.caching.InMemoryLargestRoundHolder
import cloud.oneio.task.fizzbuzz.service.RoundService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RoundHolderConfiguration {
  @Bean
  fun largestRunHolder(
    @Qualifier("computingRoundService") roundService: RoundService,
    roundHolderProperties: RoundHolderProperties
  ) = InMemoryLargestRoundHolder(
    roundHolderProperties.maxCacheableRoundGoal!!,
    roundService.playRound(roundHolderProperties.initialRoundGoal!!)
  )
}
