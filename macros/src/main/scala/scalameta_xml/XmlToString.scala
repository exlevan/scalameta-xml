package scalameta_xml

import scala.annotation.StaticAnnotation
import scala.meta._

class XmlToString extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    defn match {
      case defnVal@Defn.Val(_, _, _, Term.Xml(parts, _)) =>
        val str = parts.head
        defnVal.copy(rhs = str)
      case x =>
        sys.error(x.toString())
        x
    }
  }
}
