package remotecontrol;

/**
 *  Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {

		public final static int NO_OF_ACTION_BUTTONS = 3;

		private boolean[] buttonStatus;
		// TODO: Data structures for the actions

		public RemoteControl() {
			buttonStatus = new boolean[NO_OF_ACTION_BUTTONS];

			// TODO: Initialize data structures for the actions
		}

		// TODO: Implement method for configuration of action buttons

		/**
		 * The action button was pressed.
		 * Depending on its status, it will execute an activate or deactivate action.
		 *
		 * @param no The number of the button.
		 */
		public void actionButtonPressed(int no) {
			// Execute action
			if (buttonStatus[no] == false) {
				System.out.println("Button activated: " + no);
				// TODO: Execute activation action
				// TODO: Configure undo (deactivation) action
			} else {
				System.out.println("Button deactivated: " + no);
				// TODO: Execute deactivation action
				// TODO: Configure undo (activation) action
			}
			// Invert button status
			buttonStatus[no] = !buttonStatus[no];
		}

		/**
		 * The undo button was pressed.
		 * It will undo the previous action.
		 */
		public void undoButtonPressed() {
			// Execute undo action
			System.out.println("Undo button pressed");
			// TODO: Execute undo action
		}
}
