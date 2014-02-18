package autopowerfisher.Strategies.mode.Drop;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.hud.Item;

import autopowerfisher.Data.Variables;

public class PowerDrop implements Strategy {

		@Override
		public boolean activate() {
			return Variables.powerMode == true
					&& Inventory.isFull() && !Players.getLocal().isWalking()
					&& Players.getLocal().getAnimation() == -1;
		}

		@Override
		public void execute() {
			for (Item i : Inventory.getItems(Variables.inventoryFish)) {
				Variables.status = "Dropping Inv";
				i.interact("Drop");
				++Variables.dropped;
				Variables.funny = "God";
				Time.sleep(200);
			}
		}
	}