import groovy.xml.*
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


    def xmlFile = getClass().getResourceAsStream("articles.xml")

    def articles = new XmlParser().parse(xmlFile)

    then: "Xml is loaded properly"
    articles.'*'.size() == 4
    articles.article[0].author.firstname.text() == "Siena"
    articles.article[2].'release-date'.text() == "2018-06-12"
    articles.article[3].title.text() == "Java 12 insights"
    articles.article.find { it.author.'@id'.text() == "3" }.author.firstname.text() == "Daniele"
}

