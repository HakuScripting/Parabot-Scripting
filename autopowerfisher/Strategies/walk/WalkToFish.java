package autopowerfisher.Strategies.walk;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.Walking;
import org.rev317.api.wrappers.walking.TilePath;

import autopowerfisher.Data.Variables;

public class WalkToFish implements Strategy {

	@Override
	public boolean activate() {
		return Variables.bankMode == true
				&& !Inventory.isFull()
				&& Players.getLocal().getAnimation() == -1;
		}

		@Override
		public void execute() {
			TilePath path = new TilePath(Variables.PATH_TO_FISH);
			if (!path.hasReached() && Walking.readyForNextTile()) {
				path.traverse();
				Time.sleep(1000, 3000);

			}
		}
	}