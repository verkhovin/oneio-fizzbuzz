package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.ROUND_OF_10
import cloud.oneio.task.fizzbuzz.ROUND_OF_5
import cloud.oneio.task.fizzbuzz.ROUND_OF_8
import cloud.oneio.task.fizzbuzz.caching.LargestRoundHolder
import cloud.oneio.task.fizzbuzz.model.Round
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CacheableRoundServiceDecoratorTest {
  @Mock
  private lateinit var roundService: RoundService

  @Mock
  private lateinit var largestRoundHolder: LargestRoundHolder

  @InjectMocks
  private lateinit var observable: CacheableRoundServiceDecorator

  @Test
  fun `if largest round goal is greater than current, then subround of it should be returned`() {
    doReturn(ROUND_OF_10).whenever(largestRoundHolder).round
    val actualRound = observable.playRound(5)

    assertEquals(ROUND_OF_5, actualRound)
    verify(roundService, never()).playRound(anyInt())
    verify(roundService, never()).playRound(anyInt(), anyInt())
    verify(largestRoundHolder, never()).put(any())
  }

  @Test
  fun `if largest round goals is less than current, then it should be extended, saved as largest, and returned`() {
    doReturn(ROUND_OF_5).whenever(largestRoundHolder).round
    doReturn(Round(listOf("Fizz", "7", "8"))).whenever(roundService).playRound(eq(8), eq(6))

    val actualRound = observable.playRound(8)

    assertEquals(ROUND_OF_8, actualRound)
    verify(roundService, never()).playRound(anyInt())
    verify(roundService, times(1)).playRound(eq(8), eq(6))
    verify(largestRoundHolder, times(1)).put(eq(actualRound))
  }

  @Test
  fun `if largest round is the same as current then it should be returned immediately`() {
    doReturn(ROUND_OF_8).whenever(largestRoundHolder).round

    val actualRound = observable.playRound(8)

    assertEquals(ROUND_OF_8, actualRound)
    verify(roundService, never()).playRound(anyInt())
    verify(roundService, never()).playRound(anyInt(), anyInt())
    verify(largestRoundHolder, never()).put(any())
  }
}
