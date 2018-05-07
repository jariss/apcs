import com.badlogic.gdx.Game;

public class DropGame extends Game {
    public void create(){
        this.setScreen(new MainMenuScreen(this));
        //passing in this Game(DropGame is a Game)
    }




}