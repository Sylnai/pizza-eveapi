package moe.pizza.eveapi

import _root_.moe.pizza.eveapi.moe.pizza.eveapi.endpoints.Account

class EVEAPI(baseurl: String = "https://api.eveonline.com/")(implicit val key: Option[ApiKey] = None) {
  val account = new Account(baseurl, key)
}
