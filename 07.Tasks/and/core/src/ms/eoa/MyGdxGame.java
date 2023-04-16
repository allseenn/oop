package ms.eoa;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, cross, monk, peasant, spear, mageB , peasantB, sniperB, thiefB;
	Music music;
	Game game;
	@Override
	public void create () {
		game = new Game();
		game.create();
		batch = new SpriteBatch();
		int fileName = new Random().nextInt(1, 5);
		fon = new Texture("backgrounds/"+fileName+".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("musics/m"+fileName+".mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();

		cross = new Texture("units/Cross.png");
		monk = new Texture("units/Monk.png");
		peasant = new Texture("units/Peasant.png");
		spear = new Texture("units/Spear.png");
		mageB = new Texture("units/MageB.png");
		peasantB = new Texture("units/PeasantB.png");
		sniperB = new Texture("units/SniperB.png");
		thiefB = new Texture("units/ThiefB.png");
	}

	@Override
	public void render () {
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
					game.turn();
					Gdx.graphics.setTitle(game.score());
		}

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (int i=Game.units.size()-1; i>=0; i--){
			batch.setColor(1, 1, 1, 1);
			if(Game.units.get(i).getHp()<=0) batch.setColor(Color.RED);
			int x = Game.units.get(i).getX() * Gdx.graphics.getWidth()/10;
			int y = Game.units.get(i).getY() * Gdx.graphics.getHeight()/12;
			switch (Game.units.get(i).getRank()){
				case "Снайпер":
					batch.draw(sniperB, x, y);
					break;
				case "Стрелок":
					batch.draw(cross, x, y);
					break;
				case "Мясник":
					batch.draw(thiefB, x, y);
					break;
				case "Копейщик":
					batch.draw(spear, x, y);
					break;
				case "Шестерка":
					batch.draw(peasantB, x, y);
					break;
				case "Эсквайр":
					batch.draw(peasant, x, y);
					break;
				case "Колдун":
					batch.draw(mageB, x, y);
					break;
				case "Маг":
					batch.draw(monk, x, y);
					break;
			}


		}
		batch.setColor(1, 1, 1, 1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}
