def call(String name) {
    def utils = new com.example.Utils()
    String greeting = utils.generateGreeting(name)
    echo greeting
}
