package customer.util;

import javafx.scene.control.TextField;

public class MaskedTextBox extends TextField {
	
	public MaskedTextBox() {
	}
	
	
	private boolean isValid(String text){
		return("".equals(text) || text.matches("[0-9]"));
	}
	

	@Override
	public void replaceSelection(String text){
		if(isValid(text)){
			super.replaceSelection(text);
		}
	}
	@Override
	public void replaceText(int start, int end, String text){
		if(isValid(text)){
			super.replaceText(start, end, text);
		}
	}

}
