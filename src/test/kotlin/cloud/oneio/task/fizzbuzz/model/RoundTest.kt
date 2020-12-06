package cloud.oneio.task.fizzbuzz.model

import cloud.oneio.task.fizzbuzz.ROUND_OF_5
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

class RoundTest {
  @Test
  fun `subRound works fine`() {
    val actual = ROUND_OF_5.subRound(3)
    assertIterableEquals(listOf("1", "2", "Fizz"), actual.result)
  }
}
