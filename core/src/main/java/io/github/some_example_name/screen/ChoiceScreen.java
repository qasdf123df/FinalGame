package io.github.some_example_name.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.GameSettings;
import io.github.some_example_name.MyGdxGame;
import io.github.some_example_name.component.ButtonView;
import io.github.some_example_name.component.MovingBackgroundView;
import io.github.some_example_name.component.TextView;
import io.github.some_example_name.screen.GameScreens.InfoScreen;

public class ChoiceScreen extends ScreenAdapter {
    ButtonView carrocanDebut;
    ButtonView nextButtonView;
    ButtonView socialistParty;
    ButtonView kingsGambit;
    ButtonView settingsButtonView;
    MyGdxGame myGdxGame;
    InfoScreen infoScreen;
    public String[] nameOfButtons = {"CARRO-CAN DEBUT", "Socilian party", "King's Gambit"};
    int n;


    MovingBackgroundView backgroundView;
    TextView titleView;
    ButtonView exitButtonView;

    public ChoiceScreen(MyGdxGame myGdxGame) {
        nextButtonView = new ButtonView(920, 0,
            GameSettings.NEXT_BUTTON_WIDTH, GameSettings.NEXT_BUTTON_HEIGHT,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            "back");
        this.myGdxGame = myGdxGame;
        backgroundView = new MovingBackgroundView(GameResources.BACKGROUND_IMG_PATH);
        titleView = new TextView(myGdxGame.largeWhiteFont, 385, 960, "Choise Game");
        n = 0;
        carrocanDebut = new ButtonView(300, 646,
            GameSettings.CHOICE_BUTTON_WIDTH, GameSettings.CHOISE_BUTTON_HEIGHT,
            myGdxGame.largeBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            "Karakan debut");

        n = 1;
        socialistParty = new ButtonView(300, 646 - GameSettings.CHOISE_BUTTON_HEIGHT * n - GameSettings.BUTTON_SPACE * n,
            GameSettings.CHOICE_BUTTON_WIDTH, GameSettings.CHOISE_BUTTON_HEIGHT,
            myGdxGame.largeBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            nameOfButtons[1]);
        n = 2;
        kingsGambit = new ButtonView(300, 646 - GameSettings.CHOISE_BUTTON_HEIGHT * n - GameSettings.BUTTON_SPACE * n,
            GameSettings.CHOICE_BUTTON_WIDTH, GameSettings.CHOISE_BUTTON_HEIGHT,
            myGdxGame.largeBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            nameOfButtons[2]);

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (carrocanDebut.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(MyGdxGame.infoScreen);
                // we have total problem, i need 1 shans for die...
            }
            if (socialistParty.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
            if (kingsGambit.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
            if (nextButtonView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
        }
    }

    public void render(float delta) {

        handleInput();

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        backgroundView.draw(myGdxGame.batch);
        titleView.draw(myGdxGame.batch);
        nextButtonView.draw(myGdxGame.batch);
        carrocanDebut.draw(myGdxGame.batch);
        socialistParty.draw(myGdxGame.batch);
        kingsGambit.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }
}
