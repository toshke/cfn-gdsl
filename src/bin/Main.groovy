import groovy.json.JsonOutput
import org.codehaus.groovy.bsf.GroovyEngine

import static CfnGdsl.*

class Main {
  static void main(String[] args) {
    def gdslTemplate = null

    def fileName = args[0],
        templateText = new File(fileName).text,
        fullScript = """
  def compileCfn() { $templateText } 
"""

    def script = new GroovyShell().parse(fullScript)

    script.metaClass.cfn = {
      gdslTemplate = CfnGdsl.make(it)
    }
    script.compileCfn()
    System.out.println(JsonOutput.prettyPrint(JsonOutput.toJson(gdslTemplate)))
  }
}




