package store

import classes.Department
import traits.SP_STORE
import scala.collection.mutable.ListBuffer



class StoreDeparts extends SP_STORE[Department] {
  var list: ListBuffer[Department] = ListBuffer[Department]()

  override def set(departs: ListBuffer[Department]): Unit = {
    this.list = departs
  }

  override def get(): ListBuffer[Department] = {
    this.list
  }

  override def getAsArray(): Array[Department] = {
    this.list.toArray
  }

  override def printList(): Unit = {
    for (depart <- this.list) println(s"store depart: id: ${depart.id} , Name: ${depart.name}")
  }
}