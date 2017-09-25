package dsl

/**
 * Created by nikolatosic on 9/25/17.
 */
class ResourcesDsl extends HashMap<String,ResourceDsl>{

  static ResourcesDsl make(closure){
    def dsl = new ResourcesDsl()
    closure.delegate = dsl
    closure()
    dsl
  }


  def resource(String name, Closure closure){
    put(name, ResourceDsl.make(closure))
  }

}
