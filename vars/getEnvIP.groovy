def call(String selectedEnv) {
    try{
        println ("Method Start: ${selectedEnv}")
        if (selectedEnv == null || selectedEnv == '' || selectedEnv == null ||  selectedEnv == '') { 
            println("Empty Environment");
            return ["Unknown Environment from Git"]
        } else { 
            println ("Selected Environment ${selectedEnv}")
            println("XML reading Starting")
            def xmlContent = libraryResource('paramValues.xml')
            println xmlContent
            // Use XMLParser to parse the XML content
            def xml = new XmlParser().parseText(xmlContent)
            println("XML reading worked")
            println "Step1.2"
            def selectedTitle1 = xml.article.findAll { it.env.text() == selectedEnv }
            println selectedTitle1
            println "Step2"
            selectedTitle1 = selectedTitle1.author.collect { it.firstname.text() }
            println selectedTitle1
            println "Step3"
            return selectedTitle1//.author.firstname.collect { it.text() }
        }
    } catch(Exception ex) {
        println "Error Block"
        println selectedEnv
        println("Catching the exception");
        println ex.getMessage()
        println ex.getCause()
        println ex.fillInStackTrace()
        return ["Unknown Environment from git ex"]
    }
}
