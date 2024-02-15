def call() {
  println("Environment XML reading starting")
  def xmlContent = libraryResource('environment.xml')
  println xmlContent
  def environments = new XmlParser().parseText(xmlContent)
  println("XML reading worked")
  // Find the Country element based on the selected Country name
  def selectedEnvElement = environments.environment.name.collect { it.text() }
  println selectedEnvElement
  return selectedEnvElement
}

