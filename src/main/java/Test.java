import java.util.ArrayList;
import java.util.List;

import modelo.dao.DAOFactory;
import modelo.entidades.Banco;
import modelo.entidades.CuentaBancaria;
import modelo.entidades.Persona;

public class Test {

	public static void main(String[] args) {
		populateData();
		queryData();
	}
	
	public static void populateData() {
		
		Banco b1 = new Banco();
		b1.setNombreBanco("Banco de Ciudad Central");
		
		Persona p = new Persona();
		p.setNombre("Kenneth");
		p.setClave("1234");
		
		CuentaBancaria cuenta1 = new CuentaBancaria();
		cuenta1.setNumero("202500251");
		cuenta1.setPropietario(p);
		cuenta1.setBanco(b1);
		
		CuentaBancaria cuenta2 = new CuentaBancaria();
		cuenta2.setNumero("202502630");
		cuenta2.setPropietario(p);
		cuenta2.setBanco(b1);
		
		CuentaBancaria cuenta3 = new CuentaBancaria();
		cuenta3.setNumero("202502648");
		cuenta3.setPropietario(p);
		cuenta3.setBanco(b1);
		
		List<CuentaBancaria> cuentas = new ArrayList<>();
		cuentas.add(cuenta3);
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		
		b1.setCuentas(cuentas);
		
		DAOFactory.getFactory().getBancoDAO().create(b1);
	}
	
	public static void queryData() {
		Banco b = DAOFactory.getFactory().getBancoDAO().getById(1);
		System.out.println(b);
		for(CuentaBancaria c : b.getCuentas()) {
			System.out.println(c);
			System.out.println(c.getPropietario());
		}
	}

}
