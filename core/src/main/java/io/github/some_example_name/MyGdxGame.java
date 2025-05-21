package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.component.ImageView;
import io.github.some_example_name.screen.ChoiceScreen;
import io.github.some_example_name.screen.GameScreens.InfoScreen;
import io.github.some_example_name.screen.GameScreens.InfoScreen2;
import io.github.some_example_name.screen.MenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends Game {

    public World world;
    public SpriteBatch batch;
    private Texture image;
    public InfoScreen2 infoScreen2;
    public BitmapFont largeWhiteFont;
    public BitmapFont largeBlackFont;
    public BitmapFont commonWhiteFont;
    public BitmapFont commonBlackFont;
    public BitmapFont fontForText;
    public OrthographicCamera camera;
    public Vector3 touch;
    public MenuScreen menuScreen;
    public static InfoScreen infoScreen;
    public ImageView imageView;
    public ChoiceScreen choiceScreen;
    @Override
    public void create() {
        Box2D.init();
        world = new World(new Vector2(0, 0), true);

        largeWhiteFont = FontBuilder.generate(48, Color.WHITE, GameResources.FONT_PATH);
        largeBlackFont = FontBuilder.generate(40,Color.BLACK, GameResources.FONT_PATH);
        commonWhiteFont = FontBuilder.generate(24, Color.WHITE, GameResources.FONT_PATH);
        commonBlackFont = FontBuilder.generate(24, Color.BLACK, GameResources.FONT_PATH);
        fontForText = FontBuilder.generate(24, Color.WHITE, GameResources.FONT_PATH);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);


        infoScreen = new InfoScreen(this, GameResources.CARROCANE_BG,
            "The Caro-Kann Defense is a solid\n" +
                " and reliable chess opening that\n " +
                "arises after 1.e4 c6. It is known\n" +
                " for its strong pawn structure and\n " +
                "counterattacking potential, making\n" +
                "it a favorite among positional players.");
        infoScreen2 = new InfoScreen2(this, GameResources.CARROCANE_BG2,
            "say moooooore\n abut carrocan");
        menuScreen = new MenuScreen(this);
        choiceScreen = new ChoiceScreen(this);


        setScreen(menuScreen);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
