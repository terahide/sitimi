package app

import sitimi.Application

class Calc extends Application{
    //static path = 'C:\\Windows\\your_path\\calc.exe'
    def startOperation(){
        click 'src/test/imgs/windows_start.png'
        write 'calc#ENTER.'
    }
}
