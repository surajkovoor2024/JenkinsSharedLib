def call(String selectedEnv) {
    try{
        def utils = new xmlParser()
        println "getEnvIP Git called"
        String envIP = utils.getEnvIP(selectedEnv)
        echo envIP
        if(envIP == '' || envIP == null) {
            return 'Not Found'
        }else {
            return envIP            
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
