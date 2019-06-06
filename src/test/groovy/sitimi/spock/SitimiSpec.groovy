package sitimi.spock

import sitimi.ScreenX
import spock.lang.Specification

class SitimiSpec extends Specification{
    ScreenX screen

    ScreenX getScreen(){
        screen
    }

    def setup(){
        screen = new ScreenX()
        //TODO アプリの起動
    }

    def cleanup() {
        //TODO アプリの終了
    }

    def methodMissing(String name, args) {
        getScreen()."$name"(*args)
    }

    def propertyMissing(String name) {
        getScreen()."$name"
    }

    def propertyMissing(String name, value) {
        getScreen()."$name" = value
    }
}
