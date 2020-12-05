package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.model.Game
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class GameService(@Qualifier("cacheableRoundServiceDecorator") private val roundService: RoundService) {
  fun playRounds(numbers: List<Int>): Game = Game(
    numbers.stream()
      .parallel()
      .map { roundService.playRound(it) }
      .collect(Collectors.toList())
  )
}
