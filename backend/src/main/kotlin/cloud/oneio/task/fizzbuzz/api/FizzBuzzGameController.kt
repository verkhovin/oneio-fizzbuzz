package cloud.oneio.task.fizzbuzz.api

import cloud.oneio.task.fizzbuzz.api.dto.GameDto
import cloud.oneio.task.fizzbuzz.service.GameService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.concurrent.Callable

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class FizzBuzzGameController(private val fizzBuzzGameService: GameService) {
  @GetMapping("/rounds")
  @ApiResponses(
    ApiResponse(code=200, response = GameDto::class, message = "Ok"),
    ApiResponse(code=400,  message = "Bad sequence passed")
  )
  fun rounds(@RequestParam goals: List<Int>) = Callable { GameDto of fizzBuzzGameService.playRounds(goals) }

  @ExceptionHandler(IllegalArgumentException::class)
  fun handleError(): ResponseEntity<Any> = ResponseEntity.badRequest().build()
}
