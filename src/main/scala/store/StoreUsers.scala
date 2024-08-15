package store

import traits.SP_STORE
import classes.User

import scala.collection.mutable.ListBuffer

class StoreUsers extends SP_STORE[User] {
  var list = ListBuffer[User]()

  override def set(users: ListBuffer[User]): Unit = {
    this.list = users
    println("set users:", users)
  }

  override def get(): ListBuffer[User] = {
    this.list
  }

  override def getAsArray(): Array[User] = {
    val arr = this.list.toArray
    arr.foreach(println)
    arr
  }

  override def printList(): Unit = {
    for (usr <- this.list) println(s"usr:- id: ${usr.id} , name: ${usr.name}")
  }
}