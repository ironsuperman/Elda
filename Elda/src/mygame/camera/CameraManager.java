/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.camera;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.ChaseCamera;
import mygame.player.Player;
import mygame.player.PlayerManager;

/**
 *
 * @author Bob
 */
public class CameraManager extends AbstractAppState {

  private SimpleApplication app;
  private AppStateManager   stateManager;
  private AssetManager      assetManager;
  public  ChaseCamera       cam;
  private Player            player;
  
  @Override
  public void initialize(AppStateManager stateManager, Application app){
    super.initialize(stateManager, app);
    this.app          = (SimpleApplication) app;
    this.stateManager = this.app.getStateManager();
    this.assetManager = this.app.getAssetManager();
    player            = this.stateManager.getState(PlayerManager.class).player;
    initCamera();
    }
  
  //Creates camera
  public void initCamera(){
    //Creates a new chase cam and attached it to the player.model for the game
    cam = new ChaseCamera(this.app.getCamera(), player, this.app.getInputManager());
    cam.setMinDistance(0.5f);
    cam.setMaxDistance(5);
    cam.setDefaultDistance(3);
    cam.setDragToRotate(false);
    cam.setRotationSpeed(5f);
    cam.setLookAtOffset(player.getLocalTranslation().add(0, 1.2f, 0));
    cam.setDefaultVerticalRotation(.145f);
    cam.setMaxVerticalRotation(.145f);
    cam.setMinVerticalRotation(.145f);
    }
  
  }
