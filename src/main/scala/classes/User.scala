package classes

import traits.IUser

class User(var id: Int, var name: String, var position: String) extends IUser {
  var groupId: Int = 0

  def this(id: Int, name: String, position: String, groupId$: Int) = {
    this(id, name, position)
    this.groupId = groupId$
  }
}

