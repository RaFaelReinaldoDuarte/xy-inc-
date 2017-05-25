# xy-inc-
teste Zup
Para inicializar os testes na aplicação deve-se seguir os seguintes passos.
1- Conexão com banco de dados : 
    ARQUIVO hibernate.properties dentro de src
    Banco de dados utilizado: Postgresql
2- Gerar banco de dados e dados de acordo com o teste: 
    Pacote FRAMEWORK.CONEXAO arquivo GeraTabelas.java (apenas executar)
    após execução, aparecerá no console 
    
    ******** INSERIDO ********
Lanchonete Posicao X: 27 Posicao Y: 12
Posto Posicao X: 31 Posicao Y: 18
Joalheria Posicao X: 15 Posicao Y: 12
Floricultura Posicao X: 19 Posicao Y: 21
Pub Posicao X: 12 Posicao Y: 8
Supermercado Posicao X: 23 Posicao Y: 6
Churrascaria Posicao X: 28 Posicao Y: 2
    ******** CRIADO COM SUCESSO ********

3- Forma de testar a aplicação segue exemplos de requisição
Método para: listar todos os locais
GET
http://localhost:8080/TesteZup/local/listarTodos
-----------------------------------------------------------------
Método para: adicionar um local
POST
http://localhost:8080/TesteZup/local/adicionarLocal
Content-Type: application/json
{"descricao":"academia","posicaoX":10,"posicaoY":6}
-----------------------------------------------------------------
Método para: verificar local próximo
POST
http://localhost:8080/TesteZup/local/localProximo
Content-type: application/json
{"posicaoX":10,"posicaoY":20}
