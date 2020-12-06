package cloud.oneio.task.fizzbuzz.api

import cloud.oneio.task.fizzbuzz.api.dto.GameDto
import cloud.oneio.task.fizzbuzz.service.GameService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException
import java.util.concurrent.Callable

@RestController
class FizzBuzzGameController(private val fizzBuzzGameService: GameService) {
  @GetMapping("/rounds")
  fun rounds(@RequestParam goals: List<Int>) = Callable { GameDto of fizzBuzzGameService.playRounds(goals) }

  @ExceptionHandler(IllegalArgumentException::class)
  fun handleError(): ResponseEntity<Any> = ResponseEntity.badRequest().build()
}
