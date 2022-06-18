import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Please note: when using Lambda Expression below to config the button, we don't need to import these two classes below as they are omitted from the code, 
	//but when using Annoymous Inner Class method to config the button, we need to import these two classes. (see "// //Alternative method" section)
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;



public class TemperatureConverterGUI extends Application {

	public void start(Stage main_stage) {
		
		// 1. GUI
		//=======================================================

		//========add Label (i.e. pure text displayed on GUI)=============
		Label from_text = new Label("From: ");
		Label to_text = new Label("To: ");
		Label inputValue_text = new Label("Input Value: ");
		Label result_text = new Label(); //this is the result text after temp unit conversion, it will be displayed as a pure text on GUI. The default value is Null.


		//========add TextField (i.e. to collect user input text in a text box)===========
		TextField userInput = new TextField();


		//========add ComboBox==============
		//Drop down list (ComboBox) to select the unit of convert from/ convert to, i.e. from Celsius to Fahrenheit or vise versa. 
		ComboBox<String> convertFrom_unit = new ComboBox<>();  //ComboBox uses arraylist, so it has type parameter in <>
		ComboBox<String> convertTo_unit = new ComboBox<>();
		//add options to dropdown list in ComboBox
		convertFrom_unit.getItems().add("Fahrenheit");
		convertFrom_unit.getItems().add("Celsius");
		convertTo_unit.getItems().add("Fahrenheit"); 
		convertTo_unit.getItems().add("Celsius");
		//Alternatively, can use getItems().addAll("Fahrenheit", "Celsius") for convertFrom_unit and convertTo_unit

		//Select default item to show on the ComboBox when user first opening the GUI.
		convertFrom_unit.getSelectionModel().selectFirst(); //select first item as default item to show for convertFrom_unit comboBox
		convertTo_unit.getSelectionModel().selectLast(); //select last item as default item to show for convertTo_unit comboBox




		//========add button=============
		Button convertButton = new Button();
		convertButton.setText("Convert!");

		//========Config the button by implementing EventHandler functional interface============

		//Here we are able to use Lambda Expression method to complete the "handle" abstract method from EventHandler interface because it is a functional inteface
		convertButton.setOnAction (event -> {
			String userInput_temp = userInput.getCharacters().toString(); //convert userinput from textbox (TextField type) to a string type object.
			try {
				double temperature = Double.parseDouble(userInput_temp); //convert string to double
				String convertFrom_unit_text = convertFrom_unit.getValue(); //convert ComboBox type to String type
				String convertTo_unit_text = convertTo_unit.getValue();     //convert ComboBox type to String type
				double convert_result = convert(convertFrom_unit_text, convertTo_unit_text, temperature); //invoke "convert" method to run the algorithm to convert between different temperature unit
				result_text.setText(String.format("%.2f", convert_result)); //convert convert_result to string and only keeping 2 decimal places; Also assign the result string to result_text label defined above in "Add Label" section 
			}
			catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR); //create an Alert object (did not cover in this course)
				//Alert object can display an alert pop-up window, where programmer can set up customized text for alert window's title/header/content to display......
				alert.setTitle("Error Alert");
				alert.setHeaderText("Invalid Temperature");
				alert.setContentText("Your input is not a valid temperature.");
				alert.showAndWait(); //this is to pause the program until user to close the alert window

			}
		});


		//--------------------------------
		// //Alternative method: using the Annoymous Inner Class can also do the same as Lambda Expression. 
		// 	//But please note: for this method, we need to import "EventHandler" class and "ActionEvent" class because they are mentioned in the code. (Lambda Expression can omitted both so Lambda Expression doesn't need to import these two classes)

		// 	convertButton.setOnAction (new EventHandler<ActionEvent>() {

		// 		public void handle(ActionEvent event1) {
		// 	String userInput_temp = userInput.getCharacters().toString(); //convert userinput from textbox (TextField type) to a string type object.
		// 	try {
		// 		double temperature = Double.parseDouble(userInput_temp); //convert string to double
		// 		String convertFrom_unit_text = convertFrom_unit.getValue(); //convert ComboBox type to String type
		// 		String convertTo_unit_text = convertTo_unit.getValue();     //convert ComboBox type to String type
		// 		double convert_result = convert(convertFrom_unit_text, convertTo_unit_text, temperature); //invoke "convert" method to run the algorithm to convert between different temperature unit
		// 		result_text.setText(String.format("%.2f", convert_result)); //convert convert_result to string and only keeping 2 decimal places; Also assign the result string to result_text label defined above in "Add Label" section 
		// 	}
		// 	catch (NumberFormatException e) {
		// 		Alert alert = new Alert(Alert.AlertType.ERROR); //create an Alert object (did not cover in this course)
		// 		//Alert object can display an alert pop-up window, where programmer can set up customized text for alert window's title/header/content to display......
		// 		alert.setTitle("Error Alert");
		// 		alert.setHeaderText("Invalid Temperature");
		// 		alert.setContentText("Your input is not a valid temperature.");
		// 		alert.showAndWait(); //this is to pause the program until user to close the alert window

		// 	}

		// }
		// });
		//-------------------------------


		//========add Layouts and add those nodes defined above UNDER different Layouts===================

		//HBox is the horizontal layout pane, where it provides an easy way for arranging a series of nodes in a single row.

			//The first row is a HBox() that includes two child nodes: inputValue_text Label and user input text box (TextField userInput)
		HBox first_row = new HBox();
		first_row.setAlignment(Pos.CENTER);
		first_row.getChildren().add(inputValue_text);
		first_row.getChildren().add(userInput);
		//or use: .addAll(inputValue_text, userInput); to add both at once

			//The second row is a HBox() that includes 4 child nodes, from left to right: 
			//1. from_text Label; 2. convertFrom_unit ComboBox; 3. to_text Label; 4. convertTo_unit ComboBox;
		HBox second_row = new HBox();
		second_row.setAlignment(Pos.CENTER);
		second_row.setSpacing(10); //spacing between each child nodes in this row.
		second_row.getChildren().add(from_text);
		second_row.getChildren().add(convertFrom_unit);
		second_row.getChildren().add(to_text);
		second_row.getChildren().add(convertTo_unit);



		//VBox is the vertical layout pane, it is similar to the HBox layout pane, except that the nodes are arranged in a single column instead of a single row.

		//Here this single column of VBox() includes 4 child nodes, from top to bottom:
		//1. HBox 1 (first_row); 2. HBox 2 (second_row); 3. convertButton Button object; 4. result_text Label;

		//VIP Note: here we can see a layout can actually has other layout(s) as its child (e.g. VBox has 2 HBox as its child nodes here)

		VBox root = new VBox(); //By common practice, we'd like to name the highest parent node in Scene Graph as the "root" (here VBox node is in the highest position in the hierarchy of this Scene Graph because it is the parent of all other nodes defined so far), but you can name it whatever you want here.
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);//spacing between each direct child nodes of this VBox node
		root.getChildren().add(first_row);
		root.getChildren().add(second_row);
		root.getChildren().add(convertButton);
		root.getChildren().add(result_text);
		// or use: .addAll(first_row,second_row,convertButton,result_text); to add all child nodes all at once


		//========Add Layout to Scene and Add Scene to Stage=============
		Scene main_scene = new Scene(root, 400, 400); //400, 400 is the size of the Scene
		main_stage.setTitle("Temperature Converter Program GUI");
		main_stage.setScene(main_scene);
		main_stage.show();
 
		//=======================================================

	}


	private double convert(String convert_from, String convert_to, double input_value) {
		//2. convertion method: convert temperature from one unit to the other unit, given input value

		double converted = 0;
		if (convert_from.equals(convert_to)) {
			converted = input_value; //if unit to convert from is the same as unit to convert to, then output value should be the same as input value. 
		}
		else if (convert_from.charAt(0) == 'F') { //it means convert_from unit's first character is "F", which means unit to convert from is "Fahrenheit"; Otherwise it is "Celsius"
			converted = (input_value - 32) * (5.0 / 9); //Fahrenheit to Celsius conversion formula
		}
		else {
			converted = input_value * (9.0 / 5) + 32; // Celsius to Fahrenheit conversion formula
		}
		return converted;
	}


}