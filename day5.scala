import scala.io.Source
import scala.compiletime.ops.string

val bucketMatch = raw"\[(.*?)\]".r;


@main def day5() = {
      var target = "grid"
      var slots = Map( "0" -> "", "1" -> "", "2" -> "")
      var instructions = List.empty[String]
      for (line <- Source.fromFile("day5.txt").getLines) {
            if(target == "grid") {
                  if(line == "") {
                        target = "instructions"
                  }
                  for(a <- raw"\[(.*?)\]".r.findAllMatchIn(line).map(_.start)) {
                        val slot = ((line.length - 1) / (line.length - a + 1)).toString;
                        val letter = line.charAt(a + 1).toString;
                        
                        slots = slots.updated(slot, slots.get(slot).getOrElse("") + letter)
                  }
            } else {
                  instructions = line :: instructions
            }
      }
      println(slots)
}