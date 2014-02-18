package autopowerfisher.Strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;

import autopowerfisher.Data.Variables;

public class OldMan implements Strategy {

	@Override
	public boolean activate() {
		for (Npc npa : Npcs.getNearest(410)) {
			if (npa != null
					&& npa.isOnScreen()
					&& !Players.getLocal().isInCombat()
					&& (Players.getLocal().getAnimation() == -1
					|| Players.getLocal().getAnimation() == 1353 || Players
					.getLocal().getAnimation() == 791)
					&& !Inventory.isFull()) {
				Variables.npc32 = npa;
				return true;
			}
		}
		return false;

	}

	@Override
	public void execute() {
		Variables.npc32.interact("Talk-to");
		Time.sleep(8000);

	}

}