/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.GameEntities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import main.Game;
import main.GameObject;
import main.Handler;
import main.ID;

/**
 *
 * @author Gianni
 */
public class EnemyTruck extends GameObject{

    Handler handler;
    Game game;
    
    private int index = 0 ;  
    Random r;
    
    public EnemyTruck(int x, int y, ID id ,Handler handler, Game game) {
        super(x, y, id);
        this.handler = handler;
        this.game = game;
    }

    @Override
    public void tick() {
        y += velY + ((velY > 0) ? game.getVelB() : -game.getVelB());
        
        if(y > game.HEIGHT + 20){
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(game.loader.getTruckImage(index), game.r.rx(x), game.r.ry(y),game.r.rx(64), game.r.ry(300),null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,64,600);
    }
    
    public void setImage(int i){
        index = i;
    }
    
    
    
}
