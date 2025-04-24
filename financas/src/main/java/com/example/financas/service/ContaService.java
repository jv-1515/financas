package com.example.financas.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.financas.model.Conta;

@ApplicationScope  //Anotação para persistência de dados, qualquer alteração reflete em toda aplicação. Todos que acessarem poderão ver tudo.
public class ContaService {

    private static List<Conta> contas = new ArrayList<>();
    // Acesso ao banco de dados
    public ContaService() { }

    public void add(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getAll() { 
        return contas; 
    }

    public Conta get(Conta conta) {
        for (Conta c : contas) {
            //if (c.equals(conta)) {
            if (c.getNumero().equals(conta.getNumero())) {
            return c;
            }
        }
        return null;
    }

    public Conta get(Integer numero) {
        return get(new Conta(numero));
    }
    
    @Override
    public String toString() {
        return contas.toString();
    }

    public boolean update(Conta conta) {
        Conta _conta = get(conta);
        if (_conta != null) {
            _conta.setTitular(conta.getTitular());
            _conta.setBanco(conta.getBanco());
            _conta.setAgencia(conta.getAgencia());
            return true;
        }
        return false;
    }

    public boolean delete(Integer numero) {
        Conta _conta = get(numero);
        if (_conta != null) {
            contas.remove(_conta);
            return true;
        }
        return false;
    }

}
