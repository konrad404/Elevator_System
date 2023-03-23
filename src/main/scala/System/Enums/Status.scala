package System.Enums
sealed trait Status

object Status {

}

//BUSY oznacza że panel kontrolny wewnątrz windy wymusza pojechanie na konkretne piętro
case object BUSY extends Status
//FREE oznacza że winda jest wolna
case object FREE extends Status
