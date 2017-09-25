package dsl

/**
 * Created by nikolatosic on 9/25/17.
 */
class ResourcePropertiesDsl extends HashMap<String, Object> {


  static ResourcePropertiesDsl make(Closure closure) {
    def dsl = new ResourcePropertiesDsl()
    closure.delegate = dsl
    closure()
    dsl
  }

  def methodMissing(String methodName, args) {
    assert args.size() == 1
    put(methodName, args[0])
  }

}
