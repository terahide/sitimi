import sitimi.spock.SitimiSpec

class SimpleCalcSpec extends SitimiSpec{
    def cleanup(){
        click 'imgs/window_close.png'
    }

    def "単純なシナリオ"(){
        given: "計算機が起動した状態で"
        click 'imgs/windows_start.png'
        write 'calc#ENTER.'

        when: "9+9を計算すると"
        click 'imgs/nine_button.png'
        click 'imgs/plus_button.png'
        click 'imgs/nine_button.png'
        click 'imgs/equal_button.png'

        then: "結果は18であるべき"
        exists 'imgs/18.png'
    }
}
