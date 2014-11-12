import Logger._

object Demo extends App {
  
  Logger(1) |> { x => x + 1 } |> { x => s"a$x" } |> nothing

}


class Logger[T](v: T) {

  def |>[A](map: T => A): Logger[A] = {
    println(s"$v")
    new Logger(map(v))
  }
}


object Logger {
  def apply[T](v: T) = new Logger(v)
  def nothing[T](t: T) = {} 
}

