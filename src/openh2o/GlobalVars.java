package openh2o;
import visual.GraphSceneImpl;
/**
 *
 * @author cfviper
 */
public class GlobalVars {
    private static GraphSceneImpl scene;
    private static double zoomFactor = 1.0;
    
    
    ////////////////////// Zoom Factor //////////////////////////////
     public static double getZoomFactor(){
        return zoomFactor;
    }
    public static void setZoomFactor(double zoomMagnify){
        zoomFactor = zoomMagnify;
    }
    /////////////////////////////////////////////////////////////////  
    
    public static void setScene(GraphSceneImpl theScene){
        scene = theScene;
    }
    public static GraphSceneImpl getScene(){
        return scene;
    }
}
