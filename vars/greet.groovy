def call(String name) {
    def utils = new com.example.utils()
    String greeting = utils.generateGreeting(name)
    echo greeting
}
