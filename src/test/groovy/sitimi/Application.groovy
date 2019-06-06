package sitimi

class Application {
    static path = ""
    //TODO static startOperation = {} にしたい
    def startOperation(){

    }


    private Computer computer_
    Application init(Computer computer){
        computer_ = computer
        this
    }

    Computer getComputer(){
        computer_
    }

    def methodMissing(String name, args) {
        getComputer()."$name"(*args)
    }

    def propertyMissing(String name) {
        getComputer()."$name"
    }

    def propertyMissing(String name, value) {
        getComputer()."$name" = value
    }
}
