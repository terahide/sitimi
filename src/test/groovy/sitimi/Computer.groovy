package sitimi

import org.sikuli.script.Screen

class Computer {

    private Screen s
    private Application application_;
    private Window window_

    Computer(){
        s = new Screen()
        window_ = new Window()
    }

    def getWindow(){
        window_
    }

    def methodMissing(String name, args) {
        getWindow()."$name"(*args)
    }

    def propertyMissing(String name) {
        getWindow()."$name"
    }

    def propertyMissing(String name, value) {
        getWindow()."$name" = value
    }

//TODO このへんScreenWrapperに移すかも
    def click(String img){
        s.click img
    }

    def write(String text){
        s.write(text)
    }

    boolean exists(String expectedIimg){
        s.exists expectedIimg
    }

//-- ここまで

    public <T extends Application> void start(Class<T> a) {
        start(createApplication(a))
    }

    public <T extends Application> void start(T a) {
        application_ = a
        if( Util.isEmpty( a.path ) ){
            a.startOperation()
            return
        }

        //TODO app start from path
    }

    private <T extends Application> T createApplication(Class<T> clazz){
        clazz.newInstance().init(this)
    }

    public <T extends Window> boolean shown(Class<T> w) {
        shown(createWindow(w))
    }

    public <T extends Window> boolean shown(T w) {
        window_ = w
        w.at()
    }

    private <T extends Window> T createWindow(Class<T> clazz){
        clazz.newInstance().init(this)
    }

    class Util{
        static def isEmpty(String s){
            s == null || s.isEmpty()
        }
    }
}