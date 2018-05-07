import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    private ShapeRenderer renderer;
    private OrthographicCamera camera;
    private Viewport viewport;
    private BitmapFont font;
    private SpriteBatch batch;

    //please use constants
    public static float WORLD_WIDTH = 800f;
    public static float WORLD_HEIGHT = 480f;


    private DropGame game;
    //passed in my Game object so I can call setScreen to my GameScreen when I am ready to
    //start playing
    public MainMenuScreen(DropGame game)
    {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("assets/capsmall40.fnt"));
    }

    @Override
    public void render(float delta) {//delta is 1/60
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);//set background to darkblue
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);//tell batch about our camera
        batch.begin();

        font.draw(batch, "Welcome to Drop!", 100, 150);
        font.draw(batch, "Click anywhere to begin", 100, 100);

        batch.end();
        if(Gdx.input.justTouched()){
            game.setScreen(new GameScreen());
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);//origin to be bottom left
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}