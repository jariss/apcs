

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    private ShapeRenderer renderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private Viewport viewport;

    private Texture dropImage;
    private Texture bucketImage;

    private Sound dropSound;
    private Music rainMusic;

    private  Rectangle bucket;
    private Array<Rectangle> raindrops;
    private  float time;
    private int dropsGathered;


    private Vector2 velocity;

    public static float WORLD_WIDTH = 800; //world units for height
    public static float WORLD_HEIGHT = 480;
    public static float RAINDROP_WIDTH = 64;
    public static float RAINDROP_HEIGHT = 64;
    public static float BUCKET_WIDTH = 64;
    public static float BUCKET_HEIGHT = 64;
    public static float FLOOR = 20f;
    public static float RAIN_SPEED = 3f;
    public static float BUCKET_SPEED = 3f;
    public static float SPAWN_SPEED = .2f;
    public final float GRAVITY = WORLD_HEIGHT / 100f;
    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("assets/capsmall40.fnt"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        // load the images for the droplet and the bucket, 64x64 pixels each
        dropImage = new Texture(Gdx.files.internal("assets/droplet.png"));
        bucketImage = new Texture(Gdx.files.internal("assets/bucket.png"));

        // load the drop sound effect and the rain background "music"
        dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/rain.mp3"));
        rainMusic.setLooping(true);
        rainMusic.play();

        // create a Rectangle to logically represent the bucket
        bucket = new Rectangle();
        bucket.x = WORLD_WIDTH / 2 - BUCKET_WIDTH / 2; // center the bucket horizontally
        bucket.y = WORLD_HEIGHT - (WORLD_HEIGHT / 2f);//it is going to fall into the game
        bucket.width = BUCKET_WIDTH;
        bucket.height = BUCKET_HEIGHT;

        // create the raindrops array and spawn the first raindrop
        raindrops = new Array<Rectangle>();
        spawnRaindrop();



        velocity = new Vector2();

    }

    @Override
    public void render(float delta) {
        // tell the camera to update its matrices.
        viewport.apply();
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateBucket(delta);
        updateRain(delta);
        updateCamera(delta);

        //render raindrops
        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        batch.begin();
        renderRain();
        renderText();
        renderBucket();

        batch.end();
    }

    private void renderBucket()
    {
        batch.draw(bucketImage, bucket.x, bucket.y, BUCKET_WIDTH, BUCKET_HEIGHT);
    }

    private void renderText()
    {

        GlyphLayout layout = new GlyphLayout(font, "Drops Collected: " + dropsGathered);

        font.draw(batch, "Drops Collected: " + dropsGathered,
                WORLD_WIDTH / 2 - layout.width / 2,
                WORLD_HEIGHT/2 + layout.height / 2);
    }

    private void renderRain()
    {
        for (Rectangle raindrop : raindrops) {
            batch.draw(dropImage, raindrop.x, raindrop.y, RAINDROP_WIDTH, RAINDROP_HEIGHT);
        }
    }

    private void updateBucket(float delta)
    {
        //update the bucket's position with gravity, stop when it get to the floor
        if(bucket.y > FLOOR)
        {
            velocity.y  -= GRAVITY * delta;
            Vector2 current = bucket.getPosition(new Vector2(bucket.x, bucket.y));
            Vector2 newPos = current.add(velocity);
            bucket.setPosition(newPos);
        }

        if (Gdx.input.isTouched()) {
            Vector2 touchPos = viewport.unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
            bucket.x = touchPos.x - BUCKET_WIDTH / 2;
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT))
        {
            bucket.x -= BUCKET_SPEED;
            //             if (bucket.x < camera.position.x - 400)
            //                 camera.position.x -= 200 * delta; 

        }
        else if (Gdx.input.isKeyPressed(Keys.RIGHT))
        {
            bucket.x += BUCKET_SPEED;
            //             if (bucket.x > camera.position.x + 400 - 64)//account for the width of the bucket
            //                 camera.position.x += 200 * delta; 
        }

    }

    private void updateRain(float delta)
    {
        time += delta;
        for(int i = 0; i < raindrops.size; i++)
        {

            Rectangle raindrop = raindrops.get(i);
            raindrop.y -= RAIN_SPEED;

            if (raindrop.overlaps(bucket)) {
                dropsGathered++;
                dropSound.play();
                raindrops.removeIndex(i);
                i--;
            }
            if (raindrop.y + RAINDROP_HEIGHT < 0)
                raindrops.removeIndex(i);

            if (time > SPAWN_SPEED)
                spawnRaindrop();

        }

    }

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();

        raindrop.x = MathUtils.random(0, WORLD_WIDTH - RAINDROP_WIDTH);
        raindrop.y = WORLD_HEIGHT;

        raindrop.width = RAINDROP_WIDTH;
        raindrop.height = RAINDROP_HEIGHT;

        raindrops.add(raindrop);
        //record the time a raindrop last spawned
        time = 0;
    }

    private void updateCamera(float delta)
    {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            camera.position.x -= 200 * delta;
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
        dropImage.dispose();
        bucketImage.dispose();
        dropSound.dispose();
        rainMusic.dispose();
    }

}