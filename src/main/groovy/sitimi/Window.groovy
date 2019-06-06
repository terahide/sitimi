package sitimi

class Window {
    //TODO static at = {} にしたい
    def at(){
        true
    }

    //TODO メソッドじゃなくて static content = {} にしたい

    private Computer computer_
    Window init(Computer computer){
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
