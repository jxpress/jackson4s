# Jackson4s:  A simple JSON serialization library by using Jackson for Scala

## Features

* A simple interface for serializing case classes to JSON string, or JSON string to case classes
* Joda DateTime is supported in default. 

## Requirement 

* scala 2.11.7 or later
* JDK 7 


## Dependencies

Jackson4s depends on the following jackson family:

```
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.3",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.3",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.6.3",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.6.3",
```

## Sample Code
 
```scala

object Sample {

  import org.joda.time.DateTime

  /// Sample case class: Book and Author ////
  
  case class Author (
                    firstName : String,
                    lastName : String
                    ) extends ToJSON[Author] // Extends ToJSON trait to your case classes, you can use toJSON method 

  case class Book(
                     id : String,
                     title: String,
                     isdn : String,
                     author: Author,
                     publishedAt: DateTime // Joda Date Time is avialable
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

    val json = sample.toJSON() // sample to json string

    println(json) // => {"id":"00001","title":"My Scala","isdn":"0103920","author":{"firstName":"Hiroyasu","lastName":"Yamada"},"publishedAt":"2016-02-17T12:27:18.156+09:00[Asia/Tokyo]"}

    val mybook = json.parseAs[Book] // json string to case class 

    println(sample == mybook) // => true
  }

}

```



