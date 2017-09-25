package dsl

/**
 * Created by nikolatosic on 9/25/17.
 */
class MappingsDsl extends HashMap<String,Object> {


  static MappingsDsl make(Closure closure) {

    dsl.MappingsDsl dsl = new MappingsDsl()
    closure.delegate = dsl
    closure()
    return dsl
  }

  def add(String name, Map map) {
    put(name, map)
  }

}
