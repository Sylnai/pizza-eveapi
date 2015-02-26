package moe.pizza.eveapi


object Main extends App {
  implicit val apikey = Some(ApiKey(4, "b"))
  val r = new EVEAPI().account.Characters()
  println(r)
}
