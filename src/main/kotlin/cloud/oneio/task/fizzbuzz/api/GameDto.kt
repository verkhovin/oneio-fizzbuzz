package cloud.oneio.task.fizzbuzz.api

import cloud.oneio.task.fizzbuzz.model.Game

data class GameDto(val rounds: List<RoundDto>) {
  companion object {
    infix fun of(game: Game) = GameDto(
      game.rounds
        .asSequence()
        .map {it.result.joinToString()}
        .map(::RoundDto)
        .toList()
    )
  }
}

data class RoundDto(val result: String)


