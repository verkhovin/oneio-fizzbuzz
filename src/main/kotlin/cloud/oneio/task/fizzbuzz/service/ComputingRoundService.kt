package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.model.Round
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ComputingRoundService: RoundService{
  @Cacheable("round")
  override fun playRound(roundGoal: Int, roundStart: Int) = Round(
    generateSequence(roundStart) { it + 1 }
      .take(roundGoal)
      .map(this::fizzBuzz)
      .toList()
  )

  private fun fizzBuzz(roundStep: Int): String = when {
    roundStep % 3 == 0 -> "fizz"
    roundStep % 5 == 0 -> "buzz"
    else -> roundStep.toString()
  }
}
