import javafx.scene.control.Button;

public class Kono_Button extends Button {
static Boolean isFrozen;  // If true, every button should be frozen, hence static
Integer buttonValue;      // every button will have a different value 1-80

Kono_Button(String value){
	super(value);
	this.buttonValue = Integer.parseInt(value);
}


Integer getbuttonValue() {
	return buttonValue;
}

void setbuttonValue(Integer value) {
	 buttonValue = value;
}

Boolean getFrozen(){
	return isFrozen;
}

static void setFrozen(boolean state) {
	isFrozen = state;
}



}
