package Models;

import java.util.Arrays;

public class EntityPetshop {

    private String cliente;
    private String animal;
    private String tipoDeAnimal;
    private int CPF;
    private int tipoDeServico;
    private int statusDoServico;

    public EntityPetshop() {
    }
    public EntityPetshop(String cliente, String animal, String tipoDeAnimal, int CPF, int tipoDeServico, int statusDoServico) {
        this.cliente = cliente;
        this.animal = animal;
        this.tipoDeAnimal = tipoDeAnimal;
        this.CPF = CPF;
        this.tipoDeServico = tipoDeServico;
        this.statusDoServico = statusDoServico;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getTipoDeAnimal() {
        return tipoDeAnimal;
    }

    public void setTipoDeAnimal(String tipoDeAnimal) {
        this.tipoDeAnimal = tipoDeAnimal;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(int tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public int getStatusDoServico() {
        return statusDoServico;
    }

    public void setStatusDoServico(int statusDoServico) {
        this.statusDoServico = statusDoServico;
    }
    @Override
    public String toString() {
        return "EntityPetshop{" +
                "cliente='" + cliente + '\'' +
                ", animal='" + animal + '\'' +
                ", tipoDeAnimal='" + tipoDeAnimal + '\'' +
                ", CPF=" + CPF +
                ", tipoDeServico='" + tipoDeServico + '\'' +
                ", statusDoServico='" + statusDoServico + '\'' +
                '}';
    }
}