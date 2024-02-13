def call() {
  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
  println("${xmlContent }")
  //def xmlValue = libraryResource("paramValues.xml")
  def xml = new XmlSlurper().parseText(xmlContent)
  println("${xml.env[0].envname}")
  //println("RootName: ${xml.name()}")
  //println("RootName: ${xml.env.envname}")  
  // Find the ENV element based on the selected Country name
  //assert xml.env.envname == "DEV"
  def selectedENV = xml.env.find {it.envname == "DEV"}
  println("Finding ENV Detail: ${selectedENV.name()}")
  println("Finding ENV Detail: ${selectedENV.size()}")
  println("${selectedENV.PowerOption.text()}")
}
