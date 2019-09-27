package circuitDesignerApplication.model.logicGate;

import java.util.ArrayList;

import circuitDesignerApplication.model.Component;
import circuitDesignerApplication.model.Conexion;
import circuitDesignerApplication.model.dataStructure.LinkedList;


public class Primitives {
	
	public static Boolean XOR(LinkedList<Conexion> inConexion) {
        Boolean state;
        int trueCount = 0;
        for (Conexion inCon : inConexion) {
            state = inCon.getState();
            if (state == null) {
                state = Component.getPullState();
            }
            if (state == true) {
                trueCount++;
            }
        }
        if (trueCount % 2 == 0) {
            return false;
        }
        return true;
    }

    public static Boolean AND(LinkedList<Conexion> inConexion) {
        Boolean state;
        for (Conexion inCon : inConexion) {
            state = inCon.getState();
            if (state == null) {
                state = false;
            }
            if (state == false) {

                return false;
            }
        }
        return true;
    }

    public static Boolean OR(LinkedList<Conexion> inConexion) {
        Boolean state;
        for (Conexion inCon : inConexion) {
            state = inCon.getState();
            if (state == null) {
                state = Component.getPullState();
            }
            if (state == true) {
                return true;
            }
        }
        return false;
    }

    public static Boolean NOT(Boolean in) {
        if(in == null) {
        	return null;
        }
        if (in == false) {
            return true;
        } else {
            return false;
        }
    }
    public static Boolean NAND(LinkedList<Conexion> inConexion) {
        return NOT(AND(inConexion));
    }
    public static Boolean NOR(LinkedList<Conexion> inConexion) {
        return NOT(OR(inConexion));
    }
    public static Boolean XNOR(LinkedList<Conexion> inConexion) {
        return NOT(XOR(inConexion));
    }
}

