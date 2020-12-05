package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.caching.LargestRoundHolder
import cloud.oneio.task.fizzbuzz.model.Round
import cloud.oneio.task.fizzbuzz.model.subRound
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class CacheableRoundServiceDecorator(
  @Qualifier("computingRoundService")
  private val roundService: RoundService,
  private val largestRoundHolder: LargestRoundHolder
) : RoundService by roundService {

  override fun playRound(roundGoal: Int): Round {
    val largestRound = largestRoundHolder.round
    return when {
      largestRound.size > roundGoal -> largestRound.subRound(roundGoal)
      largestRound.size < roundGoal -> extendAndCache(roundGoal, largestRound)
      else -> largestRound
    }
  }

  private fun extendAndCache(roundGoal: Int, largestRound: Round): Round {
    val restOfRound = roundService.playRound(roundGoal, roundStart = largestRound.size + 1)
    return Round(largestRound.result + restOfRound.result).also { largestRoundHolder.put(it) }
  }
}
