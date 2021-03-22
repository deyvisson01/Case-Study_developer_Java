import java.util.Scanner;
import java.io.*;
public class MainClient {
    public static int countIDMsg = 0;
    public static void main(String[] args) {
        int op = -1;
        Scanner sc = new Scanner(System.in);
        Scanner scMenu = new Scanner(System.in);
        Scanner scPrice = new Scanner(System.in);
        Scanner scQuantidade = new Scanner(System.in);
        Functions functions = new Functions();

        while (true){
            System.out.println("    OPÇÕES DE GERENCIAMENTO:
                                [1] : Área do vendedor\n
                                [2] : Área da administração\n
                                ");

            System.out.print("Digite: ");
            op = sc.nextInt();

            switch (op){
                case 1: // INÍCIO DA ÁREA DO VENDEDOR
                    System.out.println("    OPÇÕES DE GERENCIAMENTO:
                                [1] : Inserir venda\n
                                [2] : Listar suas vendas\n
                                [3] : Retornar ao início\n
                                ");
                    System.out.print("Digite: ");
                    op = sc.nextInt();

                    switch (op){
                        case 1: // INÍCIO DA OPÇÃO DE INSERÇÃO DE VENDA - VENDEDOR
                        String code_seller = "";
                        String cliente = "";
                        String cod_product = "";
                        String quantidade = "";
                        String valor_final = "";
                        System.out.println("INSIRA OS DADOS PARA VENDA!\n");
                        System.out.println("Código do vendedor ->");
                        code_seller = scMenu.nextLine();

                        System.out.println("Cliente ->");
                        cliente = scMenu.nextLine();

                        System.out.println("Código do produto ->");
                        cod_product = scMenu.nextLine();

                        System.out.println("Quantidade ->");
                        quantidade = scQuantidade.nextInt();

                        System.out.println("Valor final da venda ->");
                        valor_final = scMenu.nextLine();

                        if(functions.isCodeListSellers(code_seller)){
                            OccurrenceBoletin bo = new OccurrenceBoletin(code_sale,code_seller,cliente,cod_product,quantidade,valor_final);
                            functions.ListBO.add(bo);
                            Message msgTosend = new Message(0,countIDMsg,"addBO",3,"-",bo);
                            functions.doOperation(msgTosend);
                            System.out.println("-> Completo <-");
                            break;
                        }else{
                            System.out.println("! Vendedor não cadastrado !");
                        }

                            break;
                        case 2: // LISTAGEM DE VENDAS

                        System.out.println("    OPÇÕES DE ALTERAÇÃO DE VENDAS:
                                [1] : Editar venda\n
                                [2] : Deletar venda\n
                                [5] : Retornar ao início\n
                                ");
                        op = sc.nextInt();
                            // INÍCIO DA OPÇÃO DE EDIÇÃO DE VENDA - VENDEDOR
                            switch (op){
                                case 1: // 
                                String code_sale = "";
                                String code_seller = "";
                                String cliente = "";
                                String cod_product = "";
                                String quantidade = "";
                                String valor_Final = "";
                                System.out.println("INSIRA OS DADOS PARA A NOVA VENDA!\n");
                                System.out.println("Código da venda ->");
                                code_sale = scMenu.nextLine();

                                System.out.println("Código do vendedor ->");
                                code_seller = scMenu.nextLine();

                                System.out.println("Cliente ->");
                                cliente = scMenu.nextLine();

                                System.out.println("Código do produto ->");
                                cod_product = scMenu.nextLine();

                                System.out.println("Quantidade ->");
                                quantidade = scQuantidade.nextInt();

                                System.out.println("Valor final da venda ->");
                                valor_Final = scMenu.nextLine();

                                if(functions.isCodeListSellers(code_seller)){
                                    OccurrenceBoletin bo = new OccurrenceBoletin(code_sale,code_seller,cliente,cod_product,quantidade,valor_final);
                                    functions.ListBO.add(bo);
                                    Message msgTosend = new Message(0,countIDMsg,"addBO",3,"-",bo);
                                    functions.doOperation(msgTosend);
                                    System.out.println("-> Completo <-");
                                    break;
                                }else{
                                    System.out.println("! Vendedor não cadastrado !");
                                }
                                    
                                    break;
                                case 2: // INÍCIO DA OPÇÃO DE DELETAR VENDA - VENDEDOR
                                System.out.println("-> Deletar venda <-");
                                System.out.print("Código: ");
                                NomeV = scMenu.nextLine();
                                    break;
                                case 3: // 
                                    
                                    break;
                                default:
                                    System.out.println("-> Opção inválida <-");
                                    break;
                            }
                            break;
                        case 3: // 
                            
                            break;
                        default:
                            System.out.println("-> Opção inválida <-");
                            break;
                    }

                    break;
                case 2: // INÍCIO DA ÁREA DO ADMINISTRADOR
                    System.out.println("    OPÇÕES DE GERENCIAMENTO ADMINISTRATIVAS:
                                    [1] : Inserir vendedor\n
                                    [2] : Inserir produto\n
                                    [3] : Listar vendedores e o valor de suas vendas mensais\n
                                    [4] : Listar todas as vendas\n
                                    [5] : Retornar ao início\n
                                    ");
                    op = sc.nextInt();
                        switch (op){
                            case 1: // INÍCIO DA OPÇÃO DE INSERIR VENDEDOR
                            String NameSeller = "";
                            String CPFV = "";
                            System.out.println("-> Cadastro de Vendedor <-");
                            System.out.print("Nome: ");
                            NomeV = scMenu.nextLine();
                            System.out.print("CPF: ");
                            CPFV = scMenu.nextLine();

                            functions.ListSellers.add(new Person(NomeV,CPFV));
                            System.out.println("-> Completo <-");
                                
                                break;
                            case 2: // INÍCIO DA OPÇÃO DE INSERIR PRODUTO
                            String descricao = "";
                            String preco = "";
                            System.out.println("INSIRA OS DADOS PARA ADICIONAR UM NOVO PRODUTO\n");
                            System.out.println("Descrição ->");
                            descricao = scMenu.nextLine();
    
                            System.out.println("Preço ->");
                            preco = scMenu.nextLine();
    
                            
                                break;
                            case 3: // 
                                
                                break;
                            case 4: // LISTAGEM DE VENDAS

                            System.out.println("    OPÇÕES DE ALTERAÇÃO DE VENDAS:
                                    [1] : Editar venda\n
                                    [2] : Deletar venda\n
                                    [5] : Retornar ao início\n
                                    ");
                            op = sc.nextInt();
                                // INÍCIO DA OPÇÃO DE EDIÇÃO DE VENDA - ADMINISTRADOR
                                switch (op){
                                    case 1: // 
                                        
                                    String code_sale = "";
                                    String code_seller = "";
                                    String cliente = "";
                                    String cod_product = "";
                                    String quantidade = "";
                                    float quantidade = "";
                                    System.out.println("INSIRA OS DADOS PARA A NOVA VENDA!\n");
                                    System.out.println("Código da venda ->");
                                    code_sale = scMenu.nextLine();

                                    System.out.println("Código do vendedor ->");
                                    code_seller = scMenu.nextLine();

                                    System.out.println("Cliente ->");
                                    cliente = scMenu.nextLine();

                                    System.out.println("Código do produto ->");
                                    cod_product = scMenu.nextLine();

                                    System.out.println("Quantidade ->");
                                    quantidade = scQuantidade.nextInt();

                                    System.out.println("Valor final da venda ->");
                                    price = scMenu.nextLine();

                                        break;
                                    case 2: //
                                    System.out.println("-> Deletar venda <-");
                                    System.out.print("Código: ");
                                    NomeV = scMenu.nextLine();
                                        break;
                                    case 3: // 
                                        
                                        break;
                                    default:
                                        System.out.println("-> Opção inválida <-");
                                        break;
                                }
                                break;
                            default:
                                System.out.println("-> Opção inválida <-");
                                break;
                        }
                    break;
                case 3: 
                    
                    break;
                default:
                    System.out.println("-> Opção inválida <-");
                    break;
            }
        }
    }
}