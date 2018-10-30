package resources;

import methods.crossover.com.gmail.SharedMethod;
import methods.crossover.com.gmail.rightClick;

public interface DesignInterface {

	public default SharedMethod logMeIn(String username, String password) {
		return null;
	}

	public default SharedMethod composeEmail(String emailto) {
		return null;

	}

	public default void logMeOut() {

	}

	public default SharedMethod searchForEmail() {
		return null;

	}

	public default void emailContent() {

	}

	public default void mouseHover() {

	}

	public default void searchForEmailInGrid() {
	}

	public default void openEmail() {
	}
	
	public default rightClick EmailRightClick() {
		return null;
	}


	public default void DeleteEmail() {
	}
	public default void ArchiveEmail() {
	}

	public default void MakeEmailAsRead() {
	}
	public default void MakeEmailAsUnRead() {
	}

}
