package net.jxpress.jackson4s

import com.fasterxml.jackson.databind.ObjectMapper

trait ToJSON[T] {
  def toJSON()(implicit om: ObjectMapper): String = om.writeValueAsString(this.asInstanceOf[T])
}

