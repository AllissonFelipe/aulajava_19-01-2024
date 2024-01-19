// Importação de todos os itens da biblioteca SQL
import java.sql.*;
// Importação de todos os itens da biblioteca UTIL
import java.util.*;
// Declaração da Classe/Objeto CreateMySQLInteract
public class CreateMySQLInteract { // inicia a Classe/Objeto

    /* 
     * Declação do metodo Executor main.
     * Public : Pode ser Invocado por outras Classes/Objetos.
     * Static : Não pode ser alterado ou sobrescritos.
     * Void : Um metodo sem retorno.
     * Strings[] : Pode ser invocados métodos do tipo String e Matrizes[].
     * args : porque podera ser invocado o objeto args da biblioteca java.lang
    */ 
    public static void main(String[] args) { // inicia o metodo [main]
        // variavel booleana sendo atribuida falsa.
        Boolean sair = false;
        // variaveis Strings. Variavel 'status' sendo atribuida.
        String SouN, tableName, strCreateTable, status = "Nada aconteceu ainda";
        // Scanner sendo criado para receber Input do Usuario
        Scanner scnTable = new Scanner(System.in);
        // Scanner sendo criado para receber Input do Usuario
        Scanner scnQtdCampos = new Scanner(System.in);
        // Scanner sendo criado para receber Input do Usuario
        Scanner scnCampos = new Scanner(System.in);
        // Scanner sendo criado para receber Input do Usuario
        Scanner scnSair = new Scanner(System.in);
        // variavel 'conn' recebendo o Objeto App com o metodo conectar(). 
        Connection conn = App.conectar();
        // variavel 'stmSql' recebendo valor nulo.
        Statement stmSql = null;
        // variavel 'colunas' tipo string sendo atribuida uma nova array a ela.
        List<String> colunas = new ArrayList<>();
        // variavel do tipo inteiro 'qtdCampos' sendo criado.
        int qtdCampos;
        // variavel String 'status' recebendo um texto.
        status = "Nada aconteceu ainda...";
        // imprimindo ao usuario e informando que esse programa é um criador de tabelas.
        System.out.println("Bem vindo ao criador de tabelas.");
        // criando um laço de repetição [ENQUANTO]. O laço ira acontecer ate a variavel 'sair' receber valor verdadeiro.
        while (sair == false) { // inicia o [while]
            // criação de um comando para tentar pegar uma exceção.
            try { // inicia o [try]
                // variavel 'stmSql' recebendo uma criação de declaração, sendo essa conectada ao MySQL
                stmSql = conn.createStatement();
                // imprimindo ao usuario que nome de tabela ele deseja.
                System.out.println("Digite o nome da tabela que deseja criar: ");
                // variavel 'tableName' recebendo o input do usuario que ele usou para nomear a tabela.
                tableName = scnTable.nextLine();
                // imprimindo ao usuario quantas colunas ele deseja criar.
                System.out.println("Digite a quantidade de campos (colunas) que deseja criar: ");
                // varivel 'qtdCampos' recebendo a quantidade que o usuario deseja criar.
                qtdCampos = scnQtdCampos.nextInt();
                // inicio do laço de repetição que ira acontecer ate a variavel inteira 'i' ser menor ou igual à quantidade de campos que o usuario deseja.
                for (int i = 1; i <= qtdCampos; i++) { // inicia o [for]
                    // imprimindo ao usuario para ele digitar os nome do campo(colunas).
                    System.out.println("Digite o nome do campo [" + i + "]: ");
                    // variavel 'colunas' recebendo os nomes que o usuario informou.
                    colunas.add(scnCampos.nextLine());
                } // encerra o [for]
                // varivel String 'strColunas' recebendo nenhum valor
                String strColunas = "";
                // criando um laço de repetição que ira acontecer ate a variavel inteira 'c' for menor que o tamanho da variavel 'colunas'
                for (int c = 0; c < colunas.size(); c++) { // inicia o [for]
                    // variavel strColunas recebendo ela mesma mais o index de colunas que a variavel 'c' esta indicando mais a propriedade 'VARCHAR(255) NULL' do MySQL
                    strColunas += "`" + colunas.get(c) + "` VARCHAR(255) NULL,";
                } // encerra [for]
                // variavel String 'strCreateTable' recebendo o comando para criar uma tabela no MySQL e as colunas que a variavel String 'strColunas' recebeu do array 'colunas'
                strCreateTable = "CREATE TABLE `mysql_connector`.`" + tableName + "`(`id` INT NOT NULL AUTO_INCREMENT, " + strColunas + " PRIMARY KEY (`id`));";
                // variavel 'stmSql' sendo adicionada a ela comandos com o valor da variavel String 'strCreateTable'
                stmSql.addBatch(strCreateTable);
                // variavel 'stmSql' executando os comandos que lhe foi atribuida.
                stmSql.executeBatch();
                // variavel 'stmSql' sendo fechada.
                stmSql.close();
                // imprimindo ao usuario se ele deseja criar outra tabela ou para encerrar o programa.
                System.out.println("Deseja criar outra tabela? Digite [s] para criar outra tabela ou [n] para encerrar.");
                // variavel 'SouN' recebendo o input do usuario com a sua resposta.
                SouN = scnSair.nextLine();
                // criando uma condição com a resposta SouN. O teste logico é verdadeiro se a variavel 'SouN' é igual a "n" ou a variavel 'SouN' é igual à "N".
                if (SouN.equals("n") || SouN.equals("N")) { // inicia o [if]
                    // se o teste logico for verdadeiro a variavel booleana 'sair' recebe verdadeiro e ira sair do primeiro laço de repetição.
                    sair = true;
                    // variavel String 'status' recebendo o valor informando que as tabelas foram criadas com sucesso.
                    status = "Tabela(s) criada(s) com sucesso.";
                } // encerra o [if]
            }// encerra o [try]
             catch (Exception e) { // inicia o [catch]
                // informando ao usuario que ocorreu um erro e qual foi esse erro.
                System.err.println("Ops! ocorreu o erro " + e);
            } // encerra o [catch]
            // imprimindo ao o usuario a variavel 'status'.
            System.out.println(status);
        } // encerra o primeiro laço de repetição
        // fechando o Scanner
        scnTable.close();
        // fechando o Scanner
        scnQtdCampos.close();
        // fechando o Scanner
        scnCampos.close();
        // fechando o Scanner
        scnSair.close();
    } // encerra o metodo executor.
}// encerra a Classe/Objeto