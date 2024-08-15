package traits

import scala.collection.mutable.ListBuffer

trait SP_STORE[T] {
  var list: ListBuffer[T]
  def set(list$: ListBuffer[T]): Unit
  def get(): ListBuffer[T]
  def getAsArray(): Array[T]
  def printList(): Unit
}
