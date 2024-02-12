def call() {
  def selectedCountry = Country
  println("Selected Country : ${Country}")
  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
}
