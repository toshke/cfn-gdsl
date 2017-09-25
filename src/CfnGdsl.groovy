import dsl.MappingsDsl
import dsl.ResourcesDsl

/**
 * Created by nikolatosic on 9/25/17.
 */
class CfnGdsl {

  MappingsDsl Mappings
  ResourcesDsl Resources

  static CfnGdsl make(closure){
      CfnGdsl template = new CfnGdsl()
      closure.delegate = template
      closure()
      return template
  }

  def mappings(closure){
    Mappings = MappingsDsl.make(closure)
  }

  def resources(closure){
    Resources = ResourcesDsl.make(closure)
  }

}
