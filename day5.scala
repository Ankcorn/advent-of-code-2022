import scala.io.Source
import scala.compiletime.ops.string

val bucketMatch = raw"\[(.*?)\]".r;

def insert[T](list: List[T], i: Int, value: T): List[T] = {
  return list.take(i) ++ List(value) ++ list.drop(i)
}

@main def day5() = {
      var target = "grid"
      var slots = List.empty[String]
      var instructions = List.empty[String]
      for (line <- Source.fromFile("day5.txt").getLines) {
            if(target == "grid") {
                  if(line == "") {
                        target = "instructions"
                  }
                  for(a <- raw"\[(.*?)\]".r.findAllMatchIn(line).map(_.start)) {
                        val slot = (line.length - 1) / (line.length - a + 1);
                        val letter = line.charAt(a + 1);
                        slots.lift(slot) match {
                              case Some(value) =>
                                    println(slot + " " + value + letter.toString)
                                    slots = list.take(slot) ++ List(letter) ++ list.drop(slot)
                              case None =>
                                    slots = insert(slots, slot, letter.toString)
                        }
                  }
            } else {
                  instructions = line :: instructions
            }
      }
      println(slots)
}