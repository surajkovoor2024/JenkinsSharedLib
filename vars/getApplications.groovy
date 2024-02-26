def call() {
  def step = 'getApplications-Start'
  println step
  try {
      step = "Environment XML reading starting"
      //println(step)
      def xmlContent = libraryResource('application.xml')
      step = "Application XML loaded"
      //println(step)
      def applications = new XmlParser().parseText(xmlContent)
      step = "Application XML parsed"
      //println(step)
      def selectedAppElement = applications.name.collect { it.text() }
      step = "Applications name collected"
      //println(step)
      //println selectedAppElement
      return selectedAppElement
  } catch(Exception ex) {
      step = step + " " + ex.getMessage()
      println "getApplications-Error Block"
      println("getApplications-Catching the exception");
      println ex.getMessage()
      println ex.getCause()
      println ex.fillInStackTrace()
      return ["Error in getApplications.groovy - ${step}"]
    }
}
