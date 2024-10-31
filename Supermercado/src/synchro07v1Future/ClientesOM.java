package synchro07v1Future;

import java.util.Optional;
import java.util.Random;

public class ClientesOM {

	public static Optional<Cliente> getRandomClient() {
		return Optional.of(new Cliente("cliente "+new Random().nextInt(100), new int[] {1,1,1}));
	}
	public static Optional<Cliente> getRandomClientOptionalNullable() {
		Cliente retorno=new Cliente("cliente "+new Random().nextInt(100), new int[] {1,1,1});
		return new Random().nextBoolean()?Optional.ofNullable(retorno):Optional.ofNullable(null);
	}
}
