package io.github.some_example_name.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.GameSettings;
import io.github.some_example_name.MemoryManager;
import io.github.some_example_name.MyGdxGame;
import io.github.some_example_name.component.ButtonView;
import io.github.some_example_name.component.MovingBackgroundView;
import io.github.some_example_name.component.TextView;
import io.github.some_example_name.screen.GameScreens.InfoScreen;

public class SettingsScreen extends ScreenAdapter {
    ButtonView nextButtonView;
    MyGdxGame myGdxGame;
    TextView musicSettingView;
    MovingBackgroundView backgroundView;
    TextView titleView;

    public SettingsScreen(MyGdxGame myGdxGame) {
        nextButtonView = new ButtonView(920, 0,
            GameSettings.NEXT_BUTTON_WIDTH, GameSettings.NEXT_BUTTON_HEIGHT,
            myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH,
            "return");
        this.myGdxGame = myGdxGame;
        backgroundView = new MovingBackgroundView(GameResources.BACKGROUND_IMG_PATH);
        titleView = new TextView(myGdxGame.largeWhiteFont, 450, 960, "Settings");
        musicSettingView = new TextView(
            myGdxGame.commonWhiteFont,
            173, 717,
            "music: " + translateStateToText(MemoryManager.loadIsMusicOn())
        );


    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (musicSettingView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                MemoryManager.saveMusicSettings(!MemoryManager.loadIsMusicOn());
                musicSettingView.setText("music: " + translateStateToText(MemoryManager.loadIsMusicOn()));
                myGdxGame.audioManager.updateMusicFlag();
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
        musicSettingView.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }
    private String translateStateToText(boolean state) {
        return state ? "ON" : "OFF";
    }
}
