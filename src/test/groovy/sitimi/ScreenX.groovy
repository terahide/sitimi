package sitimi

import org.sikuli.script.Screen

class ScreenX {

    Screen s

    ScreenX(){
        s = new Screen()
    }

    void click(String img){
        s.click img
    }

    void write(String text){
        s.write(text)
    }

    boolean exists(String expectedIimg){
        s.exists expectedIimg
    }

}
