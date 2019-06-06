package app

import sitimi.Application

class Calc extends Application{
    def startOperation(){
        click 'src/test/imgs/windows_start.png'
        write 'calc#ENTER.'
    }
}
