package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
                // Les montants ont été correctement additionnés  
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");              
	}
	//on n’imprime pas leticket si le montant inséré est insuffisant

	@Test
	void noTicketIfInsufficientAmount() {
		machine.insertMoney(PRICE - 1); // Insérer un montant inférieur au prix du billet
		assertFalse(machine.printTicket(), "Pas de ticket lorsque le montant est insuffisant");
	}
	@Test
	void TicketImprimer(){
		machine.insertMoney(PRICE);
		assertTrue(machine.printTicket(),"mantant sufisant");
	}

	// S5 : Quand on imprime un ticket, la balance est décrémentée du prix du ticket.







	}

