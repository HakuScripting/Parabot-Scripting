package autopowerfisher.Strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;

import autopowerfisher.Data.Variables;

public class Lobster implements Strategy {
	@Override
	public boolean activate() {
		return Variables.fishChosen == Variables.lob && !Players.getLocal().isWalking()
				&& Players.getLocal().getAnimation() == -1
				&& !Inventory.isFull();
	}

	@Override
	public void execute() {
		final Npc[] Lobster = Npcs.getNearest(Variables.fishChosen);
		if (Lobster[0].isOnScreen()) {
			Variables.status = "Fishing";
			Lobster[0].interact("Cage");
			Variables.caught++;
			Variables.funny = "Baws";
			Time.sleep(1000, 2000);
		}
	}
}
