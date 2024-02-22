def call(String selectedEnv) {
    try{
        String envIP = xmlparser.xmlParser.getEnvIP(selectedEnv)
        echo envIP
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
