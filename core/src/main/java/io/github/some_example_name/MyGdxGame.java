package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

import io.github.some_example_name.component.ImageView;
import io.github.some_example_name.screen.ChoiceScreen;
import io.github.some_example_name.screen.GameScreens.InfoForSocilian;
import io.github.some_example_name.screen.GameScreens.InfoForSocilian2;
import io.github.some_example_name.screen.GameScreens.InfoScreen;
import io.github.some_example_name.screen.GameScreens.InfoScreen2;
import io.github.some_example_name.screen.MenuScreen;
import io.github.some_example_name.screen.SettingsScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends Game {

    public World world;
    public SpriteBatch batch;
    private Texture image;
    public InfoForSocilian infoForSocilian;
    public InfoForSocilian2 infoForSocilian2;
    public InfoScreen2 infoScreen2;
    public BitmapFont largeWhiteFont;
    public BitmapFont largeBlackFont;
    public BitmapFont commonWhiteFont;
    public BitmapFont commonBlackFont;
    public BitmapFont fontForText;
    public OrthographicCamera camera;
    public Vector3 touch;
    public MenuScreen menuScreen;
    public AudioManager audioManager;
    public static InfoScreen infoScreen;
    public SettingsScreen settingsScreen;
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
            "After 1.e4 c6, White’s most common\n" +
                "second move is 2.d4, fighting for the\n" +
                "center and leading to main lines after\n" +
                " 2...d5. Alternatives like 2.Nc3, 2.Nf3,\n" +
                "or 2.d3 offer flexible setups, often\n" +
                " transposing into other systems.\n" +
                "The Caro-Kann remains solid, giving\n" +
                "Black a reliable pawn structure after\n" +
                " 2.d4 d5.");
        infoForSocilian = new InfoForSocilian(this, GameResources.SOCILIAN_BG,
            "Social defense is a nonviolent\n" +
                "strategy to protect society from \n" +
                "oppression, using methods like \n" +
                "civil disobedience and grassroots\n" +
                "organizing. It focuses on building\n " +
                "resilient communities that can \n " +
                "resist authoritarianism without \n" +
                "relying on state violence.\n" +
                "The approach emphasizes \n" +
                "education, solidarity, and\n" +
                "decentralized action to \n" +
                "undermine oppressive systems.");
        infoForSocilian2 = new InfoForSocilian2(this, GameResources.SOCILIAN_BG2,
            "In the Social Defense \n" +
                "opening, the move \n" +
                "2. Kf3–Kc6 disrupts traditional\n" +
                "pawn structures, aiming to\n" +
                "control the center nonviolently\n" +
                "through piece activity. It\n" +
                "reflects the strategy of\n" +
                "flexible resistance, avoiding\n" +
                "direct clashes while limiting\n" +
                "the opponent's oppressive advances.\n" +
                "This move symbolizes decentralized\n" +
                "action, prioritizing long-term\n" +
                "positional pressure over\n" +
                "immediate material gains.");
        menuScreen = new MenuScreen(this);
        settingsScreen = new SettingsScreen(this);

        choiceScreen = new ChoiceScreen(this);


        setScreen(menuScreen);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
