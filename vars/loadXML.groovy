def call() {
  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
  println("${xmlContent }")
  //def xmlValue = libraryResource("paramValues.xml")

  def parser = new XmlParser()
  def list = parser.parseText(text)


  println list.env.envname.text()
  
  
}
