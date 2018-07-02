import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	Model model;
	View view;
	
	
	public void addModel(Model m){
		this.model = m;
	} //addModel()

	public void addView(View v){
		this.view = v;
	} //addView()
	
	public void initModel() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.notify();
		
	}

}
