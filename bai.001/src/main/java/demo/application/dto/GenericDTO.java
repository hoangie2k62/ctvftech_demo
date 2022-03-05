package demo.application.dto;

public abstract class GenericDTO<E> {

	public GenericDTO(E entity) {
		
		init(entity);
	}
	
	public abstract void init(E entity);
	
	public abstract E toEntity();
}
