
import scala.collection.mutable.ListBuffer

import classes.{User, Group, Department}
import store.Store

object Board {

  def init(): Unit = {
    // Board
    val user1 = new User(1, "mostafa", "manager") // group manager
    val user2 = new User(2, "adam", "manager") // group manager
    val user3 = new User(3, "farrag", "manager") // group manager
    val user4 = new User(4, "samy", "manager") // group manager
    val user5 = new User(5, "saleh", "manager") // group manager
    val user6 = new User(6, "maged", "manager") // group manager
    val user7 = new User(7, "sarah", "manager") // depart manager
    val user8 = new User(8, "khaled", "manager") // depart manager
    val user9 = new User(9, "ammar", "manager") // depart manager

    val users = ListBuffer[User]()
    users.append(user1)
    users.append(user2)
    users.append(user3)
    users.append(user4)
    users.append(user5)
    users.append(user6)
    users.append(user7)
    users.append(user8)
    users.append(user9)

    // Departs
    val depart1 = new Department(1, "HR", user7.id)
    val depart2 = new Department(2, "PR", user8.id)
    val depart3 = new Department(3, "SALES", user9.id)

    val departs = ListBuffer[Department]()
    departs.append(depart1)
    departs.append(depart2)
    departs.append(depart3)

    // Group
    val group1 = new Group(1, depart1.id, user1.id)
    val group2 = new Group(2, depart1.id, user2.id)
    val group3 = new Group(3, depart2.id, user3.id)
    val group4 = new Group(4, depart2.id, user4.id)
    val group5 = new Group(5, depart3.id, user5.id)
    val group6 = new Group(6, depart3.id, user6.id)

    val groups = ListBuffer[Group]()
    groups.append(group1)
    groups.append((group2))
    groups.append(group3)
    groups.append(group4)
    groups.append(group5)
    groups.append(group6)

    // members
    val user10 = new User(10, "john", "member", group1.id) // group member
    val user11 = new User(11, "Hanna", "member", group1.id) // group member
    val user12 = new User(12, "sallah", "member", group1.id) // group member
    val user13 = new User(13, "john", "member", group2.id) // group member
    val user14 = new User(14, "Hanna", "member", group2.id) // group member
    val user15 = new User(15, "sallah", "member", group3.id) // group member
    val user16 = new User(16, "Hanna", "member", group3.id) // group member
    val user17 = new User(17, "sallah", "member", group4.id) // group member
    val user18 = new User(18, "Hanna", "member", group4.id) // group member
    val user19 = new User(19, "sallah", "member", group5.id) // group member
    val user20 = new User(20, "Hanna", "member", group5.id) // group member
    val user21 = new User(21, "sallah", "member", group6.id) // group member
    val user22 = new User(22, "Hanna", "member", group6.id) // group member
    val user23 = new User(23, "sallah", "member", group6.id) // group member

    users.append(user10)
    users.append(user11)
    users.append(user12)

    users.append(user13)
    users.append(user14)
    users.append(user15)
    users.append(user16)
    users.append(user17)
    users.append(user18)
    users.append(user19)
    users.append(user20)
    users.append(user21)
    users.append(user22)
    users.append(user23)

    // main store
    val store = new Store()
    store.set("users", users.map(usr => usr: Any))
    store.set("groups", groups.map(gp => gp: Any))
    store.set("departs", departs.map(dp => dp: Any))
    //
    store.printList()
  }



}
