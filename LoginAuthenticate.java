import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 * 
 * Luis Cervantes<br>
 * 10/18/16<br>
 * This program uses a do while loop, if else, switch case, counter and javafx.
 * 
 */

public class LoginAuthenticate extends Application {
		
	
	public void start(Stage primaryStage) {

		 int i=0;
		 while (i<3) {

		
		List<String> choices = new ArrayList<>();
			choices.add("Administrator");
			choices.add("Faculty");
			choices.add("Staff");
			choices.add("Student");
			choices.add("Guest"); 
			 			 			 
			 
		TextInputDialog inputDialog = new TextInputDialog();
		inputDialog.setTitle("Login");
		inputDialog.setHeaderText(null);
		inputDialog.setContentText("Enter Username");	
		Optional<String> result = inputDialog.showAndWait();		
		
		
		TextInputDialog inputDialog2 = new TextInputDialog();
		inputDialog2.setTitle("Login");
		inputDialog2.setHeaderText(null);
		inputDialog2.setContentText("Enter Password");	
		Optional<String> result2 = inputDialog2.showAndWait();
		
		String username = "Username";
		String pass = "Pass123";						
		
		
		if (result.get().equals(username) && result2.get().equals(pass)){
			
			ChoiceDialog<String> dialog = new ChoiceDialog<>(null, choices);
			dialog.setTitle("Login");
			dialog.setHeaderText("Welcome");
			dialog.setContentText("Select Account Type: ");
			Optional<String> login = dialog.showAndWait();
																												
			switch (login.get()) {
																																			
			case "Administrator":  case "Faculty": case "Staff": case "Student": case "Guest":
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login");
				alert.setHeaderText(null);
				alert.setContentText("Welcome " + login.get());
				alert.showAndWait();
				break;				
																																																																		
			default:
				System.exit(0);																																																																											
			}									
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login");
				alert.setHeaderText("Login Successful");
				alert.setContentText("Welcome Username!");
				alert.showAndWait();
				System.exit(0);
			
		}else if (result.get().equals(username) && !result2.get().equals(pass)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login");
			alert.setHeaderText("Login Unsuccessful");
			alert.setContentText("Invalid Password");
			alert.showAndWait();
			
		}else if (!result.get().equals(username) && result2.get().equals(pass)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login");
			alert.setHeaderText("Login Unsuccessful");
			alert.setContentText("Invalid Username");
			alert.showAndWait();
	
		}else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login");
			alert.setHeaderText("Login Unsuccessful");
			alert.setContentText("Invalid Username and Password");
			alert.showAndWait();
		
		}		
		
			i++;
			
		}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login");
			alert.setHeaderText("Too many failed login attempts");
			alert.setContentText("Contact an Administrator");
			alert.showAndWait();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
