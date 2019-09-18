package circuitDesignerApplication.model.logicGate;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.Component;
import circuitDesignerApplication.model.Conexion;

public class Or extends Component {
	public Or(int x, int y) {
        this(x, y, 2);
    }
	
	public Or(int x, int y, int n) {
		outConexion.insertFirst( Types.IO.Output);
		for (int i = 0; i < n; i++) {
			inConexion.insertFirst(new Conexion(Types.IO.Input));
			}
		}
	
	public Boolean getState() {
		return Primitives.AND(inConexion);
		}
	
	public String getName(){
		return "Or - "+ getGateInputs();
		}
	
	}
