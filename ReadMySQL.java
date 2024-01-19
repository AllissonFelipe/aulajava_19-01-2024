// Importação de todos os itens da biblioteca SQL
import java.sql.*;
// Importação de todos os itens da biblioteca UTIL
import java.util.*;
// Declaração da Classe/Objeto InsertMySQL
public class ReadMySQL { // inicia Classe/Objeto

    /* 
     * Declação do metodo Executor main.
     * Public : Pode ser Invocado por outras Classes/Objetos.
     * Static : Não pode ser alterado ou sobrescritos.
     * Void : Um metodo sem retorno.
     * Strings[] : Pode ser invocados métodos do tipo String e Matrizes[].
     * args : porque podera ser invocado o objeto args da biblioteca java.lang
    */ 
    public static void main(String[] args) {
        // variavel String 'status' sendo criado e a ele atribuido um valor.
        String status = "Nada aconteceu ainda...";
        // comando para tentar pegar um exceção.
        try { // inicia o [try]
            // variavel 'conn' recebendo o Objeto App com o metodo conectar(). Onde a conexão com o banco de dados ira ser efetuada.
            Connection conn = App.conectar();
            // variavel 'scnInput' sendo atribuida um Scanner da biblioteca Java.
            Scanner scnInput = new Scanner(System.in);
            // Imprimindo ao usuario para fazer o login de verificação.
            System.out.println("Digite o login para verificação: ");
            // variavel String 'strBusca' sendo criado e a ela atribuida o Input do usuario.
            String strBusca = scnInput.nextLine();
            // variavel String 'strSqlSelect' criado e a ela atribuida o valor que ira procurar no banco de dados se a informação que o usuario digitou existe.
            String strSqlSelect = "select * from `mysql_connector`.`tbl_login` where `login` = '" + strBusca + "';";
            // variavel 'stmSql' criada e recebendo a conexão com o MySQL e criando uma declaração.
            Statement stmSql = conn.createStatement();
            // variavel rsSql recebendo o valor da variavel 'stmSql' com o comando para executar a declaração com o valor da variavel 'strSqlSelect'.
            ResultSet rsSql = stmSql.executeQuery(strSqlSelect);
            // variavel String 'nomes' criado e recebendo nenhum valor.
            String nomes = "";
            // criando um laço de repetição para atribuir valor na variavel 'nomes' caso a informação que o usuario digitou exista.
            while (rsSql.next()) { // inicia o [while]
                // se a informação existe no banco de dados a variavel 'nomes' recebera essa informação.
                nomes += "[" + rsSql.getString("nome") + "] ";
            } // encerra o [while]
            // variavel 'status' sendo atualizada e recebendo o valor da variavel 'nomes'
            status = "Nome(s): " + nomes;
            // variavel 'stmSql' sendo fechada.
            stmSql.close();
            // variavel 'rsSql' sendo fechado.
            rsSql.close();
            // Scanner sendo fechado.
            scnInput.close();
        } // encerra o [try]
        // comando que ira pegar a exceção.
        catch (Exception e) { // inicia o [catch]
            // Imprime para o usuario que ocorreu um erro e qual ele foi.
            System.out.println("Ops! Ocorreu o erro " + e);
        } // encerra o catch
        // imprime a variavel 'status' com o seu valor atual.
        System.out.println(status);
    } // encerra o metodo executor(main).
} // encerra o Objeto/Classe