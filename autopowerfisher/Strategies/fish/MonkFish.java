package autopowerfisher.Strategies.fish;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;

import autopowerfisher.Data.Variables;

public class MonkFish implements Strategy {

	@Override
	public boolean activate() {
		return Variables.fishChosen == Variables.monkFish
				&& !Players.getLocal().isWalking()
				&& !Inventory.isFull()
				&& Players.getLocal().getAnimation() == -1;
	}

	@Override
	public void execute() {
		for (Npc monk : Npcs.getNearest(Variables.monkFish)) {
			if (monk.isOnScreen()) {
				Variables.status = "Fishing";
				monk.interact("Net");
				Variables.caught++;
				Variables.funny = "Baws";
				Time.sleep(1000, 2000);
			}
		}

	}

}
