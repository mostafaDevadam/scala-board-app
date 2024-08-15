package store

import traits.SP_STORE
import classes.Group

import scala.collection.mutable.ListBuffer

class StoreGroups extends SP_STORE[Group] {
  var list = ListBuffer[Group]()

  override def set(groups: ListBuffer[Group]): Unit = {
    this.list = groups
  }

  override def get(): ListBuffer[Group] = {
    this.list
  }

  override def getAsArray(): Array[Group] = {
    this.list.toArray
  }

  override def printList(): Unit = {
    for (gp <- this.list) println(s"store group: id: ${gp.id}")
  }
}