
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
           try{
                println ("getEnvIP-Method Start: ${selectedEnv}")
                if (selectedEnv == null || selectedEnv == '' || selectedEnv == null ||  selectedEnv == '') { 
                    //If the condition is true print the following statement 
                    println("getEnvIP-Empty Environment");
                    return ["getEnvIP-Unknown Environment from Git"]
                } else { 
                    println ("getEnvIP-Selected Environment ${selectedEnv}")
                    println("getEnvIP-XML reading Starting")
                    def xmlContent = libraryResource('vSphereEnvWithIP.xml')
                    println xmlContent
                    // Use XMLParser to parse the XML content
                    def xml = new XmlParser().parseText(xmlContent)
        
                    println("getEnvIP-XML reading worked")
                    println "getEnvIP-Step1.2"
                    def envIP = xml.environments.findAll { it.environment.text() == selectedEnv }
                    println envIP
                    println "getEnvIP-Step2"
                    envIP = envIP.environment.find { it.ipaddr.text() }
                    println envIP
                    println "getEnvIP-Step3"
                    return envIP
                } 
          }catch(Exception ex) {
                    println "getEnvIP-Error Block"
                    println selectedEnv
                    println("getEnvIP-Catching the exception");
                    println ex.getMessage()
                    println ex.getCause()
                    println ex.fillInStackTrace()
                    return ["getEnvIP-Unknown Environment from git ex"]
          }
    }
}
