import org.sikuli.script.Screen
import spock.lang.Specification

class SimpleCalcSpec extends Specification{

    Screen screen

    def setup(){
        screen = new Screen()
        screen.click'imgs/windows_start.png'
        screen.write 'calc#ENTER.'
    }

    def cleanup(){
        screen.click'imgs/window_close.png'
    }

    def "単純なシナリオ"(){
        given:
        when:
        screen.click'imgs/nine_button.png'
        screen.click'imgs/plus_button.png'
        screen.click'imgs/nine_button.png'
        screen.click'imgs/equal_button.png'

        then:
        screen.exists'imgs/18.png'
    }
}
