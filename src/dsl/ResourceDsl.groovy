package dsl

import model.CfnResourceType
import model.DeletionPolicy

/**
 * Created by nikolatosic on 9/25/17.
 */
class ResourceDsl {

  CfnResourceType Type
  ResourcePropertiesDsl Properties

  static ResourceDsl make(Closure closure){

    dsl.ResourceDsl dsl = new ResourceDsl()
    closure.delegate = dsl
    closure()
    dsl
  }


  def type(String type){
    this.Type = new CfnResourceType(type)
  }

  def properties(Closure closure){
    Properties = ResourcePropertiesDsl.make(closure)
  }

}
