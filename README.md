## Instituto Federal do Ceará  
Engenharia de Computação  
Programação Paralela e Distribuída  
2018.2  
Prof. Cidcley T. de Souza (cidcley@gmail.com)  

### Projeto de Web Services e MOM  

**Objetivo:** Implementar o WSChat: um serviço de chat utilizando web services e middleware orientado à mensagens

O WSChat é um serviço que permite usuários criar um chat através de um web service. Para tanto, os seguintes métodos devem ser implementados:  

• AddUser: Permite adicionar um usuário no chat assim que ele realiza o login;  
• GetUser: Permite retornar os usuários disponíveis para conversar e seu status atual (online ou offline);  
• RemoveUser: Permite a remoção de um usuário do chat, assim que ele realizar logout da aplicação;  
• SendMessage: Permite o envio e mensagens para algum usuário do chat;  
• ReceiveMessage: Permite o recebimento de mensagens para algum usuário do chat;  

As seguintes funcionalidades devem ser implementadas:  

• Os usuários devem realizar login no chat, passando seu nome (que não podem ser repetidos). Nesse momento uma fila deve ser criada no servidor MOM para
registrar esse usuário.  
• Os usuários devem realizar logout no chat, sendo sua referências retiradas do chat e, portanto, sua fila deve ser removida.  
• Os usuários devem poder enviar mensagens para um ou mais usuários. Nesse caso, as mensagens devem entrar nas filas MOM de cada um dos usuários
destinos.  
• O servidor de chat deve ser visitado a cada 2s para verificar a existência de novos usuários e de novas mensagens.  

### Atenção:

Todo o gerenciamento de usuários e mensagens deve ser realizado
**EXCLUSIVAMENTE** através de filas de mensagens MOM. Ou seja, não deve haver
nenhuma estrutura de dados interna ao WS que armazene nem mensagens nem
usuários. Caso seja usado alguma estrutura de dados interna as respectivas
funcionalidades não serão consideradas.  

### Critérios de Avaliação

Gui do Cliente do Chat (0-10);  
Interfaces e implementação do WSChat(0-10);  
Implementação de Funcionalidades do WSChat(0-10);  

**Trabalho Individual**  
**Data de Entrega:** 12/12 (ÚNICA ENTREGA)  
**Endereço de Envio:** http://tinyurl.com/gnthrbw  

Obs: O semestre finaliza oficialmente no dia 18/12.  

**Observações:**  
1. **TODOS** os trabalhos só serão aceitos se apresentados **pessoalmente** pelo
aluno na sala de aula na data final de entrega ou, em casos excecionais, a
combinar com o professor.  
2. **TODOS** os trabalhos só serão recebidos através do link até às 12h da data de
entrega.  
3. **Não serão aceitos** trabalhos enviados de qualquer outra forma.  
4. Devem ser entregues **TODOS** os códigos.  
5. Deverá ser entregue, se a linguagem de programação permitir, um código
executável (.jar, .exe, etc).  
