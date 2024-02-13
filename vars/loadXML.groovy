import groovy.xml.*
def call() {
    def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
      def xmlContent = CountrysXmlFile.text
    def list = new XmlSlurper().parseText(xmlContent)
    list.technology.name.text() // dot notation
    println list['technology']['name'].text() // square bracket notation
    println 'Step1'
    def personsOver28 = list.technology.find { it.name == 'Groovy' }
    println 'Step2'
    personsOver28.each { person -> println "Name: ${person.name.text()}" }
    println 'Step3'
}

