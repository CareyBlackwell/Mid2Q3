package customer.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import customer.model.Customer;
import customer.util.MaskedTextBox;

public class CustomerController {
	@FXML
	private TextField FirstNameField;
	@FXML
	private TextField MiddleInitField;
	@FXML
	private TextField LastNameField;
	@FXML
	private RadioButton MaleButton;
	@FXML
	private RadioButton FemaleButton;
	@FXML
	private TextField AddressField;
	@FXML
	private TextField CityField;
	@FXML
	private ComboBox<String> StateBox;
	@FXML
	private MaskedTextBox ZipField;
	@FXML
	private Button SaveButton;
	@FXML
	private Button ClearButton;
	@FXML
	private Label errorLabel;
	
	
	private Stage infoStage;
	private Customer customer;
	private boolean saveClicked= false;
	private boolean clearClicked=false;
	ObservableList<String> stateList = FXCollections.observableArrayList(
			"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
			"Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
			"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
			"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", 
			"Washington", "West Virginia", "Wisconsin", "Wyoming"
			);
	@FXML
    private void initialize() {
		StateBox.setItems(stateList);
    }
	
	public void setInfoStage(Stage infoStage){
		this.infoStage=infoStage;
	}

	public void setCustomer(Customer customer){
		this.customer=customer;
		
		FirstNameField.setText(customer.getFirstName());
		MiddleInitField.setText(customer.getMiddleInit());
		LastNameField.setText(customer.getLastName());
		if(customer.getGender()=="Male"){
			MaleButton.setSelected(true);
		}else{
			MaleButton.setSelected(false);
		}
		if(customer.getGender()=="Female"){
			FemaleButton.setSelected(true);
		}else{
			FemaleButton.setSelected(false);
		}
		AddressField.setText(customer.getAddress());
		StateBox.setValue(customer.getState());
		CityField.setText(customer.getCity());
		ZipField.setText(customer.getZip());	
	}
	
	@FXML
    private void handleSave(){
		if(isInputValid()){
			customer.setFirstName(FirstNameField.getText());
			customer.setMiddleInit(MiddleInitField.getText());
			customer.setLastName(LastNameField.getText());
			if(MaleButton.isSelected()){
				customer.setGender("Male");
			}else{
				customer.setGender("Female");
			}
			customer.setAddress(AddressField.getText());
			customer.setCity(CityField.getText());
			customer.setState(StateBox.getValue());
			customer.setZip(ZipField.getText());
		}
	}
	
	@FXML
	private void handleClear(){
		FirstNameField.clear();
		MiddleInitField.clear();
		LastNameField.clear();
		MaleButton.setSelected(false);
		FemaleButton.setSelected(false);
		AddressField.clear();
		CityField.clear();
		StateBox.setValue("Alabama");
		ZipField.clear();
	}
	private boolean isInputValid(){
		String errorMessage = "";
		
		if (FirstNameField.getText() == null || FirstNameField.getText().length() == 0 || FirstNameField.getText().length()>50) {
            errorMessage += "No valid first name!(Must be under 50 letters)\n"; 
        }
		if (MiddleInitField.getText().length()!= 1){
			errorMessage += "No valid middle initial!(Must be 1 letter)\n";
		}
        if (LastNameField.getText() == null || LastNameField.getText().length() == 0 || LastNameField.getText().length()>50) {
            errorMessage += "No valid last name!(Must be under 50 letters)\n"; 
        }
        if (!(MaleButton.isSelected()) && !(FemaleButton.isSelected())){
        	errorMessage += "You must select a Gender!\n";
        }
        if (AddressField.getText()== null || AddressField.getText().length()== 0 || AddressField.getText().length()>50){
        	errorMessage += "No valid Address!(Must be under 50 characters)\n";
        }
        if (CityField.getText()==null || CityField.getText().length()== 0 || CityField.getText().length()>25){
        	errorMessage += "No valid City!(Must be under 25 characters)\n";
        }
        if (StateBox.getValue()== null || StateBox.getValue().length()== 0){
        	errorMessage +="You must select a state!\n";
        }
        if (ZipField.getText()==null || (ZipField.getText().length()!=5 && ZipField.getText().length()!=9)){
        	errorMessage +="No valid Zip Code!(Must be 5 or 9 digits long)\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        }else {
            errorLabel.setText(errorMessage);
        	return false;
        }

	}
}
