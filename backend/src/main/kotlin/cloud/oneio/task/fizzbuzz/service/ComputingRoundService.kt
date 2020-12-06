package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.model.Round
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ComputingRoundService : RoundService {
  companion object {
    val log = LoggerFactory.getLogger(ComputingRoundService::class.java)
  }

  override fun playRound(roundGoal: Int) = playRound(roundGoal, 1)

  override fun playRound(roundGoal: Int, roundStart: Int): Round {
    if (roundGoal < 1) {
      throw IllegalArgumentException("roundGoal must be greater than or equal to 1")
    }
    log.info("Compute fizz buzz from {} to {}", roundStart, roundGoal)
    return Round(
      generateSequence(roundStart) { it + 1 }
        .take(roundGoal - roundStart + 1)
        .map(this::fizzBuzz)
        .toList()
    )
  }

  private fun fizzBuzz(roundStep: Int): String = when {
    roundStep % 3 == 0 && roundStep % 5 == 0 -> "Fizz Buzz"
    roundStep % 3 == 0 -> "Fizz"
    roundStep % 5 == 0 -> "Buzz"
    else -> roundStep.toString()
  }
}
