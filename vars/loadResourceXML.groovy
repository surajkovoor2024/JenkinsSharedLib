def call(String selectedEnv) {
println "Selected Environment: ${selectedEnv}"
echo selectedEnv
println("XML reading Starting")
def xmlContent = libraryResource('paramValues.xml')
println xmlContent
// Use XMLParser to parse the XML content
def xml = new XmlParser().parseText(xmlContent)

println("XML reading worked")
// Find the Country element based on the selected Country name
def selectedCountryElement = xml.article.author.firstname.collect { it.text() }
println xml.article.author.firstname
println selectedCountryElement
//return selectedCountryElement
println "Step1"
def selectedTitle  = xml.article.find { it.env == selectedEnv }
println "Step1.1"
selectedTitle = xml.article.find { it.env.text() == selectedEnv }.author.firstname.text()
println selectedTitle
println "Step1.2"
def selectedTitle1 = xml.article.findAll { it.env.text() == selectedEnv }
println selectedTitle1
println "Step2"
selectedTitle1 = selectedTitle1.author.collect { it.env.text() }
println selectedTitle1
println "Step3"
return selectedTitle1//.author.firstname.collect { it.text() }

}
