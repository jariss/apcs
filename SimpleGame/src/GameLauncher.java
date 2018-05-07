import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
public class GameLauncher
{
    public static void main(String[] args)
    {
        DropGame  myProgram = new DropGame();

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//         config.width = 800;
//         config.height = 480;  

        LwjglApplication launcher = new LwjglApplication(myProgram, config);
    }
}