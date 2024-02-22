def call(String selectedEnv) {
	def step = "getEnvIP-Start"
    try{
        //def utils = new xmlParser()
        //println "getEnvIP Git called"
       // String envIP = utils.getEnvIP(selectedEnv)

            
        println step


          if (selectedEnv == null || selectedEnv == '') { 
                    //If the condition is true print the following statement 
                    println("getEnvIP-Empty Environment");
                    return ["getEnvIP-Unknown Environment from Git"]
            } else { 
                    step = "getEnvIP-xml reading starting"
                    println(step)
                    def xmlContent = libraryResource('vSphereEnvWithIP.xml')
                    step = "getEnvIP-xml reading completed"
                    println(step)
                    println xmlContent
                    // Use XMLParser to parse the XML content
                    def xml = new XmlParser().parseText(xmlContent)
                    step = "getEnvIP-xml parsing completed"
                    println(step)
                    def envIP = xml.environment.find { it.name.text() == selectedEnv }
                    step = "getEnvIP-xml filter completed}"
                    println(step)
		    println(envIP.size())
                    envIP = envIP.find { it.ipaddr.text() }
                    step = "getEnvIP-xml collect IP completed - ${envIP.name}"
                    println(step)
                    return envIP
					 } 
    

        
        //echo envIP     
        //if(envIP == '' || envIP == null) {
        //    return 'Not Found'
        //}else {
          //  return envIP            
        //}
    } catch(Exception ex) {
        step = step + " " + ex.getMessage()
                    println "getEnvIP-Error Block"
                    println selectedEnv
                    println("getEnvIP-Catching the exception");
                    println ex.getMessage()
                    println ex.getCause()
                    println ex.fillInStackTrace()
        return ["Unknown Environment from git ex - ${step}"]
    }
}
