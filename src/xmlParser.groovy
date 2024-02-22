
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
        def step = "getEnvIP-Start"
           try{
                if (selectedEnv == null || selectedEnv == '') { 
                    return ["xmlParser-getEnvIP-If block from Git"]
                } else {
                    step = "getEnvIP-xml reading starting"
                    def xmlContent = libraryResource('vSphereEnvWithIP.xml')
                    step = "getEnvIP-xml reading completed"
                    def xml = new XmlParser().parseText(xmlContent)
                    step = "getEnvIP-xml parsing completed"
                    return ["xmlParser-getEnvIP-Else block from Git ${xmlContent}"]
                }               
          } catch(Exception ex) {
                    step = step + " " + ex.getMessage()
                    println "getEnvIP-Error Block"
                    println selectedEnv
                    println("getEnvIP-Catching the exception");
                    println ex.getMessage()
                    println ex.getCause()
                    println ex.fillInStackTrace()
                    return ["getEnvIP-Unknown Environment from git ex ${step}"]
          }
    }
}
