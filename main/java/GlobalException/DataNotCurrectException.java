package GlobalException;

public class DataNotCurrectException extends RuntimeException {
	private static final long serialVersionUID = 1L;
public DataNotCurrectException(String msg) {
	super(msg);
}
public DataNotCurrectException() {
	super();
}


}
