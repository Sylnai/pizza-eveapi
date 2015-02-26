package moe.pizza.eveapi


object Main extends App {
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "X"))
  // create API object
  val api = new EVEAPI()
  // call the Characters() endpoint and assume we got something
  val characters = api.account.Characters().get
  // find the first character with given name
  val lucia = characters.find{_("name") == "Lucia Denniard"}
  // if we found one, get it's charactersheet
  val sheet = lucia match {
    case Some(c) => api.char.CharacterSheet(c("characterID").toInt)
    case None => None
  }
  /* sheet then contains:
  List(Map(cloneName -> , locationID -> 60003760, typeID -> 164, jumpCloneID -> 20054810), Map(cloneName -> , locationID -> 60011740, ...
       Map(roleName -> roleDirector, roleID -> 1), Map(titleName -> <color=0xFFBB2AEB>small guy</color>, titleID -> 1))...
  */
}
