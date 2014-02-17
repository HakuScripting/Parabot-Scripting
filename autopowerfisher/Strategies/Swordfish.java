package autopowerfisher.Strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;

import autopowerfisher.Data.Variables;

public class Swordfish implements Strategy {
	@Override
	public boolean activate() {
		return Variables.fishChosen == Variables.swordFish && !Players.getLocal().isWalking()
				&& Players.getLocal().getAnimation() == -1
				&& !Inventory.isFull();
	}

	@Override
	public void execute() {
		final Npc[] sword = Npcs.getNearest(Variables.fishChosen);
		if (sword[0].isOnScreen()) {
			Variables.status = "Fishing";
			sword[0].interact("Harpoon");
			Variables.caught++;
			Variables.funny = "Baws";
			Time.sleep(1000, 2000);
		}
	}
}
