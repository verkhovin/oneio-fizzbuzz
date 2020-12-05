package cloud.oneio.task.fizzbuzz.model

data class Round(val result: List<String>) {
  val size
    get() = result.size
}

fun Round.subRound(roundGoal: Int) = Round(result.subList(0, roundGoal))
