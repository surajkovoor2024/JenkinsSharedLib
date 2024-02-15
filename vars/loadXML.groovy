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
//def xml = new XmlSlurper().parseText(xmlContent)
def xml = new XmlParser().parseText(xmlContent)

println("XML reading worked")

// Find the Country element based on the selected Country name
def selectedCountryElement = xml.article.author.firstname.collect { it.text() }
println xml.article.author.firstname
println selectedCountryElement
//return selectedCountryElement
println "Step1"
def selectedTitle  = xml.article.find { it.title == "Test" }
println "Step1.1"
selectedTitle = xml.article.find { it.title.text() == "Test" }.author.firstname.text()
println selectedTitle
println "Step1.2"
def selectedTitle1 = xml.article.find { it.title.text() == "Test" }
println selectedTitle1
println "Step2"
selectedTitle1 = selectedTitle1.author.collect { it.firstname.text() }
println selectedTitle1
println "Step3"
selectedTitle1.text()
println "Step4"
return selectedTitle1//.author.firstname.collect { it.text() }

}

