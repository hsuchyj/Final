package rocket.app.view;

import java.net.URL;
import javax.swing.JOptionPane;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import eNums.eAction;
import exceptions.RateException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;
import rocketServer.RocketHub;

public class MortgageController {

	ObservableList<Integer> list = FXCollections.observableArrayList(15,30);

	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML TextField txtHouseCost;
	@FXML TextField txtDownPayment;

	@FXML ComboBox<Integer> cmbTerm;

	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;

	@FXML Label creditScoreLabel;
	@FXML Label houseCostLabel;
	@FXML Label downPaymentLabel;
	@FXML Label incomeLabel;
	@FXML Label expensesLabel;
	@FXML Label termLabel;

	@FXML Label calcPaymentLabel;
	@FXML Label paymentLabel;




	@FXML
	public void initialize()
	{
		cmbTerm.setValue(15);
		cmbTerm.setItems(list);

	}






	private TextField txtNew;

	private MainApp mainApp;


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


	@FXML
	public void btnCalculatePayment(ActionEvent event) throws RateException
	{
		LoanRequest lRequest = new LoanRequest();
		
		int score = Integer.parseInt(txtCreditScore.getText());
		double cost = Integer.parseInt(txtHouseCost.getText());
		double down = Integer.parseInt(txtDownPayment.getText());
		double income = Integer.parseInt(txtIncome.getText());
		double expenses = Integer.parseInt(txtExpenses.getText());
		
		lRequest.setiCreditScore(score);
		lRequest.setiTerm(cmbTerm.getSelectionModel().getSelectedItem().intValue());
		lRequest.setdAmount(cost-down);
		lRequest.setIncome(income);
		lRequest.setExpenses(expenses);
		
		mainApp.messageSend(lRequest);
		
		






	}

	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		
		
		double pt28 = (lRequest.getIncome()/12) * .28;
		double pt36 = ((lRequest.getIncome()/12) * .36) - lRequest.getExpenses();
		double pmt = lRequest.getdPayment();

		
		if(pt28 > pt36)
		{
			if(pmt > pt36)
			{
				JOptionPane.showMessageDialog(null,"House Cost too high");
			}
			else
			{
				paymentLabel.setText(pmt+"");
			}
		}

		if(pt36 > pt28)
		{
			if(pmt > pt28)
			{
				JOptionPane.showMessageDialog(null,"House Cost too high");
			}
			else
			{
				paymentLabel.setText(pmt+"");
			}
		}

		if(pt36 == pt28)
		{
			if(pmt > pt28)
			{
				JOptionPane.showMessageDialog(null,"House Cost too high");
			}
			else
			{
				paymentLabel.setText(pmt+"");
			}
		}
		
		
		

		

		


	}
}
