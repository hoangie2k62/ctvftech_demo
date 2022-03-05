package demo.application.repository;

public interface IDFactory<ID> {

	ID createID(IRepository repository, String className, String symbol);
}
