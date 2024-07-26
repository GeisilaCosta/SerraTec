package planoSaude;

public class ControlePagamento {
private double totalpago;

public double getTotalpago() {
	return totalpago;
}

public void setTotalpago(double totalpago) {
	this.totalpago = totalpago;
}
public void calcularTotalPago(Plano plano) {
	totalpago  += plano.getValorPago();
}

}
