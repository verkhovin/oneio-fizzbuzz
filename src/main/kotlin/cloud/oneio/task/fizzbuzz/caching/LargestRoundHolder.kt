package cloud.oneio.task.fizzbuzz.caching

import cloud.oneio.task.fizzbuzz.model.Round

interface LargestRoundHolder {
  /**
   * @return Round stored in the holder
   */
  val round: Round

  /**
   * Puts [round] to holder if it's larger than that is already stored
   *
   * @return was [round] put into the holder or not
   */
  fun put(round: Round): Boolean
}
