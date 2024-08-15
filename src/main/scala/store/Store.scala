package store

import scala.collection.mutable.ListBuffer
import classes.{Department, Group, StoreLists$, StoreLists$Lite, User}
class Store {
  var list = null
  var list$: ListBuffer[ListBuffer[User]] = ListBuffer()
  var users = ListBuffer[User]()
  var groups = ListBuffer[Group]()
  var departs = ListBuffer[Department]()
  var storeUser: StoreUsers = new StoreUsers()
  var storeGroup: StoreGroups = new StoreGroups()
  var storeDepartment: StoreDeparts = new StoreDeparts()

  var storeLists$: ListBuffer[StoreLists$] = ListBuffer()
  //  val gBoardList: List[GBoardList$] = List
  var storeLists$Lite: List[StoreLists$Lite] = List()

  def set(state: String, list$: ListBuffer[Any]): Unit = {
    state match {
      case "users" => {
        //println(s"state: $state", list$)
        val b: ListBuffer[User] = list$.collect {
          case user: User => user
        }
        // println("b:", b)
        this.setUsers(b)
        //this.storeUser.set(b)
        //this.list.append(ls)
        //this.users = this.storeUser.get()
      }
      case "departs" => {
        // println(s"state departs: $state, ", list$)
        val b: ListBuffer[Department] = list$.collect {
          case dp: Department => dp
        }
        // println("b departs:", b)
        this.setDeparts(b)
      }
      case "groups" => {
        //println(s"state groups: $state", list$)
        val b: ListBuffer[Group] = list$.collect {
          case gp: Group => gp
        }
        //println("b groups:", b)
        this.setGroups(b)
      }
      case _ => println("other")
    }
  }

  private def setUsers(users$: ListBuffer[User]): Unit = {
    this.storeUser.set(users$)
    this.users = this.storeUser.get()
  }

  private def setGroups(groups$: ListBuffer[Group]): Unit = {
    this.storeGroup.set(groups$)
    this.groups = this.storeGroup.get()
  }

  private def setDeparts(departs$: ListBuffer[Department]): Unit = {
    this.storeDepartment.set(departs$)
    this.departs = this.storeDepartment.get()
  }

  def getAll() = {
    this.list
  }

  def printList(): Unit = {
    this.list$ += this.users
    this.storeLists$ = ListBuffer(StoreLists$(this.users))
    //
    this.storeLists$Lite = List(
      StoreLists$Lite(this.storeUser.getAsArray(), this.storeGroup.getAsArray(), this.storeDepartment.getAsArray())
    )
    this.storeLists$Lite.foreach { up =>
      println("Users#:")
      up.users.foreach(usr => {
        if (usr.position == "manager") {
          println(s"Manager: ID: ${usr.id}, Name: ${usr.name}, Position: ${usr.position}")
        } else {
          println(s"Member: ID: ${usr.id}, Name: ${usr.name}, Position: ${usr.position}, GroupId: ${usr.groupId}")
        }
      })

      println("Groups#:")
      up.groups.foreach(gp => println(s"ID: ${gp.id} , DepartId: ${gp.departId} , ManagerId: ${gp.managerId}"))

      println("Departs#:")
      up.departs.foreach(dp => println(s"Id ${dp.id} , Name: ${dp.name} , ManagerId: ${dp.managerId}"))

      println("-" * 20)
    }

  }


}