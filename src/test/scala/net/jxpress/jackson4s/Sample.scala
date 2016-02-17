package net.jxpress.jackson4s



object Sample {

  import org.joda.time.DateTime

  case class Author (
                    firstName : String,
                    lastName : String
                    ) extends ToJSON[Author]

  case class Book(
                     id : String,
                     title: String,
                     isdn : String,
                     author: Author,
                     publishedAt: DateTime
                     ) extends ToJSON[Book]

  val sample : Book = Book (
    id = "00001",
    title = "My Scala",
    isdn = "0103920",
    author = Author("Hiroyasu", "Yamada"),
    publishedAt = new DateTime()
  )

  def main(args: Array[String]) : Unit = {

    import net.jxpress.jackson4s.Implicits._

    val json = sample.toJSON()

    println(json) // => {"id":"00001","title":"My Scala","isdn":"0103920","author":{"firstName":"Hiroyasu","lastName":"Yamada"},"publishedAt":"2016-02-17T12:27:18.156+09:00[Asia/Tokyo]"}

    val mybook = json.parseAs[Book]

    assert(sample == mybook) // => true
  }

}
