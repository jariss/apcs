//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputPollingSample implements ApplicationListener {
    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;
    private float fontX;
    public static final float WORLD_WIDTH = 1200.0F;
    public static final float WORLD_HEIGHT = 960.0F;

    public InputPollingSample() {
    }

    public void create() {
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(1200.0F, 960.0F, this.camera);
        this.batch = new SpriteBatch();
        this.font = new BitmapFont(Gdx.files.internal("oswald-32.fnt"));
        this.font.getData().markupEnabled = true;
        this.fontX = 60.0F;
    }

    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
    }

    public void render() {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        this.handleInput();
        this.draw();
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(21)) {
            this.fontX -= 10.0F;
        }

        if (Gdx.input.isKeyPressed(22)) {
            this.fontX += 10.0F;
        }

    }

    public void draw() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();
        this.font.draw(this.batch, "[BLUE]Screen x = " + mouseX + "[RED] Screen y = " + mouseY, 60.0F, 935.0F);
        Vector3 world = this.camera.unproject(new Vector3((float)mouseX, (float)mouseY, 0.0F));
        float worldX = world.x;
        float worldY = world.y;
        this.font.draw(this.batch, "World x = " + worldX + " World y = " + worldY, this.fontX, 900.0F);
        boolean isWPressed = Gdx.input.isKeyPressed(51);
        this.font.draw(this.batch, isWPressed ? "W is pressed" : "W is not pressed", 60.0F, 870.0F);
        boolean isWJustPressed = Gdx.input.isKeyJustPressed(51);
        this.font.draw(this.batch, isWJustPressed ? "W is just pressed" : "W is not just pressed", 60.0F, 840.0F);
        boolean leftClick = Gdx.input.isButtonPressed(0);
        boolean rightClick = Gdx.input.isButtonPressed(1);
        this.font.draw(this.batch, leftClick ? "Left clicked " : "Left not being clicked", 60.0F, 810.0F);
        this.font.draw(this.batch, rightClick ? "Right clicked " : "Right not being clicked", 60.0F, 780.0F);
        this.batch.end();
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
        this.batch.dispose();
    }
}
