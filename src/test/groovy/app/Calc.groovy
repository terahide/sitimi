package app

import sitimi.Application

class Calc extends Application{
    def startOperation(){
        click 'imgs/windows_start.png'
        write 'calc#ENTER.'
    }
}
