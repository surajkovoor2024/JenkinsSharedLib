
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
           try{
                println ("Method Start: ${selectedEnv}")
                if (selectedEnv == null || selectedEnv == '' || selectedEnv == null ||  selectedEnv == '') { 
                    //If the condition is true print the following statement 
                    println("Empty Environment");
                    return ["Unknown Environment from Git"]
                } else { 
                    println ("Selected Environment ${selectedEnv}")
                    println("XML reading Starting")
                    def xmlContent = libraryResource('vSphereEnvWithIP.xml')
                    println xmlContent
                    // Use XMLParser to parse the XML content
                    def xml = new XmlParser().parseText(xmlContent)
        
                    println("XML reading worked")
                    println "Step1.2"
                    def envIP = xml.environments.findAll { it.environment.text() == selectedEnv }
                    println envIP
                    println "Step2"
                    envIP = envIP.environment.find { it.ipaddr.text() }
                    println envIP
                    println "Step3"
                    return envIP
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
}
