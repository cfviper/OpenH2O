package visual;

/**
 *
 * @author cfviper
 */
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import openh2o.GlobalVars;
//import misc.GlobalVars;
import org.netbeans.api.visual.action.*;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.layout.SceneLayout;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.widget.general.IconNodeWidget;
import visual.GraphSceneImpl.MyNode;

public class GraphSceneImpl extends GraphScene<String, String> {

    private static class ImageUtilities {

        private static Image loadImage(String vislibdemoredgif) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        public ImageUtilities() {
        }
    }
    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private LayerWidget interactionLayer;
    private Image img1;
    private static Scene sceneToSave;
    protected static SceneLayout zoomIn;
     protected SceneLayout layout;
    long nodeIDcounter = 0;
    long edgeIDcounter = 0;
    static int firstLoad = 0;
    private Scene sc = new Scene(); //
    private JScrollPane scrollPane2 = new JScrollPane();//
    LayerWidget layer1;
    private int nodeCounter = 0;
    
    
    private  String title;

    public GraphSceneImpl(String title){
         mainLayer = new LayerWidget(this);
        connectionLayer = new LayerWidget(this);
        interactionLayer = new LayerWidget(this);
        addChild(mainLayer); // where is scene coming from that the child is being added too
        addChild(connectionLayer);
        addChild(interactionLayer);

        System.out.println(getScene().toString());
        
        SceneCreateAction SCA = new SceneCreateAction();

        try {
            img1 = ImageIO.read(new File("C:\\Users\\cfviper\\Documents\\NetBeansProjects\\WUB\\Writer\\src\\views\\standard\\timeline\\displayable_64.png"));          
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }

          loadScene(title);

        
        // zoom: press ctrl+scroll  (try to change this to not require ctrl)
        getActions().addAction(ActionFactory.createZoomAction());

        getActions().addAction(ActionFactory.createAcceptAction(new AcceptProvider() {

            @Override
            public ConnectorState isAcceptable(Widget widget, Point point, Transferable transferable) {
                Image dragImage = img1;
                JComponent view = getView();
                Graphics2D g2 = (Graphics2D) view.getGraphics();
                Rectangle visRect = view.getVisibleRect();
                view.paintImmediately(visRect.x, visRect.y, visRect.width, visRect.height);
                g2.drawImage(dragImage,
                        AffineTransform.getTranslateInstance(point.getLocation().getX(),
                        point.getLocation().getY()),
                        null);
                return ConnectorState.ACCEPT;
            }

            @Override
            public void accept(Widget widget, Point point, Transferable transferable) {
                Image image = img1;
                Widget w = GraphSceneImpl.this.addNode("img1");//new MyNode(image)
                w.setPreferredLocation(widget.convertLocalToScene(point));
            }
        }));

        getActions().addAction(SCA);
    }
    
    public GraphSceneImpl() {
        // scrollPane2.setViewportView(sc.createView());//
        // layer1 = new LayerWidget(sc);
        sc = getScene();
       
        mainLayer = new LayerWidget(this);
        connectionLayer = new LayerWidget(this);
        interactionLayer = new LayerWidget(this);
        addChild(mainLayer); // where is scene coming from that the child is being added too
        addChild(connectionLayer);
        addChild(interactionLayer);
//        sc.addChild(mainLayer);
//        sc.addChild(connectionLayer);
//        sc.addChild(interactionLayer);
        System.out.println(getScene().toString());
        
        SceneCreateAction SCA = new SceneCreateAction();

        try {
            img1 = ImageIO.read(new File("C:\\Users\\cfviper\\Documents\\NetBeansProjects\\WUB\\Writer\\src\\views\\standard\\timeline\\displayable_64.png"));          
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }


        // removing loc causes null pointer
//        Widget w1 = addNode("1. Hammer");
//        w1.setPreferredLocation(new Point(10, 100));
//        Widget w2 = addNode("2. Saw");
//        w2.setPreferredLocation(new Point(100, 250));
//        Widget w3 = addNode("Nail");
//        w3.setPreferredLocation(new Point(250, 250));
//        Widget w4 = addNode("Bolt");
//        w4.setPreferredLocation(new Point(250, 350));

//        if(firstLoad == 0){
//            System.out.println(firstLoad+"");
//            loadScene();
//            firstLoad = 1;
//        }else{
   
        
        // zoom: press ctrl+scroll  (try to change this to not require ctrl)
        getActions().addAction(ActionFactory.createZoomAction());

        getActions().addAction(ActionFactory.createAcceptAction(new AcceptProvider() {

            @Override
            public ConnectorState isAcceptable(Widget widget, Point point, Transferable transferable) {
                Image dragImage = img1;
                JComponent view = getView();
                Graphics2D g2 = (Graphics2D) view.getGraphics();
                Rectangle visRect = view.getVisibleRect();
                view.paintImmediately(visRect.x, visRect.y, visRect.width, visRect.height);
                g2.drawImage(dragImage,
                        AffineTransform.getTranslateInstance(point.getLocation().getX(),
                        point.getLocation().getY()),
                        null);
                return ConnectorState.ACCEPT;
            }

            @Override
            public void accept(Widget widget, Point point, Transferable transferable) {
                Image image = img1;
                Widget w = GraphSceneImpl.this.addNode("img1");//new MyNode(image)
                w.setPreferredLocation(widget.convertLocalToScene(point));
            }
        }));

        getActions().addAction(SCA);
        
    }

    protected void attachEdgeSourceAnchor(String e, MyNode n, MyNode n1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    protected void attachEdgeTargetAnchor(String e, MyNode n, MyNode n1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Image getImageFromTransferable(Transferable transferable) throws UnsupportedFlavorException {
        Object o = null;
        try {
            o = transferable.getTransferData(DataFlavor.imageFlavor);
        } catch (IOException ex) {
        } catch (UnsupportedFlavorException ex) {
        }
        return o instanceof Image ? (Image) o : ImageUtilities.loadImage("org/netbeans/shapesample/palette/shape1.png");
    }
   
    public final void loadScene() {
        SceneSerializer.deserialize(this,  new File("C:\\Users\\cfviper\\Documents\\NetBeansProjects\\WUB\\Writer\\stories\\Timeline\\"+"name2"+".tl"));
         System.out.println("Load Scene first time...");
    }
    
    public  void loadScene(String timelineNode) {
        System.out.println("load: "+mainLayer.getChildren());
        mainLayer.removeChildren();
        SceneSerializer.deserialize(this,  new File("C:\\Users\\cfviper\\Documents\\NetBeansProjects\\WUB\\Writer\\stories\\Timeline\\"+timelineNode+".tl"));//+".tl"
        validate();
    }

    public void saveScene(String timelineNode) {
        //timelineNode = "name.tl";
        System.out.println("saving");
        System.out.println(mainLayer.getChildren());
        validate();
        SceneSerializer.serialize(GlobalVars.getScene(), new File("C:\\Users\\cfviper\\Documents\\NetBeansProjects\\WUB\\Writer\\stories\\Timeline\\" + timelineNode+".tl"));//+".tl"
    }
/////////
   
//////    
    public class MyNode {
        // is this class needed

        private Image image;

        public MyNode(Image image) {
            this.image = image;
        }

        public Image getImage() {
            return image;
        }
    }

     @Override
    protected Widget attachNodeWidget(String arg) {
        IconNodeWidget widget = new IconNodeWidget(this);

        if (arg.startsWith("1")) {
            widget.setImage(img1);
        } else if (arg.startsWith("2")) {
            widget.setImage(img1);
        } else {
            widget.setImage(img1);
        }

        widget.getActions().addAction(
                ActionFactory.createExtendedConnectAction(
                connectionLayer, new MyConnectProvider()));

        widget.getActions().addAction(
                ActionFactory.createAlignWithMoveAction(
                mainLayer, interactionLayer,
                ActionFactory.createDefaultAlignWithMoveDecorator()));

        widget.setLabel(arg);
        mainLayer.addChild(widget);
        return widget;
    }

    @Override
    protected Widget attachEdgeWidget(String arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeSourceAnchor(String arg0, String arg1, String arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeTargetAnchor(String arg0, String arg1, String arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    private class SceneCreateAction extends WidgetAction.Adapter {

        public WidgetAction.State keyTyped(Widget widget, WidgetAction.WidgetKeyEvent e) {
            System.out.println(e + "KEY TYPED: ");
            return WidgetAction.State.CONSUMED;
        }

        @Override
        public WidgetAction.State mousePressed(Widget widget, WidgetAction.WidgetMouseEvent event) {
            // Fix this to work with scroll wheel
            // add popup menu  to right click
            if (event.getClickCount() == 1) {
                if (event.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("button 1");
                    // fix node name: prompt for node name when created
                    addNode("node" + nodeCounter++).setPreferredLocation(widget.convertLocalToScene(event.getPoint()));
                    return WidgetAction.State.CONSUMED;
                } else if (event.getButton() == MouseEvent.BUTTON2) {
                    //layout.invokeLayout();
                    System.out.println("button 2");
                    return WidgetAction.State.CONSUMED;
                } else if (event.getButton() == MouseEvent.BUTTON3) {
                    if (GlobalVars.getZoomFactor() >= 0) {
                        //zoomIn.invokeLayoutImmediately();
                        return WidgetAction.State.CONSUMED;
                    }
                    System.out.println("button 3");
                }
            }
            
            return WidgetAction.State.REJECTED;
        }
//        public State mouseWheel(Widget widget, WidgetMouseEvent event) {
//            System.out.println("MWE: "+MouseWheelEvent.MOUSE_WHEEL);
//             return State.REJECTED;
//        }
    }

    private class MyConnectProvider implements ConnectProvider {

        @Override
        public boolean isSourceWidget(Widget source) {
            return source instanceof IconNodeWidget && source != null ? true : false;
        }

        @Override
        public ConnectorState isTargetWidget(Widget src, Widget trg) {
            return src != trg && trg instanceof IconNodeWidget ? ConnectorState.ACCEPT : ConnectorState.REJECT;
        }

        @Override
        public boolean hasCustomTargetWidgetResolver(Scene arg0) {
            return false;
        }

        @Override
        public Widget resolveTargetWidget(Scene arg0, Point arg1) {
            return null;
        }

        @Override
        public void createConnection(Widget source, Widget target) {
            ConnectionWidget conn = new ConnectionWidget(GraphSceneImpl.this);
            conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
            conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
            conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
            connectionLayer.addChild(conn);
        }
    }
}