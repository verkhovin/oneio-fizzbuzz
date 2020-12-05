package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.model.Game
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class GameService(private val computingRoundService: ComputingRoundService) {
  fun playRounds(numbers: List<Int>): Game = Game(
    numbers.stream()
      .parallel()
      .map { computingRoundService.playRound(it) }
      .collect(Collectors.toList())
  )
}
