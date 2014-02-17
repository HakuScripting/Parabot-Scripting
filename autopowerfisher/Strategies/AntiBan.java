package autopowerfisher.Strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;

import autopowerfisher.Data.Variables;

public class AntiBan implements Strategy {

	@Override
	public boolean activate() {
		return Variables.antiBan == true;
	}

	@Override
	public void execute() {
		switch (Variables.randomNumber) {
		case 1:
		case 9:
		case 12:
			Variables.status = "Camera";
			Camera.setPitch(true);
			Time.sleep(200, 300);
			break;
		case 13:
		case 15:
		case 19:
			Variables.status = "Random sleep(100, 50";
			Time.sleep(100, 50);
			break;
		case 20:
		case 25:
		case 30:
			Variables.status = "Random sleep(100, 3000";
			Time.sleep(100, 3000);
			break;
		case 34:
		case 36:
		case 40:
			Variables.status = "Random Sleep(250, 1000)";
			Time.sleep(250, 1000);
			break;
		case 45:
		case 48:
		case 50:
			Time.sleep(200, 500);
			break;
		}
	}
}
