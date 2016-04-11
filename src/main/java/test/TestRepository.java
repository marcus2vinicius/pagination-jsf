package test;

import repository.InterfaceUsuarioRepositoty;
import repository.UsuarioRepositoryInDataBase;
import repository.UsuarioRepositoryInMemory;

/**
 * Created by marcus on 10/04/16.
 */
public class TestRepository {
    public static void main(String[] args) {
        emMemoria();
        emBancoDeDados();
    }

    private static void emBancoDeDados() {
        InterfaceUsuarioRepositoty repositoty = new UsuarioRepositoryInDataBase();
        long count = repositoty.count();
        repositoty.findPagination(1,10).forEach(System.out::println);
    }

    private static void emMemoria() {
        InterfaceUsuarioRepositoty repositoty = new UsuarioRepositoryInMemory();
        long count = repositoty.count();
        repositoty.findPagination(1,10).forEach(System.out::println);

    }
}
