def call() {
import groovy.xml.slurpersupport.GPathResult
try{
def selectedCountry = "India"
println("Selected Country : ${selectedCountry}")
def CountrysXmlFile = new File("//172.16.0.16/Published/ChoiceParameter/Cities.xml")
def xmlContent = CountrysXmlFile.text

println("XML reading Starting")
// Use XMLSlurper to parse the XML content
def xml = new XmlSlurper().parseText(xmlContent)

println("XML reading worked")

// Find the Country element based on the selected Country name
def selectedCountryElement = xml.country.find { it.name.text() == selectedCountry }

// Extract cities from the selected Country element
def stateOptions = selectedCountryElement?.States.state.collect { it.name.text() }

def htmlChoices = stateOptions.collect { "<option>${it}</option>" }.join('\n')

} catch (Exception e) {
    // Log the error (useful for troubleshooting)
    println("Error reading XML file or parsing XML content: ${e.message}")
def errorstr = e.getMessage()
    // Return a default message or an empty dropdown in case of an error
}
}

