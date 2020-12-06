package cloud.oneio.task.fizzbuzz.api.dto

import cloud.oneio.task.fizzbuzz.model.Game

data class GameDto(val rounds: List<RoundDto>) {
  companion object {
    infix fun of(game: Game) = GameDto(
      game.rounds
        .asSequence()
        .map { RoundDto(it.result.joinToString(), it.result.size) }
        .toList()
    )
  }
}

data class RoundDto(val result: String, val goal: Int)


