package moe.pizza.eveapi

import dispatch._, Defaults._
import scala.xml.{Elem, XML}


class ApiRequest(base: String, endpoint: String, auth: Option[ApiKey] = None) {

  def apply(): Option[Seq[Map[String, String]]] = {
    val svc = auth match {
      case Some(a) => url(base + endpoint + "?keyID=%d&vCode=%s" format (a.keyId, a.vCode))
      case None => url(base + endpoint)
    }
    val response = Http(svc OK as.String)
    Some(elemToMap(XML.loadString(response())))
  }

  def elemToMap(root: Elem) = {
    root \\ "eveapi" \\ "rowset" \\ "row" map {_.attributes.asAttrMap}
  }
}
