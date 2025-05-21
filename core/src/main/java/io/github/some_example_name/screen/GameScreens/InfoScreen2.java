package io.github.some_example_name.screen.GameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.GameSettings;
import io.github.some_example_name.MyGdxGame;
import io.github.some_example_name.component.ButtonView;
import io.github.some_example_name.component.ImageView;
import io.github.some_example_name.component.MovingBackgroundView;
import io.github.some_example_name.component.TextView;

public class InfoScreen2 extends ScreenAdapter {

    MyGdxGame myGdxGame;

    MovingBackgroundView backgroundView;

    ImageView screenInfo;

    ButtonView exitButtonView;
    ButtonView nextButtonView;

    TextView textView;

    public InfoScreen2(MyGdxGame myGdxGame, String skin, String text) {
        this.myGdxGame = myGdxGame;

        backgroundView = new MovingBackgroundView(skin);

        exitButtonView = new ButtonView(920, 1000,
            GameSettings.NEXT_BUTTON_WIDTH, GameSettings.NEXT_BUTTON_HEIGHT,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            "exit");
        screenInfo = new ImageView(0, 0, 0, 0, GameResources.CARROCANE_BG);
        nextButtonView = new ButtonView(920, 0,
            GameSettings.NEXT_BUTTON_WIDTH, GameSettings.NEXT_BUTTON_HEIGHT,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            "next step");
        textView = new TextView(myGdxGame.largeWhiteFont, 650, 700, text);

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (exitButtonView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.choiceScreen);
            }
            if (nextButtonView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.choiceScreen);
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
        screenInfo.draw(myGdxGame.batch);
        textView.draw(myGdxGame.batch);
        backgroundView.draw(myGdxGame.batch);
        exitButtonView.draw(myGdxGame.batch);
        nextButtonView.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }
}
