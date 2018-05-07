
/**
 * Write a description of class WorkFlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.badlogic.gdx.ApplicationListener; 
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxBuild;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Input;

public class GridClickerP1 implements ApplicationListener
{
    private OrthographicCamera camera; //camera
    private Viewport viewport; //help maintain aspect ratios
    private ShapeRenderer renderer;//like our pen
    private boolean draw;
    private int[][] grid;
    private Vector2 pos;


    public static float WORLD_WIDTH = 5f; //world units for height
    public static float WORLD_HEIGHT = 5f; //world units for width
    @Override
    public void create()
    {
        camera = new OrthographicCamera(); 
        renderer = new ShapeRenderer(); 
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);//match the ratio of the config to the launcher
        draw = true; 
        grid = new int[(int)WORLD_HEIGHT][(int)WORLD_WIDTH];
        pos = new Vector2(0,0);
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height, true);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1); //sets the background to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//wipes the screen

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            draw = !draw;
        }
        if (Gdx.input.justTouched()) {//checks for a click and release vs .isTouched(){
            int x = Gdx.input.getX();//get x screen coordinate
            int y = Gdx.input.getY();//gets y screen coordinate

            pos = viewport.unproject(new Vector2(x, y));//translate that to world coordinates

            //translate click coordinates to 2D array position
            int row = grid.length - 1 - (int) pos.y;
            int col = (int) pos.x;
            if (grid[row][col] == 1) {
                grid[row][col] = 0;
            } else if(grid[row][col] == 2) {
                grid[row][col] = 1;
            }
            else{
                grid[row][col] = 2;
            }
        }
            renderer.setProjectionMatrix(camera.combined);
            renderer.begin(ShapeRenderer.ShapeType.Filled);
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 2) {
                        renderer.setColor(Color.BLUE);
                        renderer.rect(col, grid.length - row - 1, 1, 1);
                    } else if(grid[row][col]  == 1){
                        renderer.setColor(Color.GREEN);
                        renderer.rect(col, grid.length - row - 1, 1, 1);
                    }else{
                        renderer.setColor(Color.BLACK);
                        renderer.rect(col, grid.length - row - 1, 1, 1);
                    }
                }
            }
        renderer.end();
        if(draw) {
            drawGrid();
        }
        drawShapes();
    }


    private void drawShapes()
    {
        renderer.setProjectionMatrix(camera.combined); 
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        renderer.rect(0, 0, 1, 1); 

        renderer.end(); 
    }

    private void drawGrid()
    {
        renderer.setProjectionMatrix(camera.combined);//telling our shaperenderer about our camera

        renderer.begin(ShapeRenderer.ShapeType.Line); 
        //start logic for drawing grid
        renderer.setColor(Color.WHITE);
        int width = (int)WORLD_WIDTH; 
        int height = (int)WORLD_HEIGHT; 

        //draw all vertical lines
        for(int i = -width; i <= width; i++)
        {

            renderer.line(i, height, i, -height); 
        }
        //horizontal lines
        for(int i = -height; i <= height; i++)
        {
            renderer.line(width, i, -width, i); 
        }

        renderer.setColor(Color.RED); 
        renderer.line(-width, 0, width, 0); 
        renderer.line(0, height, 0, -height); 

        renderer.end();

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {
        renderer.dispose();  
    }
}
