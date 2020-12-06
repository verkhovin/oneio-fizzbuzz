package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.ROUND_OF_10
import cloud.oneio.task.fizzbuzz.ROUND_OF_5
import cloud.oneio.task.fizzbuzz.ROUND_OF_8
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ComputingRoundServiceTest {
  private val roundService: RoundService = ComputingRoundService()

  @Test
  fun `must generate correct fizz buzz sequences`() {
    assertEquals(ROUND_OF_5, roundService.playRound(5))
    assertEquals(ROUND_OF_8, roundService.playRound(8))
    assertEquals(ROUND_OF_10, roundService.playRound(10))
  }

  @Test
  fun `values less than 1 must due to exception`() {
    assertThrows<IllegalArgumentException> { roundService.playRound(0) }
    assertThrows<IllegalArgumentException> { roundService.playRound(-1) }
  }

  @Test
  fun `when roundStart is specified, resulting round must start with specified value`() {
    assertEquals("Fizz", roundService.playRound(10, 3).result.first())
    assertEquals("Buzz", roundService.playRound(10, 5).result.first())
    assertEquals("7", roundService.playRound(10, 7).result.first())
  }

  @Test
  fun `when roundStart is specified, resulting round must be length equal to difference between start and goal plus 1 (last step included)`() {
    assertEquals(8, roundService.playRound(10, 3).size)
    assertEquals(6, roundService.playRound(10, 5).size)
    assertEquals(4, roundService.playRound(10, 7).size)
  }

  @Test
  fun `if step is divisible by 3 then Fizz must be returned`() {
    assertEquals("Fizz", roundService.playRound(3).result.last())
    assertEquals("Fizz", roundService.playRound(3, 3).result.first())
  }

  @Test
  fun `if step is divisible by 5 then Buzz must be returned`() {
    assertEquals("Buzz", roundService.playRound(5).result.last())
    assertEquals("Buzz", roundService.playRound(5, 5).result.first())
  }

  @Test
  fun `if step is divisible by the both 3 and 5 then Fizz Buzz must be returned`() {
    assertEquals("Fizz Buzz", roundService.playRound(15).result.last())
    assertEquals("Fizz Buzz", roundService.playRound(15, 15).result.first())
  }


  @Test
  fun `if step isn't divisible by the both 3 and 5 then number must be returned`() {
    assertEquals("7", roundService.playRound(7).result.last())
    assertEquals("7", roundService.playRound(7, 7).result.first())
  }

}
