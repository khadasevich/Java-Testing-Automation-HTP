package entity;

public interface Function<Engineer, Result> {

    Result apply(Engineer engineer);
}
