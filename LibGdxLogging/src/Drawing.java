//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Drawing implements ApplicationListener {
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;
    public static final float WORLD_WIDTH = 14.4F;
    public static final float WORLD_HEIGHT = 9.0F;
    private boolean draw;

    public Drawing() {
    }

    public void create() {
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(14.4F, 9.0F, this.camera);
        this.renderer = new ShapeRenderer();
        this.draw = true;
    }

    public void resize(int width, int height) {
        this.viewport.update(width, height);
    }

    public void render() {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        if (Gdx.input.isKeyJustPressed(62)) {
            this.draw = !this.draw;
        }

        if (this.draw) {
            this.drawGrid();
        }

        this.drawShapesNotFilled();
        this.drawShapesFilled();
    }

    private void drawGrid() {
        this.renderer.setProjectionMatrix(this.camera.combined);
        this.renderer.begin(ShapeType.Line);
        this.renderer.setColor(Color.WHITE);
        int width = 14;
        int height = 9;

        int i;
        for(i = -width; i < width; ++i) {
            this.renderer.line((float)i, (float)height, (float)i, (float)(-height));
        }

        for(i = -height; i < height; ++i) {
            this.renderer.line((float)width, (float)i, (float)(-width), (float)i);
        }

        this.renderer.setColor(Color.RED);
        this.renderer.line((float)(-width), 0.0F, (float)width, 0.0F);
        this.renderer.line(0.0F, (float)(-height), 0.0F, (float)height);
        this.renderer.end();
    }

    private void drawShapesNotFilled() {
        this.renderer.setProjectionMatrix(this.camera.combined);
        this.renderer.begin(ShapeType.Line);
        this.renderer.setColor(Color.GREEN);
        this.renderer.rect(0.0F, 0.0F, 4.0F, 4.0F);
        this.renderer.setColor(Color.ORANGE);
        this.renderer.rect(-4.0F, 0.0F, 4.0F, 4.0F);
        this.renderer.setColor(Color.PINK);
        this.renderer.rect(-4.0F, -4.0F, 4.0F, 4.0F);
        this.renderer.setColor(Color.YELLOW);
        this.renderer.rect(0.0F, -4.0F, 4.0F, 4.0F);
        this.renderer.end();
    }

    private void drawShapesFilled() {
        this.renderer.setProjectionMatrix(this.camera.combined);
        this.renderer.begin(ShapeType.Filled);
        this.renderer.setColor(Color.TEAL);
        this.renderer.circle(0.0F, 0.0F, 2.0F, 50);
        this.renderer.setColor(Color.GREEN);
        this.renderer.triangle(0.0F, 0.0F, 2.0F, 3.0F, 3.0F, 2.0F);
        this.renderer.triangle(4.0F, 4.0F, 2.0F, 3.0F, 3.0F, 2.0F);
        this.renderer.setColor(Color.ORANGE);
        this.renderer.triangle(0.0F, 0.0F, -2.0F, 3.0F, -3.0F, 2.0F);
        this.renderer.triangle(-4.0F, 4.0F, -2.0F, 3.0F, -3.0F, 2.0F);
        this.renderer.setColor(Color.YELLOW);
        this.renderer.triangle(0.0F, 0.0F, 2.0F, -3.0F, 3.0F, -2.0F);
        this.renderer.triangle(4.0F, -4.0F, 2.0F, -3.0F, 3.0F, -2.0F);
        this.renderer.setColor(Color.PINK);
        this.renderer.triangle(0.0F, 0.0F, -2.0F, -3.0F, -3.0F, -2.0F);
        this.renderer.triangle(-4.0F, -4.0F, -2.0F, -3.0F, -3.0F, -2.0F);
        this.renderer.end();
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
        this.renderer.dispose();
    }
}
