import app.Calc
import app.CalcWindow
import sitimi.spock.SitimiSpec

class SimpleCalcSpec extends SitimiSpec{
    def cleanup(){
        "ウィンドウを閉じる"()
    }

    def "単純なシナリオ"(){
        given:
        start Calc
        expect:
        shown CalcWindow

        when:
        "足し算する" 9, 9

        then:
        "結果は" 18
    }
}
