
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
           try{
                if (selectedEnv == null || selectedEnv == '') { 
                    return ["xmlParser-getEnvIP-If block from Git"]
                } else { 
                    return ["xmlParser-getEnvIP-Else block from Git"]
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
