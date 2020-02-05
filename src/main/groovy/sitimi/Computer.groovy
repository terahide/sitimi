package sitimi

import org.sikuli.script.App
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

    private Screen getScreen(){
        s
    }

    private hasMethod = {o, name, args ->
        if( 1 <= o.metaClass.getMethods().findAll { it.name == name}.count { checkParameters(it, args) } ){
            return true
        }
        return false
    }

    private checkParameters = {method, args ->
        try{
            method.checkParameters(args.collect { it.class }.toArray(new Class[args.size()]))
        }catch(IllegalArgumentException e){
            return false
        }
        true
    }

    def methodMissing(String name, args) {
        args = args.collect { it instanceof GString ? it.toString() : it }
        try{
            getScreen()."$name"(*args)
        }catch(MissingMethodException e) {
            if (hasMethod(getWindow(), name, args)){
                return getWindow()."$name"(*args)
            }
            throw new IllegalStateException("${new MissingMethodException(name, getWindow().class, *args).getMessage()}\r\nor ${e.getMessage()}")
        }
    }

    def propertyMissing(String name) {
        try{
            getScreen()."$name"
        }catch(MissingPropertyException e) {
            if (getWindow().metaClass.hasProperty(getWindow(), name)){
                return getWindow()."$name"
            }
            throw new MissingPropertyException("${new MissingPropertyException(name, getWindow().class).getMessage()}\r\nor ${e.getMessage()}")
        }
    }

    def propertyMissing(String name, value) {
        value = value instanceof GString ? value.toString() : value
        try{
            getScreen()."$name" = value
        }catch(MissingPropertyException e) {
            if (getWindow().metaClass.hasProperty(getWindow(), name)){
                getWindow()."$name" = value
            }
            throw new MissingPropertyException("${new MissingPropertyException(name, getWindow().class).getMessage()}\r\nor ${e.getMessage()}")
        }
    }

    public <T extends Application> void start(Class<T> a) {
        start(createApplication(a))
    }

    public <T extends Application> void start(T a) {
        application_ = a
        if( Util.isEmpty( a.path ) ){
            a.startOperation()
            return
        }

        App.open a.path
    }

    def capture(file){
        def dir = new File('build/reports/tests/evidences')
        if( ! dir.exists())dir.mkdirs()
        def image = getScreen().capture()// Screen as SikuliX
        new File("${file}.png", dir) << new File(image.getFile()).getBytes()
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
