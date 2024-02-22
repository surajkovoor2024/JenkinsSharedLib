
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
           try{
                if (selectedEnv == null || selectedEnv == '') { 
                    return ["xmlParser-getEnvIP-If block from Git"]
                } else {
                    def xmlContent = libraryResource('vSphereEnvWithIP.xml')
                    //def xml = new XmlParser().parseText(xmlContent)
                    return ["xmlParser-getEnvIP-Else block from Git ${xmlContent}"]
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
