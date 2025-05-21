package io.github.some_example_name.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.MyGdxGame;
import io.github.some_example_name.component.ButtonView;
import io.github.some_example_name.component.MovingBackgroundView;
import io.github.some_example_name.component.TextView;

public class MenuScreen extends ScreenAdapter{
    ButtonView startButtonView;
    ButtonView settingsButtonView;
    MyGdxGame myGdxGame;
    ChoiceScreen choiceScreen;
    MovingBackgroundView backgroundView;
    TextView titleView;
    ButtonView exitButtonView;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        backgroundView = new MovingBackgroundView(GameResources.BACKGROUND_IMG_PATH);
        titleView = new TextView(myGdxGame.largeWhiteFont, 300, 960, "Chess training guide");
        startButtonView = new ButtonView(330, 646, 440, 70,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH, "go to choice");
        settingsButtonView = new ButtonView(330, 551, 440, 70,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH, "settings");
        exitButtonView = new ButtonView(330, 456, 440, 70,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH, "exit");
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (startButtonView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.choiceScreen);
            }
            if (exitButtonView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                Gdx.app.exit();
            }
            if (settingsButtonView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.settingsScreen);
            }
        }
    }

    @Override
    public void render(float delta) {

        handleInput();

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        backgroundView.draw(myGdxGame.batch);
        titleView.draw(myGdxGame.batch);
        exitButtonView.draw(myGdxGame.batch);
        settingsButtonView.draw(myGdxGame.batch);
        startButtonView.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }
}
