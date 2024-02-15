def call() {
def CountrysXmlFile = libraryResource("paramValues.xml")
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
def selectedTitle1 = xml.article.findAll { it.title.text() == "Test" }
println selectedTitle1
println "Step2"
selectedTitle1 = selectedTitle1.author.collect { it.firstname.text() }
println selectedTitle1
println "Step3"
return selectedTitle1//.author.firstname.collect { it.text() }

}
