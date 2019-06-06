package app

import sitimi.Window

class CalcWindow extends Window{
    // def at(){ title == '電卓'}
    def "足し算する"(i, j){
        click "imgs/${i}_button.png"
        click "imgs/plus_button.png"
        click "imgs/${j}_button.png"
        click "imgs/equal_button.png"
    }
    def "結果は"(r){
        exists "imgs/${r}.png"
    }
    def "ウィンドウを閉じる"(){
        click 'imgs/window_close.png'
    }
}
