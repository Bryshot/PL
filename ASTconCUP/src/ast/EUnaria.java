package ast;

public abstract class EUnaria extends E {
    public E exp(){throw new UnsupportedOperationException("exp");}
    public abstract TipoE tipo();

}
