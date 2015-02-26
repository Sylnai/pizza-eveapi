package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.{ApiKey, ApiRequest}

class Character(baseurl: String, apikey: Option[ApiKey]) {
  def AccountBalance(characterID: Int) = new ApiRequest(baseurl, "char/AccountBalance.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def AssetList(characterID: Int) = new ApiRequest(baseurl, "char/AssetList.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def Blueprints(characterID: Int) = new ApiRequest(baseurl, "char/Blueprints.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def CalendarEventAttendees(characterID: Int, eventIDs: List[Int]) = new ApiRequest(baseurl, "char/CalendarEventAttendees.xml.aspx", apikey, Map("characterID" -> characterID.toString, "eventIDs" -> eventIDs.mkString(","))).apply()
  def CharacterSheet(characterID: Int) = new ApiRequest(baseurl, "char/CharacterSheet.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def ContactList(characterID: Int) = new ApiRequest(baseurl, "char/ContactList.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def ContactNotifications(characterID: Int) = new ApiRequest(baseurl, "char/ContactNotifications.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def Contracts(characterID: Int, contractID: Option[Long] = None) = {
    val args = contractID match {
      case Some(c) => Map("characterID" -> characterID.toString, "contractID" -> c.toString)
      case None => Map("characterID" -> characterID.toString)
    }
    new ApiRequest(baseurl, "char/Contracts.xml.aspx", apikey, args).apply()
  }
  def ContractItems(characterID: Int, contractID: Int) = new ApiRequest(baseurl, "char/ContractItems.xml.aspx", apikey, Map("characterID" -> characterID.toString, "contractID" -> contractID.toString)).apply()
  def ContractBids(characterID: Int) = new ApiRequest(baseurl, "char/ContractBids.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def FacWarStats(characterID: Int) = new ApiRequest(baseurl, "char/FacWarStats.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def IndustryJobs(characterID: Int) = new ApiRequest(baseurl, "char/IndustryJobs.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def IndustryJobsHistory(characterID: Int) = new ApiRequest(baseurl, "char/IndustryJobsHistory.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply()
  def KillMails(characterID: Int, fromID: Option[Int] = None, rowCount: Option[Int] = None) = {
    var args = Map("characterID" -> characterID.toString)
    if (fromID.nonEmpty) {
      args = args ++ Map("fromID" -> fromID.get.toString)
    }
    if (rowCount.nonEmpty) {
      args = args ++ Map("rowCount" -> rowCount.get.toString)
    }
    new ApiRequest(baseurl, "char/KillMails.xml.aspx", apikey, args).apply()
  }
}
