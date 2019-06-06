package sitimi.spock


import sitimi.Computer
import spock.lang.Shared
import spock.lang.Specification

class SitimiSpec extends Specification{
    @Shared
    Computer computer_

    Computer getComputer(){
        computer_
    }

    def setup(){
        computer_ = new Computer()
        //TODO アプリの起動
    }

    def cleanup() {
        //TODO アプリの終了
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
