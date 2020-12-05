package cloud.oneio.task.fizzbuzz.service

import cloud.oneio.task.fizzbuzz.model.Round

interface RoundService {
  fun playRound(roundGoal: Int, roundStart: Int = 1): Round
}
