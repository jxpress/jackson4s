package net.jxpress.jackson4s

import com.fasterxml.jackson.databind.{SerializationFeature, ObjectMapper}
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.reflect.ClassTag

object Implicits {
  implicit val DefaultMapper: ObjectMapper =
    new ObjectMapper().registerModule(DefaultScalaModule)
      .registerModule(new JodaModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
      .configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true)

  implicit class JsonParser(val json: String) extends AnyVal {
    def parseAs[T](implicit om: ObjectMapper, tag: ClassTag[T]): T = {
      om.readValue(json, tag.runtimeClass.asInstanceOf[Class[T]])
    }
  }
}
