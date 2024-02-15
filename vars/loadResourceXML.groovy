def call(selectedEnv) {
    try{

        if (selectedEnv == null || selectedEnv == '') { 
            //If the condition is true print the following statement 
            println("Empty Environment");
            return ["Unknown Environment from Git"]
        } else { 
            println "Get Prop"
            def props = selectedEnv.properties
            println props

            println "Get Methods"
            def methods = selectedEnv.metaClass.methods.findAll { it.declaringClass == java.lang.String }
            // Print the list
            println methods


            println "Selected Environment: ${(String.valueOf((selectedEnv as java.lang.String)))}"

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
            //selectedTitle = xml.article.find { it.env.text() == selectedEnv }.author.firstname.text()
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
    }catch(Exception ex) {
        println "Error Block"
        println selectedEnv
        println("Catching the exception");
        println ex.getMessage()
        println ex.getCause()
        println ex.fillInStackTrace()
        return ["Unknown Environment from git ex"]
    }
}
