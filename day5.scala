import scala.io.Source
import scala.compiletime.ops.string

val bucketMatch = raw"\[(.*?)\]".r;


@main def day5() = {
      var target = "grid"
      var slots = Map(
            "1" -> "",
             "2" -> "", 
             "3" -> "",
            //  "4" -> "",
            //  "5" -> "",
            //  "6" -> "",
            //  "7" -> "",
            //  "8" -> "",
            //  "9" -> ""
             )
      for (line <- Source.fromFile("day5.txt").getLines) {
            if(target == "grid") {
                  if(line == "") {
                        target = "instructions"
                  }
                  for(a <- raw"\[(.*?)\]".r.findAllMatchIn(line).map(_.start)) {
                        
                        val slot = ((a + 4) / 4).toString;
                        val letter = line.charAt(a + 1).toString;
                       
                        slots = slots.updated(slot, slots.get(slot).getOrElse("") + letter)
                  }
            } else {
                  println(line)
                  val quantity = line.split(" ")(1);
                  val from = line.split(" ")(3)
                  val to = line.split(" ")(5)

                  val shifty = slots.get(from).getOrElse("").substring(0, quantity.toInt)
                  val rest = slots.get(from).getOrElse("").substring(quantity.toInt)
                  slots = slots.updated(from, rest)

                  // remove reverse for part 2
                  slots = slots.updated(to, shifty + slots.get(to).getOrElse(""))
                  println("shifty:" +shifty)
                  println("rest:" +rest)
                  println(slots)
            }
      }
}