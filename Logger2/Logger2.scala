
object Logger2Demo extends App {

  val uu2 = for {
    v1 <- Logger("got 10", 10)
    v2 <- Logger("got 2", 2)
  } yield v1 + v2

  println(uu2)

}

class Logger[T](val v: (List[String], T)) {

  def flatMap[R](f: (T) => Logger[R]): Logger[R] = {
    val a = f(v._2)
    val lp = a.v._1
    val vp = a.v._2
    new Logger(lp ++ v._1, vp)
  }

  def map[R](f: (T) => R): Logger[R] = flatMap(x => new Logger(Nil, f(x)))

  override def toString = s"$v"

}

object Logger {
  
  def apply[T](log: String, v: T) = new Logger((List(log), v))

}

