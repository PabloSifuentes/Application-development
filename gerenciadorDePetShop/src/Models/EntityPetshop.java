package Models;

import java.util.Arrays;

public class EntityPetshop {

    private String[] cliente;
    private String[] Animal;
    private String[] tipoDeAnimal;
    private int[] CPF;
    private String[] tipoDeServiço;
    private String[] statusDoServiço;

    public EntityPetshop() {
    }

    public EntityPetshop(String[] cliente, String[] animal, String[] tipoDeAnimal, int[] CPF, String[] tipoDeServiço, String[] statusDoServiço) {
        this.cliente = cliente;
        this.Animal = animal;
        this.tipoDeAnimal = tipoDeAnimal;
        this.CPF = CPF;
        this.tipoDeServiço = tipoDeServiço;
        this.statusDoServiço = statusDoServiço;
    }

    public String[] getCliente() {
        return cliente;
    }

    public void setCliente(String[] cliente) {
        this.cliente = cliente;
    }

    public String[] getAnimal() {
        return Animal;
    }

    public void setAnimal(String[] animal) {
        Animal = animal;
    }

    public String[] getTipoDeAnimal() {
        return tipoDeAnimal;
    }

    public void setTipoDeAnimal(String[] tipoDeAnimal) {
        this.tipoDeAnimal = tipoDeAnimal;
    }

    public int[] getCPF() {
        return CPF;
    }

    public void setCPF(int[] CPF) {
        this.CPF = CPF;
    }

    public String[] getTipoDeServiço() {
        return tipoDeServiço;
    }

    public void setTipoDeServiço(String[] tipoDeServiço) {
        this.tipoDeServiço = tipoDeServiço;
    }

    public String[] getStatusDoServiço() {
        return statusDoServiço;
    }

    public void setStatusDoServiço(String[] statusDoServiço) {
        this.statusDoServiço = statusDoServiço;
    }
    @Override
    public String toString() {
        return "EntityPetshop{" +
                "cliente=" + Arrays.toString(cliente) +
                ", Animal=" + Arrays.toString(Animal) +
                ", tipoDeAnimal=" + Arrays.toString(tipoDeAnimal) +
                ", CPF=" + Arrays.toString(CPF) +
                ", tipoDeServiço=" + Arrays.toString(tipoDeServiço) +
                ", statusDoServiço=" + Arrays.toString(statusDoServiço) +
                '}';
    }
}

