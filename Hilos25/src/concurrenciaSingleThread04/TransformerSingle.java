package concurrenciaSingleThread04;

public class TransformerSingle {
	
	
	public TransformerSingle() {
		super();
	}
	
	public void change(Element element) {
		element.value++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
