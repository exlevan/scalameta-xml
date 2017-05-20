package scalameta_xml

object Main extends App {

  @XmlToString
  val xml = <HelloWorld/>

  println(xml)
}
