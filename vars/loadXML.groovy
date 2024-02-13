def call() {
    def list = new XmlSlurper().parseText(xml)
    list.technology.name.text() // dot notation
    println list['technology']['name'].text() // square bracket notation
}

