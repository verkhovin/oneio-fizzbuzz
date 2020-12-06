package cloud.oneio.task.fizzbuzz.caching

import cloud.oneio.task.fizzbuzz.ROUND_OF_10
import cloud.oneio.task.fizzbuzz.ROUND_OF_5
import cloud.oneio.task.fizzbuzz.ROUND_OF_8
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InMemoryLargestRoundHolderTest {
  @Test
  fun `initial round values must be stored to the holder`() {
    val holder = InMemoryLargestRoundHolder(100, ROUND_OF_5)
    assertEquals(ROUND_OF_5, holder.round)
  }

  @Test
  fun `if passed value is less than stored, it must not be saved`() {
    val holder = InMemoryLargestRoundHolder(100, ROUND_OF_10)
    holder.put(ROUND_OF_5)
    assertEquals(ROUND_OF_10, holder.round)
  }

  @Test
  fun `if passed value is greater than stored, it must be saved`() {
    val holder = InMemoryLargestRoundHolder(100, ROUND_OF_5)
    holder.put(ROUND_OF_8)
    assertEquals(ROUND_OF_8, holder.round)
    holder.put(ROUND_OF_10)
    assertEquals(ROUND_OF_10, holder.round)
  }

  @Test
  fun `if passed value is greater that max value, it must not be saved`() {
    val holder = InMemoryLargestRoundHolder(8, ROUND_OF_5)
    holder.put(ROUND_OF_8)
    assertEquals(ROUND_OF_8, holder.round)
    holder.put(ROUND_OF_10)
    assertEquals(ROUND_OF_8, holder.round)
  }
}
