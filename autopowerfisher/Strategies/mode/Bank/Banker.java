package autopowerfisher.Strategies.mode.Bank;

import java.awt.Point;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Bank;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;

import autopowerfisher.Data.Variables;

public class Banker implements Strategy {

	@Override
	public boolean activate() {
		return Variables.bankMode == true
				&& Variables.BANKAREA
						.contains(Players.getLocal().getLocation())
				&& Inventory.isFull() && !Players.getLocal().isWalking()
				&& !Players.getLocal().isInCombat();
	}

	@Override
	public void execute() {
		for(SceneObject banks : SceneObjects.getNearest(2213)) {
		if (!Bank.isOpen()) {
			Variables.status = "Banking";
			banks.interact("Use-quickly");
			Time.sleep(400);
		} else {
			if (Bank.isOpen());
			Variables.status = "Depositing";
			Bank.depositAllExcept(Variables.eqipmentID);
			Time.sleep(500, 1000);
            Point p = new Point(489, 25);
            Variables.status = "Closing bank";
            Mouse.getInstance().click(p);
            Time.sleep(1000);
		}
	}
	}
}