def call() {
  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
  println("${xmlContent }")

  def xmlValue = libraryResource("paramValues.xml")
  println("Another XML reading Starting")
  println("${xmlContent }")
}
