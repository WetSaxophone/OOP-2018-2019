package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{
    boolean[] keys = new boolean[1024];

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>(); 

    AIShip aiShip;

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    
    public void settings()
    {
        size(500, 500);        
    }

    public void setup()
    {
        gameObjects.add(new Ship(this, width / 2, height / 2, 5, 50));
        aiShip = new AIShip(this, 100, 100, 5, 50);
        gameObjects.add(aiShip);
    }

    public float timeDelta;
    private float last;
    public void draw()
    {
        float now = millis();
        timeDelta = (now - last) / 1000.0f;
        last = now;
        background(255);
        
        fill(0);
        text("Bullets: " + bullets.size(), 50, 100);

        for(int i = bullets.size() - 1; i >= 0; i--)
        {
            GameObject b = gameObjects.get(i);
            b.render();
            b.update();
        }


        //for each
        // for(Bullet b:bullets)
        // {
        //     b.render();
        //     b.update();
        // }
    }


}