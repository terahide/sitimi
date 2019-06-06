package app

import sitimi.Window

class CalcWindow extends Window{
    // def at(){ title == '電卓'}
    def "足し算する"(i, j){
        click "src/test/imgs/${i}_button.png"
        click "src/test/imgs/plus_button.png"
        click "src/test/imgs/${j}_button.png"
        click "src/test/imgs/equal_button.png"
    }
    def "結果は"(r){
        exists "src/test/imgs/${r}.png"
    }
    def "ウィンドウを閉じる"(){
        click 'src/test/imgs/window_close.png'
    }
}
