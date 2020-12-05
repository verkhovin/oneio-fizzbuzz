package cloud.oneio.task.fizzbuzz.model

data class Game(val rounds: List<Round>)

data class Round(val result: List<String>)
