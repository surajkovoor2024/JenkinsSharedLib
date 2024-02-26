def call() {
  def step = 'getEnvironment-Start'
  println step
  try {
      step = "Environment XML reading starting"
      //println(step)
      def xmlContent = libraryResource('vSphereEnvWithIP.xml')
      step = "Environment XML loaded"
      //println(step)
      def environments = new XmlParser().parseText(xmlContent)
      step = "Environment XML parsed"
      //println(step)
      def selectedEnvElement = environments.environment.name.collect { it.text() }
      step = "Environment name collected"
      //println(step)
      //println selectedEnvElement
      return selectedEnvElement
  } catch(Exception ex) {
      step = step + " " + ex.getMessage()
      println "getEnvIP-Error Block"
      println selectedEnv
      println("getEnvIP-Catching the exception");
      println ex.getMessage()
      println ex.getCause()
      println ex.fillInStackTrace()
      return ["Error in getEnvironment.groovy - ${step}"]
    }
}
