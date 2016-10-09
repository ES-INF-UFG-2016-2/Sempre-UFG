package br.ufg.inf;

import br.ufg.inf.modelo.AprovDivulgEvent;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AprovDivulgEventTest {

	@Test
	public void testValidoTrue0() {

		int valido = 0;
		boolean aprovada = true;

		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Evento divulgado aos egressos.", a.aprovDivulgEvent(valido, aprovada));

	}

	@Test
	public void testValidoTrue1() {

		int valido = 1;
		boolean aprovada = true;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Evento divulgado aos egressos.", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testValidoTrue49() {
		int valido = 49;
		boolean aprovada = true;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Evento divulgado aos egressos.", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testInvalidoTrue50() {

		int valido = 50;
		boolean aprovada = true;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("id_evento n�o pode ser maior que lista.length().", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testValidoFalse0() {

		int valido = 0;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Parecer encaminhado �s partes interessadas.", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testValidoFalse1() {

		int valido = 1;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Parecer encaminhado �s partes interessadas.", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testValidoFalse49() {
		int valido = 49;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Parecer encaminhado �s partes interessadas.", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testInvalidoFalse50() {

		int valido = 50;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("id_evento n�o pode ser maior que lista.length().",

				a.aprovDivulgEvent(valido, aprovada));
	}

	@Test
	public void testInvalidoMinus1() {

		int invalido = -1;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("id_evento n�o pode ser menor que 0.", a.aprovDivulgEvent(invalido, aprovada));
	}

	@Test
	public void testInvalidoMinInt() {

		int invalido = -2147483648;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("id_evento n�o pode ser menor que 0.", a.aprovDivulgEvent(invalido, aprovada));

	}

	@Test @Ignore
	public void testValidoTipoParametro() {

		Integer valido = 10;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("Tipo de id_evento deve ser Integer.", a.aprovDivulgEvent(valido, aprovada));
	}

	@Test @Ignore
	public void testInvalidoNullParam() {

		Integer valido = 10;
		boolean aprovada = false;
		AprovDivulgEvent a = new AprovDivulgEvent();
		assertEquals("id_evento n�o pode ser null.", a.aprovDivulgEvent(valido, aprovada));
	}





}
