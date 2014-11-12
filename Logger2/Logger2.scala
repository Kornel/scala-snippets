
object Logger2Demo extends App {
 
  val uu = for {
    v1 <- Logger(10)
    v2 <- Logger(2)
  } yield v1 + v2

  println(uu)
}

class Logger[T](v: T) {

  def flatMap[R](f: (T) => Logger[R]): Logger[R] = f(v)

  def map[R](f: (T) => R): Logger[R] = flatMap(x => Logger(f(x)))

  override def toString = s"Logger($v)"

}

object Logger {
  
  def apply[T](v: T) = new Logger(v)

}

