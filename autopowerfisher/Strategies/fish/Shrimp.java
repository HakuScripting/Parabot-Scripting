package autopowerfisher.Strategies.fish;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;

import autopowerfisher.Data.Variables;

public class Shrimp implements Strategy {
	@Override
	public boolean activate() {
		return Variables.fishChosen == Variables.shrimp 
				&& !Players.getLocal().isWalking()
				&& !Inventory.isFull()
				&& Players.getLocal().getAnimation() == -1;
		
	}

	@Override
	public void execute() {
		for(Npc shrimp : Npcs.getNearest(Variables.shrimp)) {
		if (shrimp.isOnScreen()) {
			Variables.status = "Fishing";
			shrimp.interact("Net");
			Variables.caught++;
			Variables.funny = "Baws";
			Time.sleep(1000, 2000);
		}
		}

	}
}