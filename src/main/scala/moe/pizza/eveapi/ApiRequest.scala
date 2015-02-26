package moe.pizza.eveapi

import dispatch._, Defaults._
import scala.xml.{Elem, XML}


class ApiRequest(base: String, endpoint: String,  auth: Option[ApiKey] = None, args: Map[String, String] = Map()) {

  def apply(): Option[Seq[Map[String, String]]] = {
    val mysvc = url(base+endpoint)
    var req = mysvc.GET
    // add API key
    req = auth match {
      case Some(a) => req.addQueryParameter("keyID", a.keyId.toString).addQueryParameter("vCode", a.vCode)
      case None => req
    }
    // add arguments
    req = args.foldLeft(req)((r, kv) => r.addQueryParameter(kv._1, kv._2))
    println(req.url)
    val response = Http(req OK as.String)
    Some(elemToMap(XML.loadString(response())))
  }

  def elemToMap(root: Elem) = {
    root \\ "eveapi" \\ "rowset" \\ "row" map {_.attributes.asAttrMap}
  }
}
