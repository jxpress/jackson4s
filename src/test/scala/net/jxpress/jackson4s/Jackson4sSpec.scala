package net.jxpress.jackson4s


import org.joda.time.{DateTimeZone, DateTime}
import org.scalatest.{FreeSpec, ShouldMatchers}


object TestCases {
  case class User(name: String, age: Int, emails: Seq[String]) extends ToJSON[User]
  case class Item(id: String, price: Double, name: String, createdAt: DateTime) extends ToJSON[Item]
  case class Record(user: User, item: Item) extends ToJSON[Record]
}

class Jackson4sSpec extends FreeSpec with ShouldMatchers {

  import TestCases._
  import Implicits._

  "Json4s" - {

    "can serialize/deserialize any flat structured case classes" in {

      val user0 = User("yamada", 42, Seq("yamada@jxpress.net"))

      val str = user0.toJSON()

      val user1 = str.parseAs[User]

      user0 should equal(user1)
    }

    "can serialize/deserialize any case classes including joda time instances" in {

      val item0 = Item("xx", 100.1, "scala", new DateTime().withZone(DateTimeZone.forID("Asia/Tokyo")))

      val str = item0.toJSON()

      val item1 = str.parseAs[Item]

      item0 should equal(item1)
    }

    "can serialize/deserialize any nested case classes" in {

      val record0 = Record(
        User("yamada", 42, Seq("yamada@jxpress.net")),
        Item("xx", 100.1, "scala", new DateTime().withZone(DateTimeZone.forID("Asia/Tokyo")))
      )

      val str = record0.toJSON()

      val record1 = str.parseAs[Record]

      record0 should equal(record1)

    }
  }

}
