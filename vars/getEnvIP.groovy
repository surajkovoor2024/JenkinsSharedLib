def call(String selectedEnv) {
	def step = "getEnvIP-Start-${selectedEnv}"
	println step
    try{          
        
          if (selectedEnv == null || selectedEnv == '') { 
                    //If the condition is true print the following statement 
                    println("getEnvIP-Empty Environment");
                    return ["getEnvIP-Unknown Environment from Git"]
            } else { 
                    step = "getEnvIP-xml reading starting"
                    //println(step)
                    def xmlContent = libraryResource('vSphereEnvWithIP.xml')
                    step = "getEnvIP-xml reading completed"
                    //println(step)
                    //println xmlContent
                    // Use XMLParser to parse the XML content
                    def xml = new XmlParser().parseText(xmlContent)
                    step = "getEnvIP-xml parsing completed"
                    //println(step)
                    def envIP = xml.environment.find { it.name.text() == selectedEnv }
                    step = "getEnvIP-xml filter completed"
                    //println(step)
                    step = "getEnvIP-xml filtered IP - ${envIP.ipaddr.text()}"
                    //println(step)
		    envIP = envIP.ipaddr.text()
		  if(envIP == '' || envIP == null) {
            		return 'IP Not Found for ${selectedEnv} environment'
        	  } else {
            		return envIP            
        	  }
	}  
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
