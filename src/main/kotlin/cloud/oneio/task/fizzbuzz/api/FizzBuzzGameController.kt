package cloud.oneio.task.fizzbuzz.api

import cloud.oneio.task.fizzbuzz.service.GameService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Callable

@RestController
class FizzBuzzGameController(private val fizzBuzzGameService: GameService) {
  @GetMapping("/rounds")
  fun rounds(@RequestParam numbers: List<Int>) = Callable { GameDto of fizzBuzzGameService.playRounds(numbers) }
}
