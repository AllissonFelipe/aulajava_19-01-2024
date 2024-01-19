// Importação de todos os itens da biblioteca SQL
import java.sql.*;
// Importação de todos os itens da biblioteca UTIL
import java.util.*;
// Declaração da Classe/Objeto InsertMySQL
public class InsertMySQL { // inicia Classe/Objeto

      /* 
     * Declação do metodo Executor main.
     * Public : Pode ser Invocado por outras Classes/Objetos.
     * Static : Não pode ser alterado ou sobrescritos.
     * Void : Um metodo sem retorno.
     * Strings[] : Pode ser invocados métodos do tipo String e Matrizes[].
     * args : porque podera ser invocado o objeto args da biblioteca java.lang
    */ 
    public static void main(String[] args) {
        // variavel scnLogin recebendo o Scanner da biblioteca Java.
        Scanner scnLogin = new Scanner(System.in);
        // variavel scnNome recebendo o Scanner da biblioteca Java.
        Scanner scnNome = new Scanner(System.in);
        // variavel scnSenha recebendo o Scanner da biblioteca Java.
        Scanner scnSenha = new Scanner(System.in);
        // variavel String 'status' sendo criada e a ela atribuida um valor.
        String status = "Nada aconteceu ainda";
        // comando [try] para tentar pegar uma exceção
        try { // inicia o [try]
            // informando ao usuario e o informando que esse programa é um cadastro de login.
            System.out.println("Bem vindo ao cadastro de login.");
            // perguntando ao usuario qual login que ira ser cadastrado.
            System.out.println("Digite o login que será cadastrado: ");
            // variavel String strLogin sendo criada e recebendo o Input do usuario.
            String strLogin = scnLogin.nextLine();
            // perguntando ao usuario que nome ira ser cadastrado.
            System.out.println("Digite o nome que será cadastrado: ");
            // variavel String 'strNome' sendo criada e a ela atribuido o Input do usuario.
            String strNome = scnNome.nextLine();
            // perguntando ao usuario que senha sera utilizado no cadastro.
            System.out.println("Digite a senha que será cadastrado: ");
            // variavel String 'strSenha' sendo criada e recebendo o valor do Input do usuario.
            String strSenha = scnSenha.nextLine();
            // variavel String 'strInsertMySQL' sendo criado e à ela atribuido o valor para inserir os dados no MySQL.
            String strInsertMySQL = "insert into `mysql_connector`.`tbl_login` (`login`,`nome`,`senha`) values ('" + strLogin + "','" + strNome + "','" + strSenha + "');";
            // variavel 'conn' recebendo o Objeto App e o metodo conectar(). Essa ação ira fazer a conexão com o banco de dados.
            Connection conn = App.conectar();
            // variavel 'stmSql' recebendo a conexão com o banco de dados e tambem uma criação de declaração.
            Statement stmSql = conn.createStatement();
            // variavel 'stmSql' recebendo a informação da variavel 'strInsertMySQL' que possui o comando para inserir as informações no banco de dados.
            stmSql.addBatch(strInsertMySQL);
            // variavel 'stmSql' executando todos os comandos que lhe foi atribuida.
            stmSql.executeBatch();
            // encerrando a variavel 'stmSql'
            stmSql.close();
            // variavel String 'status' sendo atribuido um novo valor.
            status = "Ok! Login inserido com sucesso";
        } // encerra o [try]
        // comando que pegou uma exceção
        catch (Exception e) { // inicia o [catch]
            // imprimindo ao usuario que ocorreu um erro e o informando qual erro foi.
            System.err.println("Ops! Ocorreu o erro " + e);
        } // encerrando o [catch]
        // fechando o Scanner
        scnLogin.close();
        // fechando o Scanner
        scnNome.close();
        // fechando o Scanner
        scnSenha.close();
        // imprimindo o status ao usuario.
        System.out.println(status);
    } // encerra o metodo executor
} // encerra a Classe/Objeto
