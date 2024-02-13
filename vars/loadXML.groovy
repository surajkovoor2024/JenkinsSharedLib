def call() {
  def CountrysXmlFile = new File("//10.206.6.73/Shared/XML/paramValues.xml")
  def xmlContent = CountrysXmlFile.text
  println("XML reading Starting")
  println("${xmlContent }")
  //def xmlValue = libraryResource("paramValues.xml")
  def xml = new XmlSlurper().parseText(xmlContent)
  println("${xml.env[0].envname}")
  //println("RootName: ${xml.name()}")
  //println("RootName: ${xml.env.envname}")  
  // Find the ENV element based on the selected Country name
  //assert xml.env.envname == "DEV"
  
  
  def personsOver28 = xml.env.findAll { env ->
    env.envid.toInteger() > 1
  }

  println("Size: ${personsOver28.size()}")
  
  personsOver28.each { person ->
    println "Name: ${person.envname.text()}, Age: ${person.envage.text()}"
  }

  
  //xml.env.find {it.envname.text() == abc}  
 // xml.env.find { node ->
//      node.envname == 'book' && node.@id == '2'
//  }
  //def selectedENV = xml.env.find {it.envname == "DEV"}
  //println("Finding ENV Detail: ${selectedENV.size()}")
  //println("Finding ENV Detail: ${selectedENV.envname}")
  //println("${selectedENV.PowerOption.text()}")
}
