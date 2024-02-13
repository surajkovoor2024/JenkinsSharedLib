def call() {
  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
  println("${xmlContent }")

  def xmlValue = libraryResource("paramValues.xml")
  def xml = new XmlSlurper().parseText(xmlValue)
  //println("${xml.text()}")
  println("RootName: ${xml.name()}")
  // Find the ENV element based on the selected Country name
  def selectedENV = xml.ENV.find{e -> e.name.text() == "DEV"}
  println("Finding ENV Detail")
  println("${selectedENV.name()}")
  println("${selectedENV.PowerOption.text()}")
}
