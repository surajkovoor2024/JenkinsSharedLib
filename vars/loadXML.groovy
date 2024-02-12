def call() {
  def selectedCountry = Country
  println("Selected Country : ${Country}")
  def CountrysXmlFile = new File("//172.16.0.16/Published/ChoiceParameter/Cities.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
}
