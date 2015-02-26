package moe.pizza.eveapi.moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.{ApiRequest, ApiKey}

class Account(baseurl: String, apikey: Option[ApiKey]) {
  def Characters() = new ApiRequest(baseurl, "Account/Characters.xml.aspx", apikey).apply()
}
