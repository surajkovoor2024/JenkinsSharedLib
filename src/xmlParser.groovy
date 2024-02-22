
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
           try{
                println "getEnvIP-Method Start: ${selectedEnv}"
                return "Hello from xml parser get env ip ${selectedEnv}"
               
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
