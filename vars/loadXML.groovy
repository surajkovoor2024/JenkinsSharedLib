def call() {
  //  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  //    def xmlContent = CountrysXmlFile.text
  //  def list = new XmlSlurper().parseText(xmlContent)
  //  list.technology.name.text() // dot notation
  //  println list['technology']['name'].text() // square bracket notation
  //  println 'Step1'
  //  def personsOver28 = list.technology.find { it.name.text() == 'Groovy' }
  //  println 'Step2'
  //  list.technology.each { person -> println "Name: ${person.name}" }
  //  println 'Step3'
  //  //println list.technology.findAll { it.name == "Groovy" }.technology.name


  //  def xmlFile = getClass().getResourceAsStream("//10.206.6.73/Shared/XML/paramValues.xml")    
  //  def articles = new XmlParser().parse(xmlFile)
  //  then: "Xml is loaded properly"

   def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
def xmlContent = CountrysXmlFile.text

println("XML reading Starting")
// Use XMLSlurper to parse the XML content
def xml = new XmlSlurper().parseText(xmlContent)

println("XML reading worked")

// Find the Country element based on the selected Country name
def selectedCountryElement = xml.article.author.firstname.collect { it.text() }
println selectedCountryElement
return selectedCountryElement
}

