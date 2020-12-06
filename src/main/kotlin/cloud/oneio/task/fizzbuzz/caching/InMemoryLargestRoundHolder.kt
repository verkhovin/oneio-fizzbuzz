package cloud.oneio.task.fizzbuzz.caching

import cloud.oneio.task.fizzbuzz.model.Round
import java.util.concurrent.atomic.AtomicReference

class InMemoryLargestRoundHolder(private val maxCacheableRoundGoal: Int, initialRound: Round): LargestRoundHolder {
  init {
    if (initialRound.size > maxCacheableRoundGoal) {
      throw IllegalArgumentException("Initial round gould must not be greater than max cacheable round goal.")
    }
  }

  private val value: AtomicReference<Round> = AtomicReference(initialRound)

  override val round: Round
    get() = value.get()

  override fun put(round: Round) = value.getAndUpdate { if (round.size > it.size && round.size <= maxCacheableRoundGoal) round else it }
      .let {round.size != it.size}
}
