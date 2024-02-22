
class xmlParser {
    
    String getEnvIP(String selectedEnv) {
           try{
                println "getEnvIP-Method Start"
                println "getEnvIP Git called-1"
                println("Hello getEnvIP")
                echo "Hello getEnvIP echo"
                if (selectedEnv == null || selectedEnv == '' || selectedEnv == null ||  selectedEnv == '') { 
                    //If the condition is true print the following statement 
                    println("getEnvIP-Empty Environment");
                    echo "If Condition"
                    return ["xmlParser-getEnvIP-Unknown Environment from Git"]
                } else { 
                    return ["xmlParser-getEnvIP-Else block Environment from Git"]
                    echo "else Condition"
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
