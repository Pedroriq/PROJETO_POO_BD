package br.inatel.project.data;

import br.inatel.project.produtos.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class auxData extends Database {


    //realiza a primeira conexão com o banco de dados
    @Override
    public boolean connect(String password) {
        return super.connect(password);
    }

    //é inseridos os produtos
    public boolean insertProduto(newProduto produto, String password) {
        connect(password);
        String sql = "INSERT INTO produto() VALUES(?,?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setFloat(1, produto.getId());// concatena nome na primeira ? do comando
            pst.setString(2, produto.getProduto());
            pst.setFloat(3, produto.getPreco());
            pst.setInt(4, produto.getEstoque());
            pst.execute();                            // executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }


    //realiza a busca na tabela produtos
    public ArrayList<newProduto> researchProduto(String senha) {
        connect(senha);
        ArrayList<newProduto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                newProduto produtoTemp = new newProduto(result.getInt("idProduto"), result.getString("produto"), result.getFloat("precoProduto"), result.getInt("estoque"));
                float idSelect = produtoTemp.getId();
                String produtoSelect = produtoTemp.getProduto();
                float precoSelect = produtoTemp.getPreco();
                int estoqueSelect = produtoTemp.getEstoque();
                produtos.add(produtoTemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return produtos;

    }

    //Update de estoque, adicionar nova quantidade em alguma item existente
    public boolean updateEstoque(newProduto produto, String senha, int newEstoque) {
        connect(senha);
        String sql = "UPDATE produto SET estoque=? WHERE idProduto=?";
        try {
            pst = connection.prepareStatement(sql);
            int calcular = produto.getEstoque() + newEstoque;

            pst.setInt(1, calcular);
            pst.setInt(2, produto.getId());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;


    }

    //Alteração no estoque quando é realizado a venda
    public boolean updateVendaEstoq(newProduto produto, String senha, int newEstoque) {
        connect(senha);
        String sql = "UPDATE produto SET estoque=? WHERE idProduto=?";
        try {
            pst = connection.prepareStatement(sql);
            int calcular = produto.getEstoque() - newEstoque;

            pst.setInt(1, calcular);
            pst.setFloat(2, produto.getId());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;


    }

    //Inserir venda com suas respectivas caracteristicas
    public boolean insertVenda(newProduto produto, String password, float valorTotal, int idVendedor, int cpfCliente) {
        connect(password);

        String sql = "INSERT INTO venda(idVenda, valorTotal, data,vendaProd, vendedor_idVendedor,cliente_numCadastro) VALUES(default ,?,?,?,?,?)";
        try {
            String local = String.valueOf(LocalDate.now());
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, valorTotal);// concatena nome na primeira ? do comando
            pst.setString(2, local);
            pst.setString(3, produto.getProduto());
            pst.setInt(4, idVendedor);
            pst.setInt(5, cpfCliente);

            pst.execute();// executa o comando
            check = true;
            String sql2 = "INSERT INTO `store`.`venda_has_produto`() VALUES (default ,?)";
            try {
                pst = connection.prepareStatement(sql2);
                pst.setInt(1, produto.getId());// concatena nome na primeira ? do comando
                pst.execute();// executa o comando
                check = true;
            } catch (SQLException e) {
                System.out.println("Erro de operação: " + e.getMessage());
                check = false;
            } finally {
                try {
                    connection.close();
                    pst.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

        return check;
    }


    //insere um novo vendedor na empresa
    public boolean insertVendedor(newVendedor vendedor, String password) {
        connect(password);
        String sql = "INSERT INTO vendedor(nome, cpf) VALUES(?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, vendedor.getNome());// concatena nome na primeira ? do comando
            pst.setString(2, vendedor.getCpf());
            pst.execute();                            // executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    //cadastro de clientes
    public boolean insertCliente(newCliente cliente, String password) {
        connect(password);
        String sql = "INSERT INTO cliente(numCadastro, nomeCliente, enderecoCliente) VALUES(default ,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNome());// concatena nome na primeira ? do comando
            pst.setString(2, cliente.getEndereco());
            pst.execute();                            // executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    //busca de clientes
    public ArrayList<newCliente> researchCliente(String senha) {
        connect(senha);
        ArrayList<newCliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                newCliente clienteTemp = new newCliente(Integer.parseInt(result.getString("numCadastro")),result.getString("nomeCliente"), result.getString("enderecoCliente"));
                clientes.add(clienteTemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return clientes;

    }

    //busca de vendedores
    public ArrayList<newVendedor> researchVendedor(String senha) {
        connect(senha);
        ArrayList<newVendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                newVendedor vendedorTemp = new newVendedor(result.getString("nome"), result.getString("cpf"));
                vendedorTemp.setIdVendedor(result.getInt("idVendedor"));
                vendedores.add(vendedorTemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return vendedores;

    }

    //busca das vendas
    public ArrayList<mostraInfoVenda> researchVenda(String senha) {
        connect(senha);
        ArrayList<mostraInfoVenda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                mostraInfoVenda vendaTemp = new mostraInfoVenda(result.getInt("idvenda"), result.getFloat("valorTotal"), result.getString("vendaProd"), result.getInt("vendedor_idvendedor"), result.getInt("cliente_numCadastro"));
                vendas.add(vendaTemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return vendas;

 }


    }
