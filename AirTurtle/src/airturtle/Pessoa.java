/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;
//

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ronnie
 */
public class Pessoa implements Serializable {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String celular;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String email, String telefone, String celular, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCampos(List<Object> campos) throws NumberFormatException, CPF_InvalidoException {
        this.setNome(campos.get(0).toString());
        this.setCpf(campos.get(1).toString());
//        if (validarCPF((campos.get(1).toString()))) {
//            this.setCpf(campos.get(1).toString());
//        } else {
//            throw new CPF_InvalidoException("CPF Inv�lido!");
//        }

        this.setEmail(campos.get(2).toString());
        this.setTelefone(campos.get(3).toString());
        this.setCelular(campos.get(4).toString());
    }

    private boolean validarCPF(String string) {

        String strCpf = cpf;
        if (strCpf.equals("")) {
            return false;
        }

        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount))
                    .intValue();

            // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
            // e assim por diante.
            d1 = d1 + (11 - nCount) * digitoCPF;

            // para o segundo digito repita o procedimento incluindo o primeiro
            // digito calculado no passo anterior.
            d2 = d2 + (12 - nCount) * digitoCPF;
        }

        // Primeiro resto da divis�o por 11.
        resto = (d1 % 11);

        // Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
        // menos o resultado anterior.
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        // Segundo resto da divis�o por 11.
        resto = (d2 % 11);

        // Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
        // menos o resultado anterior.
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        // Digito verificador do CPF que est� sendo validado.
        String nDigVerific = strCpf.substring(strCpf.length() - 2,
                strCpf.length());

        // Concatenando o primeiro resto com o segundo.
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        // comparar o digito verificador do cpf com o primeiro resto + o segundo
        // resto.
        return nDigVerific.equals(nDigResult);

    }
}
