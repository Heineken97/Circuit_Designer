package circuitDesignerApplication.model.logicGate;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.Component;
import circuitDesignerApplication.model.Conexion;

public class Not extends Component {
	
	public Not(int x, int y) {
        this(x, y, 2);
    }

    public Not(int x, int y, int n) {
        this.setGateInputs(n);

        outConexion.insertFirst(new Conexion(Types.IO.Output));
        for (int i = 0; i < n; i++) {
            inConexion.insertFirst(new Conexion(Types.IO.Input));
        }
    }
    
    public Boolean getState() {
        return Primitives.AND(inConexion);
    }
    
    public String getName(){
        return "Not - "+ getGateInputs();
    }


}
